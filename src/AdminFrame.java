package studentinformationsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AdminFrame extends JFrame {

    public static void main(String[] args) {
        AdminFrame admin = new AdminFrame();
    }
    PreparedStatement pst = null;


    Container c;
    JPanel p1, p2, p3, p4, p5;
    ImageIcon img;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21;
    JButton logout, save, show, attach;
    JLabel attached;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/student";

    static final String USER = "root";
    static final String PASS = "root";
    String s;

    AdminFrame() {
        c = getContentPane();
        p1 = new JPanel();
        p1.setBackground(Color.blue);
        p1.setBounds(0, -5, 1200, 85);
        img = new ImageIcon(getClass().getResource("header.jpg"));
        l1 = new JLabel(img);

        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(0, 80, 1200, 40);
        JLabel label1 = new JLabel("Fill the Following Information:");
        label1.setFont(new Font(label1.getName(), Font.BOLD, 20));
        label1.setForeground(Color.blue);
        p2.add(label1);
        label1.setBounds(20, -5, 300, 50);
        save = new JButton("Save Record");
        save.setBounds(950, 0, 120, 40);
        save.setBackground(Color.green);
        p2.add(save);
        show = new JButton("show Record");
        show.setBounds(1080, 0, 110, 40);
        show.setBackground(Color.green);
        p2.add(show);
        logout = new JButton("Log-Out");
        logout.setBounds(820, 0, 120, 40);
        logout.setBackground(Color.green);
        p2.add(logout);

        //panel 3
        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(new Color(135, 206, 250));
        p3.setBounds(0, 80, 1200, 400);

        //panel 4
        p4 = new JPanel();
        p4.setLayout(null);
        p4.setBounds(0, 480, 1200, 50);
        p4.setBackground(Color.white);
        JLabel label = new JLabel("Academic details:");
        label.setFont(new Font(label.getName(), Font.BOLD, 20));
        label.setForeground(Color.blue);
        p4.add(label);
        label.setBounds(20, 0, 200, 50);

        //panel 5
        p5 = new JPanel();
        p5.setLayout(null);
        p5.setBackground(new Color(135, 206, 250));
        JLabel slc = new JLabel("Level");
        slc.setBounds(40, 540, 100, 30);
        slc.setFont(new Font(slc.getName(), Font.BOLD, 18));
        t14 = new JTextField();
        t14.setBounds(20, 580, 130, 35);
        t15 = new JTextField();
        t15.setBounds(20, 640, 130, 35);
        p5.add(slc);
        p5.add(t14);
        p5.add(t15);

        JLabel name = new JLabel(" Name of Institute");
        name.setBounds(300, 540, 200, 30);
        name.setFont(new Font(name.getName(), Font.BOLD, 18));
        t16 = new JTextField();
        t16.setBounds(230, 580, 300, 35);
        t17 = new JTextField();
        t17.setBounds(230, 640, 300, 35);
        p5.add(name);
        p5.add(t16);
        p5.add(t17);

        JLabel per = new JLabel("Percentage");
        per.setBounds(600, 540, 150, 30);
        per.setFont(new Font(per.getName(), Font.BOLD, 18));
        t18 = new JTextField();
        t18.setBounds(570, 580, 250, 35);
        t19 = new JTextField();
        t19.setBounds(570, 640, 250, 35);
        p5.add(per);
        p5.add(t18);
        p5.add(t19);

        JLabel year = new JLabel(" Passed Year");
        year.setBounds(900, 540, 200, 30);
        year.setFont(new Font(year.getName(), Font.BOLD, 18));
        t20 = new JTextField();
        t20.setBounds(880, 580, 250, 35);
        t21 = new JTextField();
        t21.setBounds(880, 640, 250, 35);
        p5.add(year);
        p5.add(t20);
        p5.add(t21);

        //panel 5 end and start function of panel 3 body 
        l2 = new JLabel("Form no.:");
        l2.setBounds(20, 70, 80, 30);
        t1 = new JTextField(50);
        t1.setBounds(90, 70, 130, 30);

        l3 = new JLabel("Batch no.(Year):");
        l3.setBounds(250, 70, 130, 30);
        t2 = new JTextField(50);
        t2.setBounds(350, 70, 150, 30);

        l4 = new JLabel("Student ID no.:");
        l4.setBounds(530, 70, 130, 30);
        t3 = new JTextField(50);
        t3.setBounds(630, 70, 150, 30);

        l5 = new JLabel("First Name:");
        l5.setBounds(20, 130, 80, 30);
        t4 = new JTextField(50);
        t4.setBounds(90, 130, 150, 30);

        l6 = new JLabel("Middle Name:");
        l6.setBounds(250, 130, 130, 30);
        t5 = new JTextField(50);
        t5.setBounds(350, 130, 160, 30);

        l7 = new JLabel("Last Name:");
        l7.setBounds(550, 130, 130, 30);
        t6 = new JTextField(50);
        t6.setBounds(630, 130, 150, 30);

        l8 = new JLabel("Email:");
        l8.setBounds(20, 190, 80, 30);
        t7 = new JTextField(50);
        t7.setBounds(90, 190, 150, 30);

        l9 = new JLabel("Contact No:");
        l9.setBounds(250, 190, 130, 30);
        t8 = new JTextField(50);
        t8.setBounds(350, 190, 160, 30);

        l10 = new JLabel("DOB(dd/mm/year):");
        l10.setBounds(550, 190, 130, 30);
        t9 = new JTextField(50);
        t9.setBounds(630, 190, 150, 30);

        l11 = new JLabel("Father Name:");
        l11.setBounds(20, 250, 130, 30);
        t10 = new JTextField(50);
        t10.setBounds(100, 250, 250, 30);

        l12 = new JLabel("Mother Name:");
        l12.setBounds(430, 250, 130, 30);
        t11 = new JTextField(50);
        t11.setBounds(530, 250, 250, 30);

        l13 = new JLabel("Permanent Address:");
        l13.setBounds(20, 310, 130, 30);
        t12 = new JTextField(50);
        t12.setBounds(140, 310, 230, 30);

        l14 = new JLabel("Temporary Address:");
        l14.setBounds(400, 310, 130, 30);
        t13 = new JTextField(50);
        t13.setBounds(530, 310, 250, 30);

        attached = new JLabel("Enter The Details");
        attached.setBounds(900, 70, 200, 200);
        attached.setFont(new Font(label.getName(), Font.BOLD, 20));
        attached.setForeground(Color.BLACK);
        p3.add(attached);

        
        p1.add(l1);
        p3.add(l2);
        p3.add(t1);
        p3.add(l3);
        p3.add(t2);
        p3.add(l4);
        p3.add(t3);
        p3.add(l5);
        p3.add(t4);
        p3.add(l6);
        p3.add(t5);
        p3.add(l7);
        p3.add(t6);
        p3.add(l8);
        p3.add(t7);
        p3.add(l9);
        p3.add(t8);
        p3.add(l10);
        p3.add(t9);
        p3.add(l11);
        p3.add(t10);
        p3.add(l12);
        p3.add(t11);
        p3.add(l13);
        p3.add(t12);
        p3.add(l14);
        p3.add(t13);

        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.add(p4);
        c.add(p5);
        
                t14.setText("10th");
                t15.setText("12th");

        setSize(1200, 750);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setTitle("Student Information System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        shows();
        logout();
        save();
    }
    
    public void logout() {
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentInformationSystem r = new StudentInformationSystem();
                r.setVisible(true);
                dispose();

            }
        });
    }

    public void shows() {
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminView u = new AdminView();
                u.setVisible(true);
                dispose();
            }
        });
    }

    public void save() {
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conn = null;
                Statement stmt = null;
                String s1 = t1.getText();
                String s2 = t2.getText();
                String s3 = t3.getText();
                String s4 = t4.getText();
                String s5 = t5.getText();
                String s6 = t6.getText();
                String s7 = t7.getText();
                String s8 = t8.getText();
                String s9 = t9.getText();
                String s10 = t10.getText();
                String s11 = t11.getText();
                String s12 = t12.getText();
                String s13 = t13.getText();
                String s14 = t14.getText();
                String s15 = t15.getText();
                String s16 = t16.getText();
                String s17 = t17.getText();
                String s18 = t18.getText();
                String s19 = t19.getText();
                String s20 = t20.getText();
                String s21 = t21.getText();
                t14.setText("10th");
                t15.setText("12th");

                if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")
                        || t4.getText().equals("") || t6.getText().equals("") || t7.getText().equals("")
                        || t8.getText().equals("") || t9.getText().equals("") || t10.getText().equals("")
                        || t11.getText().equals("") || t12.getText().equals("") ||
                        t14.getText().equals("") || t15.getText().equals("") || t16.getText().equals("")
                        || t17.getText().equals("") || t18.getText().equals("") || t19.getText().equals("")
                        || t20.getText().equals("") || t21.getText().equals("")) {
                       JOptionPane.showMessageDialog(save, "All record Must be fill Out");
                } else {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        System.out.println("every thing is ok in connection");
                        JOptionPane.showConfirmDialog(null, "Are you sure Insert Data?", "Delete", JOptionPane.YES_NO_OPTION);
                        PreparedStatement ps = conn.prepareStatement("Insert into information values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+s12+"','"+s13+"','"+s14+"','"+s15+"','"+s16+"','"+s17+"','"+s18+"','"+s19+"','"+s20+"','"+s21+"');");
                        System.out.println("ok in prepared statement");
                       // InputStream is = new FileInputStream(new File(s));
                        //ps.setBlob(22, is);
                        ps.executeUpdate();
                        System.out.println("ok while execute ");
                        JOptionPane.showMessageDialog(save, "sucessfully inserted Data");
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        t7.setText("");
                        t8.setText("");
                        t9.setText("");
                        t10.setText("");
                        t11.setText("");
                        t12.setText("");
                        t13.setText("");
                        t14.setText("10th");
                        t15.setText("11th");
                        t16.setText("");
                        t17.setText("");
                        t18.setText("");
                        t19.setText("");
                        t20.setText("");
                        t21.setText("");
                        
                    } catch (SQLException se) {
                        se.printStackTrace();

                    } catch (Exception ek) {
                        ek.printStackTrace();
                    } finally {
                        try {
                            if (stmt != null) {
                                conn.close();
                            }
                        } catch (SQLException se) {
                        }
                        try {
                            if (conn != null) {
                                conn.close();
                            }
                        } catch (SQLException se) {
                            se.printStackTrace();
                        }//end finally try
                    }//end try
                    System.out.println("good bye");
                }
            }
        });
    }

}
