
package studentinformationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentInformationSystem extends JFrame {

    public static void main(String[] args) {
        StudentInformationSystem sis = new StudentInformationSystem();

    }

    JFrame f1;
    JPanel p1;
    JLabel l1, l2, l3;
    JTextField t1;
    JPasswordField pass;
    JButton b1, b2;
    ImageIcon img;
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    
    StudentInformationSystem() {

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(135, 206, 250));

        img = new ImageIcon(getClass().getResource("student.png"));

        l1 = new JLabel(img);
        l1.setBounds(0,0, 215, 360);

        l2 = new JLabel("Username");
        l2.setBounds(230, 30, 90, 40);
        l2.setFont(new Font("Serif", Font.PLAIN, 20));

        l3 = new JLabel("Password");
        l3.setBounds(230, 120, 100, 40);
        l3.setFont(new Font("Serif", Font.PLAIN, 20));

        t1 = new JTextField(30);
        t1.setBounds(320, 30, 230, 35);

        pass = new JPasswordField(10);
        pass.setBounds(320, 120, 230, 35);

        b1 = new JButton("Student-Login");
        b1.setBounds(230, 250, 150, 50);
        b1.setBackground(new Color(255,255,255));

        b2 = new JButton("Admin-Login");
        b2.setBounds(400, 250, 150, 50);
        b2.setBackground(new Color(255,255, 255));

        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(t1);
        p1.add(pass);
        p1.add(b1);
        p1.add(b2);

        add(p1);
        setSize(580, 390);
        setVisible(true);
        setResizable(true);
        setLocation(370, 50);
        setTitle("Student Information System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userlogin();
        adminlogin();

    }

    public void userlogin() {
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String puname = t1.getText();
                String ppaswd = pass.getText();
                con = dbconnect.java_db();
                String sql= "select * from user where username= '" + puname + "' and password ='" + ppaswd + "'";
      
      try{  
                pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
          if (rs.next()) {
                    UserView re = new UserView();
                    re.setVisible(true);
                    dispose();
                } else {

                    JOptionPane.showMessageDialog(null, "Wrong Password / Username");
                    t1.setText("");
                    pass.setText("");
                    t1.requestFocus();
                }
            }catch(HeadlessException t){
         JOptionPane.showMessageDialog(null, t); 
          
    }           catch (SQLException ex) {
                    Logger.getLogger(StudentInformationSystem.class.getName()).log(Level.SEVERE, null, ex);
                }}
        });
    }

    public void adminlogin() {
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String puname = t1.getText();
                String ppaswd = pass.getText();
                con = dbconnect.java_db();
                String sql= "select * from admin where username= '" + puname + "' and password ='" + ppaswd + "'";
      try{  
                pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
          
                if (rs.next()) {
                    AdminFrame re = new AdminFrame();
                    re.setVisible(true);
                    dispose();
                } else {

                    JOptionPane.showMessageDialog(null, "Wrong Password / Username");
                    t1.setText("");
                    pass.setText("");
                    t1.requestFocus();
                }
            }catch(HeadlessException t){
         JOptionPane.showMessageDialog(null, t); 
          
    }           catch (SQLException ex) {
                    Logger.getLogger(StudentInformationSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    });

}}
