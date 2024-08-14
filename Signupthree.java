
package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signupthree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    Signupthree(String formno){
        this.formno = formno; 
        
        setLayout(null);
        
        
        
        
        JLabel l1 = new JLabel("PAGE 3: ACCOUNT DETAILS");
         l1.setFont(new Font("Raleway",Font.BOLD,25));
         l1.setBounds(260,40,400,30);
         add(l1);
         
          JLabel type = new JLabel("ACCOUNT TYPE:");
         type.setFont(new Font("Raleway",Font.BOLD,22));
         type.setBounds(100,120,400,30);
         add(type);
         
         r1 = new JRadioButton("SAVING ACCOUNT");
         r1.setFont(new Font("Raleway",Font.BOLD,16));
         r1.setBounds(100,180,250,20);
         r1.setBackground(Color.WHITE);
         add(r1);
         
          r2 = new JRadioButton("FIXED DEPOSIT ACCOUNT");
         r2.setFont(new Font("Raleway",Font.BOLD,16));
         r2.setBounds(350,180,250,20);
         r2.setBackground(Color.WHITE);
         add(r2);
         
         r3 = new JRadioButton("CURRENT ACCOUNT");
         r3.setFont(new Font("Raleway",Font.BOLD,16));
         r3.setBounds(100,220,250,20);
         r3.setBackground(Color.WHITE);
         add(r3);
         
         r4 = new JRadioButton("RECURRING ACCOUNT");
         r4.setFont(new Font("Raleway",Font.BOLD,16));
         r4.setBounds(350,220,250,20);
         r4.setBackground(Color.WHITE);
         add(r4);
         
         ButtonGroup groupaccount = new ButtonGroup();
         groupaccount.add(r1);
         groupaccount.add(r2);
         groupaccount.add(r3);
         groupaccount.add(r4);
         
           JLabel card = new JLabel("CARD NUMBER:");
         card.setFont(new Font("Raleway",Font.BOLD,16));
         card.setBounds(100,270,200,30);
         add(card);
         
           JLabel number = new JLabel("XXXX-XXXX-XXXX-4252");
         number.setFont(new Font("Raleway",Font.BOLD,16));
         number.setBounds(330,270,300,20);
         add(number);
         
         JLabel carddetails = new JLabel("ENTER yOUR CARD NO");
         carddetails.setFont(new Font("Raleway",Font.BOLD,12));
         carddetails.setBounds(100,300,300,20);
         add(carddetails);
         
           JLabel pin = new JLabel("PIN:");
         pin.setFont(new Font("Raleway",Font.BOLD,16));
         pin.setBounds(100,340,200,30);
         add(pin);
         
           JLabel pnumber = new JLabel("XXXX");
         pnumber.setFont(new Font("Raleway",Font.BOLD,16));
         pnumber.setBounds(330,340,300,30);
         add(pnumber);
         
           JLabel pindetails = new JLabel("ENTER YOUR PIN");
         pindetails.setFont(new Font("Raleway",Font.BOLD,12));
         pindetails.setBounds(100,370,300,20);
         add(pindetails);
         
           JLabel service = new JLabel("SERVICES REQUIRED");
         service.setFont(new Font("Raleway",Font.BOLD,18));
         service.setBounds(100,420,200,32);
         add(service);
         
         c1 = new JCheckBox("ATM CARD");
         c1.setFont(new Font("Raleway",Font.BOLD,16));
         c1.setBounds(100,460,200,30);
         add(c1);
         
         c2 = new JCheckBox("INTERNET BANKING");
         c2.setFont(new Font("Raleway",Font.BOLD,16));
         c2.setBounds(350,460,200,30);
         add(c2);
         
         c3 = new JCheckBox("MOBILE BANKING");
         c3.setFont(new Font("Raleway",Font.BOLD,16));
         c3.setBounds(100,510,200,30);
         add(c3);
         
         c4 = new JCheckBox("SMS ALERTS");
         c4.setFont(new Font("Raleway",Font.BOLD,16));
         c4.setBounds(350,510,200,30);
         add(c4);
         
         c5 = new JCheckBox("CHECKBOOK");
         c5.setFont(new Font("Raleway",Font.BOLD,16));
         c5.setBounds(100,570,200,30);
         add(c5);
         
         c6 = new JCheckBox("E-STATEMENT");
         c6.setFont(new Font("Raleway",Font.BOLD,16));
         c6.setBounds(350,570,200,30);
         add(c6);
         
         c7 = new JCheckBox("I HEREBY DECLARE ABOVE DETAILS ARE CORRECT");
         c7.setFont(new Font("Raleway",Font.BOLD,12));
         c7.setBounds(100,640,600,30);
         add(c7);
     
         submit = new JButton("SUBMIT");
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         submit.setFont(new Font("Raleway",Font.BOLD,14));
         submit.setBounds(250,690,100,30);
         submit.addActionListener(this);
         add(submit);
         
         cancel = new JButton("CANCEL");
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
         cancel.setFont(new Font("Raleway",Font.BOLD,14));
         cancel.setBounds(420,690,100,30);
         add(cancel);
         
         getContentPane().setBackground(Color.WHITE);
         
         setSize(850,820);
         setLocation(350,0);
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String Type = null;
            if(r1.isSelected()){
                Type = "SAVING ACCOUNT";
            }else if (r2.isSelected()){
                Type = "FIXED DEPOSIT";
                
            }else if (r3.isSelected()){
                Type = "CURRENT ACCOUNT";
            }else if (r4.isSelected()){
                Type= "RECURRING ACCOUNT";
            }
            
            Random random = new Random();
         String cardnumber = "" + Math.abs( (random.nextLong() % 90000000L) + 5040936000000000L);              
            String pin = ""+ Math.abs ((random.nextLong() % 9000L) + 1000L);

            
            
            String facility= "";
            if(c1.isSelected()){
                facility = facility +"ATM CARD";
            }else if (c2.isSelected()){
                facility = facility +"INTERNET BANKING";
            }else if (c3.isSelected()){
                facility = facility +"MOBILE BANKING";
            }else if (c4.isSelected()){
                facility = facility +"SMS ALERTS";
            }else if (c5.isSelected()){
                facility = facility +"CHECKBOOK";    
            }else if (c6.isSelected()){
                facility = facility +" E-STATEMENT";
            }
            
            try{
                if(Type.equals("")){
                    JOptionPane.showMessageDialog(null,"TYPE IS REQUIRED");
                }else{
                    Conn conn = new Conn();
                     String query1 = "insert into signupthree values('" + formno + "','" + Type +"','" + cardnumber + "','" + pin +"','"+ facility+"')";
                    String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pin +"')";   
                     conn.s.executeUpdate(query1); 
                      conn.s.executeUpdate(query2); 
                   JOptionPane.showMessageDialog(null,"Card NUMBER:" + cardnumber + "\n PIN: "+ pin);
                }
                setVisible(false);
                new Deposit(pin).setVisible(false);
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
            
    }else if(ae.getSource()== cancel){
        setVisible(false);
        new Login().setVisible(true);        
    }
    }    
    public static void main(String[] args){
          new Signupthree("");
   
    }
      
    }
    

