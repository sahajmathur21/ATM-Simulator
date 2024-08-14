package atm.simulator;

import javax.swing.*;
import java.awt.*; 

import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    JButton next;
    JTextField pan,aadhar;
    JRadioButton syes,sno,eyes,eno;
  
    JComboBox religion,category,occupation,qualification,income,education;  
      String formno;
      
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
    
        
        JLabel additionalDetails= new JLabel("PAGE 2: ADDITIONAL DETAILS" );
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,28);
        add(additionalDetails);
        
      
        JLabel name= new JLabel("RELIGION:" );
        name.setFont(new Font("Raleway",Font.BOLD,17));
        name.setBounds(100,160,100,30);
        add(name);
        
        
        String valReligion[] = {"HINDU","MUSLIM" ,"SIKH", "CHRISTIAN","OTHERS"}; 
        religion = new JComboBox(valReligion);
        religion.setBounds(300,160,400,30);
        add(religion);

      
        JLabel fname= new JLabel("CATEGORY: " );
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        fname.setBounds(100,210,200,30);
        add(fname);
        
        String valCategory[] = {"GENERAL","OBC","SC","ST","OTHERS"};
      category = new JComboBox(valCategory);
        category.setBounds(300,210,400,30);
        add(category);
        
        JLabel dob= new JLabel("INCOME: " );
        dob.setFont(new Font("Raleway",Font.BOLD,18));
        dob.setBounds(100,260,200,30);
        add(dob);
        
          
        String valIncome[] = {"NULL","<1,50,000","<2,50,000","<5,00,000","MORE THAN 5,00,000"};
       income = new JComboBox(valIncome);
       income.setBounds(300,260,400,30);
        add(income);
       
        
        JLabel marital= new JLabel("EDUCATIONAL" );
        marital.setFont(new Font("Raleway",Font.BOLD,18));
        marital.setBounds(100,310,200,30);
        add(marital);

        
         JLabel gender= new JLabel("QUALIFICATION: " );
        gender.setFont(new Font("Raleway",Font.BOLD,18));
        gender.setBounds(100,330,200,30);
        add(gender);
        
        String valEducation[] = {"NON GRADUATION","<GRADUATION","<POST-GRADUATION","<DOCTRATE","OTHERS"};
        education = new JComboBox(valEducation);
        education.setBounds(300,330,400,30);
        add(education);
        
        JLabel email= new JLabel("OCCUPATION: " );
        email.setFont(new Font("Raleway",Font.BOLD,18));
        email.setBounds(100,410,200,30);
        add(email);
        
       String valOccupation[] = {"SELF EMPLOYED","SALARIED","BUSINESS","STUDENT","RETIRED"};
         occupation = new JComboBox(valOccupation);
       occupation.setBounds(300,410,400,30);
        add(occupation);
        
        
        JLabel panno= new JLabel("PAN NO: " );
        panno.setFont(new Font("Raleway",Font.BOLD,18));
        panno.setBounds(100,460,200,30);
        add(panno);
        
       pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
     pan.setBounds(300,460,400,30);
        add(pan);
        
        JLabel aadharno= new JLabel("AADHAR NO: " );
        aadharno.setFont(new Font("Raleway",Font.BOLD,18));
        aadharno.setBounds(100,510,200,30);
        add(aadharno);
        
        aadhar = new JTextField();
          aadhar.setFont(new Font("Raleway",Font.BOLD,14));
          aadhar.setBounds(300,510,400,30);
        add( aadhar);
        
        
        JLabel senior= new JLabel("SENIOR CITIZEN: " );
        senior.setFont(new Font("Raleway",Font.BOLD,18));
        senior.setBounds(100,560,200,30);
        add(senior);
        
        syes = new JRadioButton("YES");
        syes.setBounds(300,560,400,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("NO");
        sno.setBounds(450,565,600,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorcitizen = new ButtonGroup();
        seniorcitizen.add(syes);
        seniorcitizen.add(sno);
       
        
         
        
        JLabel pincode= new JLabel("EXISTING ACCOUNT: " );
        pincode.setFont(new Font("Raleway",Font.BOLD,18));
        pincode.setBounds(100,610,200,30);
        add(pincode);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300,610,60,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBounds(450,612,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
       ButtonGroup existing = new ButtonGroup();
      existing.add(eyes);
       existing.add(eno);
        
         
        
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
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
         String span =  pan.getText();
         String saadhar =  aadhar.getText();
         
        String seniorcitizen= null;
        
        if(syes.isSelected()){
            seniorcitizen = "YES";
        } else if (sno.isSelected()){
            
            seniorcitizen = "NO";
        }
        
        String existingaccount = null;
        if (eyes.isSelected()){
            existingaccount = "YES";
        } else if (eno.isSelected())
        {
         existingaccount = "NO";
    }       

   
    try{
        
            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "','" + sreligion +"','" +scategory+ "','" +sincome +"','"+ seducation +"','"+ soccupation +"','"+ span +"','"+ saadhar +"','"+seniorcitizen +"','"+ existingaccount +"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new Signupthree(formno).setVisible(true);
          }
    catch(Exception e){
        System.out.println(e);
    }
    }
    
    
   
    
    
    public static void main(String[] agrs){
        new SignupTwo("");
        
        
    }
        
    }
    
    
   
