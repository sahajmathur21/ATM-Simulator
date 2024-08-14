package atm.simulator;

import java.sql.*;

public class Conn {
      
    Connection c;
    Statement s;
    
        public Conn(){
            try {
                c =  (Connection) DriverManager.getConnection("jdbc:mysql:///atmsimulator", "root", "sahajsahaj");
                s = c.createStatement();
                
            } catch (Exception e){
                System.out.println(e);
            }
            
            
        }   
}
