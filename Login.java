
package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
     JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100 ,100 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100 ,100 );
        add(label);
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Oswald",Font.BOLD,30));
        text.setBounds(200,40, 400,40);
        add(text);
        
          JLabel carno = new JLabel("Card No: ");
        carno.setFont(new Font("Raleway",Font.BOLD,28));
        carno.setBounds(120,150, 400,40);
        add(carno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
          JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220, 250,30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
     login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
       clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
}
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            pinTextField.setText("");
            cardTextField.setText("");
        }
        
        else if(ae.getSource()== login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pin = pinTextField.getText();
            String query = "select *from login where cardnumber = '"+cardnumber+"' and pin = '"+pin+"'";
            try{
                ResultSet rs= conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin ).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"INCORRECT CARD NUMBER OR PIN");
                    
                }
            }catch(Exception e){
            System.out.println(e);
            
        }
            
            
            
        }
        else if(ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true); 
    }
        
        
        
        
    }
    
         public static void main(String[] args){
             new Login();
             
         }
}