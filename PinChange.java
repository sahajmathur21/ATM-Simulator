
package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinn, repin;
    JButton change ,back;
    String pin;
    
    
    PinChange(String pin){
        this.pin = pin; 
       setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("System", Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);
        
         JLabel pintext = new JLabel("NEW PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font ("System", Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        
        pinn = new JPasswordField();
        pinn.setFont(new Font ("Raleway", Font.BOLD,25));
        pinn.setBounds(330,320,180,25);
        image.add(pinn);
        
         JLabel repintext = new JLabel("RE-ENTER NEW PIN: ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font ("System", Font.BOLD,16));
        repintext.setBounds(165,360,500,35);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font ("Raleway", Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
      change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
       back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== change){
        
        
        try {
              String npin = pinn.getText();
              String rpin = repin.getText();
            
               if(!npin.equals(rpin)){
               JOptionPane.showMessageDialog(null,"PIN DOES NOT MATCH");
                return;
               } 
           
               if (npin.equals("")){
                   JOptionPane.showMessageDialog(null,"PLEASE ENTER NEW PIN");
                    return;
               }
               
                if ( rpin.equals("")){
                   JOptionPane.showMessageDialog(null,"PLEASE ENTER RE PIN");
                    return;
                }
        
        Conn conn = new Conn();
        String query1 = "update bank set pin = '"+ rpin +"' where pin = '"+pinn+"'";
        String query2 = "update login set pin = '"+ rpin +"' where pin = '"+pinn+"'";        
        String query3 = "update signupthree set pin = '"+ rpin +"' where pin = '"+pinn+"'";       
       
        conn.s.executeUpdate(query1);
        conn.s.executeUpdate(query2);
        conn.s.executeUpdate(query3);
        
        JOptionPane.showMessageDialog(null,"PIN CHANGED SUCESSFULLY");
        
        setVisible(false);
        new Transactions(rpin).setVisible(true);
        
        
        }        
        catch(Exception e){
                
               
            System.out.println(e);
        }
        
    } else {
            setVisible(false);
             new Transactions(pin).setVisible(true);
}              
    } 
     public static void main(String args[]){
         new PinChange("").setVisible(true);
     }
}
