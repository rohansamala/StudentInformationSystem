package studentinformationsystem;

import java.sql.*;
import javax.swing.*;
public class dbconnect {

    Connection conn=null;
    public static Connection java_db(){
        
        try{
            String myurl= "jdbc:mysql://localhost/student";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn =DriverManager.getConnection(myurl,"root","root");
            //JOptionPane.showMessageDialog(null, "Connection to database is successful");
      
            return conn;
           
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}