
package atm.simulator;
import javax.swing.*;
import java.awt.*;
 import java.sql.*;
public class MiniStatement extends JFrame{
    String pin;
    
    
    
    MiniStatement(String pin){
        setTitle("MINI STATEMENT");
         
        setLayout(null);
        
        JLabel mini= new JLabel();
         mini.setBounds(20,140,400,200);
        
        add(mini);
        
        JLabel bank= new JLabel("COUNTRY BANK");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card= new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(" select * from login where pin = '"+pin+"'");
            while(rs.next()){
                card.setText("CAED NUMBER: " + rs.getString("cardnumber"));
            }
                
        }catch(Exception e){
            System.out.println(e);
        
       }
        try{
            int bal = 0;
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(" select * from bank where pin = '"+pin+"'");
            while(rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>" );
                if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }else{
                        
                        bal -= Integer.parseInt(rs.getString("amount"));
                        
                    }

            }
            balance.setText("YOUR CURRENT ACCOUNT BALANCE RS: " + bal);
        }catch(Exception e){
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    
       
    }
 
    public static void main(String args[]){
        new MiniStatement("");
    }
}
