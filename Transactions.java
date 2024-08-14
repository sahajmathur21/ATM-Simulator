package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrwal, ministatement, balanceenquiry, pinchange, fastcash, exit;
    String pin;

    Transactions(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("PLEASE SELECT TRANSACTION");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Sysyem", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrwal = new JButton("CASH WITHDRWAL");
        withdrwal.setBounds(355, 415, 150, 30);
        withdrwal.addActionListener(this);
        image.add(withdrwal);

        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("MINI STATEMENT");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("BALANCE ENQUIRY");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("EXIT");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()== withdrwal){
            setVisible(false);
            new Withdrwal(pin).setVisible(true);
        }
        else if (ae.getSource()== fastcash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
            
        }else if(ae.getSource()== pinchange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(ae.getSource()== balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
    }else if(ae.getSource()== ministatement){
         
            new MiniStatement(pin).setVisible(true);
    }
    }
    public static void main(String args[]) {
         new Transactions("");
    }

}
