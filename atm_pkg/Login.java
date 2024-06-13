package atm_pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener{
    JButton signIn, signUp, Reset;
    JTextField cardArea;
    JPasswordField pinArea;
    public Login(){
        setTitle("ATM");
        setLayout(null);
        ImageIcon iI = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = iI.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,1,100,100);
        add(label);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel CardNo = new JLabel("Card Number:");
        CardNo.setFont(new Font("Raieway",Font.BOLD,20));
        CardNo.setBounds(120,150,400,40);
        add(CardNo);

        cardArea = new JTextField();
        cardArea.setBounds(300,150,250,30);
        cardArea.setFont(new Font("Ariel",Font.BOLD,14));
        add(cardArea);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Osward",Font.BOLD,20));
        pin.setBounds(120,220,400,40);
        add(pin);

        pinArea = new JPasswordField();
        pinArea.setBounds(300,220,250,30);
        add(pinArea);

        signIn = new JButton("Sign In");
        signIn.setBounds(300,270,100,40);
        signIn.addActionListener(this);
        add(signIn);

        Reset = new JButton("Reset");
        Reset.setBounds(450,270,100,40);
        Reset.addActionListener(this);
        add(Reset);

        signUp = new JButton("Sign Up");
        signUp.setBounds(350,330,150,40);
        signUp.addActionListener(this);
        add(signUp);

        setSize(800,480);

        setLocation(350,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== Reset){
            cardArea.setText("");
            pinArea.setText("");
        }else if(e.getSource()== signIn){
            Conn c = new Conn();
            String cardno = cardArea.getText();
            String pinno = pinArea.getText();
            String query = "select * from login where cardno = '"+cardno+"' and pin = '"+pinno+"'";
            try {
                ResultSet rs= c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new LoginNew(pinno).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card No. Or PIN!");
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }else if(e.getSource()== signUp){
            setVisible(false);
            new ApplicationForm().setVisible(true);

        }
    }
    public static void main(String[] args) {

        new Login();
    }


}
