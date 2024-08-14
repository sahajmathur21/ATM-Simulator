package atm.simulator;

import java.util.*;
import javax.swing.*;
import java.awt.*; 
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
    long random ;
    JButton next;
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,pinTextField,stateTextField;
    JRadioButton female, male , married,unmarried ;
      JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);
        
        Random ran= new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " +random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        
        JLabel personDetails= new JLabel("PAGE 1: PERSONAL DETAILS" );
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,28);
        add(personDetails);
        
        JLabel name= new JLabel("NAME: " );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,160,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
       nameTextField.setBounds(300,160,400,30);
        add(nameTextField);
        
        JLabel fname= new JLabel("FATHER NAME: " );
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,210,200,30);
        add(fname);
        
         fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
       fnameTextField.setBounds(300,210,400,30);
        add(fnameTextField);
        
        JLabel dob= new JLabel("DATE OF BIRTH: " );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,260,200,30);
        add(dob);
        
      dateChooser = new JDateChooser();
        dateChooser.setBounds(300,260,200,30);
        add(dateChooser);
        
        JLabel marital= new JLabel("MARITAL STATUS: " );
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,310,200,30);
        add(marital);
        
          married= new JRadioButton("MARRIED");
        married.setBounds(300,310,80,30);
       married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBackground(Color.white);
        unmarried.setBounds(450,310,140,30);
        add(unmarried);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        
        
        JLabel gender= new JLabel("GENDER: " );
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,360,200,30);
        add(gender);
        
        male = new JRadioButton("MALE");
        male.setBounds(300,360,60,30);
       male.setBackground(Color.white);
        add(male);
        
         female = new JRadioButton("FEMALE");
        female.setBackground(Color.white);
        female.setBounds(450,360,120,30);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel email= new JLabel("EMAIL ADDRESS: " );
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,410,200,30);
        add(email);
        
       emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
       emailTextField.setBounds(300,410,400,30);
        add(emailTextField);
        
        
        JLabel address= new JLabel("ADDRESS: " );
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,460,200,30);
        add(address);
        
       addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
       addressTextField.setBounds(300,460,400,30);
        add(addressTextField);
        
        JLabel city= new JLabel("CITY: " );
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,510,200,30);
        add(city);
        
         cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,510,400,30);
        add(cityTextField);
        
        
        JLabel state= new JLabel("STATE: " );
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,560,200,30);
        add(state);
        
         stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,560,400,30);
        add(stateTextField);
        
        JLabel pincode= new JLabel("PINCODE: " );
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,610,200,30);
        add(pincode);
        
         pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,610,400,30);
        add(pinTextField);
        
       next = new JButton("NEXT");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
                
                
                
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" +random;
        String name =  nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "MALE";
        } else if (female.isSelected()){
            gender = "FEMALE";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "MARRIED";
        } else if (unmarried.isSelected())
        {
          marital = "UNMARRIED";
    }       
    String address = addressTextField.getText();
    String city = cityTextField.getText();
    String state = stateTextField.getText();
    String pin = pinTextField.getText();
    
    try{
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"NAME IS REQUIRED");
        }else{
            Conn c = new Conn();
            String query = "insert into signup values('" + formno + "','" + name +"','" +fname+ "','" +dob +"','"+ marital +"','"+ gender +"','"+ email +"','"+ address +"','"+ city +"','"+ state +"','"+ pin +"')";
            c.s.executeUpdate(query);   
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
        }
        
    }
    catch(Exception e){
        System.out.println(e);
    }
    }
    
    
   
    
    
    public static void main(String[] agrs){
        new SignupOne();
        
        
    }
        
    }
    
    
   