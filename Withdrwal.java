
package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Withdrwal extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdrawl, back;
    String pin;
    
    
        Withdrwal(String pin){
            this.pin = pin;
            setLayout(null);
            
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
             image.setBounds(0,0,900,900);
               add(image);
        
               JLabel text = new JLabel("ENTER YOUR WITHDRAWL AMOUNT");
               text.setForeground(Color.WHITE);
               text.setFont(new Font("System", Font.BOLD,16));
               text.setBounds(170,300,400,20);
               image.add(text);
               
                amount = new JTextField();
              amount.setFont(new Font("System", Font.BOLD,22));
               amount.setBounds(170,350,320,25);
               image.add(amount);
               
             withdrawl = new JButton("WITHDRAW");
               withdrawl.setBounds(355,485,150,30);
                 withdrawl.addActionListener(this);
                 image.add(withdrawl);
                 
              back = new JButton("BACK");
                 back.setBounds(355,520,150,30);
                 back.addActionListener(this);
                 image.add(back);
                 
        
            setSize(900,900);
            setLocation(300,0);
            setVisible(true);
        }

         public void actionPerformed(ActionEvent ae){
             if(ae.getSource()== withdrawl){
                 String number= amount.getText();
                 Date date = new Date();
                 if(number.equals("")){
                     JOptionPane.showMessageDialog(null,"PLEASE ENTER WITHDRAWL AMOUNT");
                 }else {
                     try{
                   
                     Conn conn = new Conn();
                     String query = "insert into bank values('"+pin+"','"+date+"','Withdrawl','"+number+"')" ;
                     conn.s.executeUpdate(query);
                     JOptionPane.showMessageDialog(null, "RS " + number +" WITHDRAWL SUCCESSFULLY");       
                     setVisible(false);
                     new Transactions(pin).setVisible(true);
                     
                 
                     }
                 catch(Exception e){
                         System.out.println(e);
                         }
             }
             } else if (ae.getSource()== back){
                 setVisible(false);
                 new Transactions(pin).setVisible(true);
             }
             
         }


   public static void main(String args[]){
         new Withdrwal("");
          
} 
  }

