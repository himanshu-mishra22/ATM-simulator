package atm_pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField txt;
    JButton back,deposit;
    String pin;
    public Deposit(String pin){
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        JLabel text = new JLabel("Please Enter the amount:");
        text.setBounds(130,220,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);

        txt = new JTextField();
        txt.setBounds(130,260,240,25);
        add(txt);

        deposit = new JButton("Deposit");
        deposit.setBounds(265,375,130,20);
        deposit.addActionListener(this);
        image.add(deposit);


        back = new JButton("Back");
        back.setBounds(265,400,130,20);
        back.addActionListener(this);
        image.add(back);
        setUndecorated(true);
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);



    }

    public static void main(String[] args) {
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit){
            String dep = txt.getText();
            Date date = new Date();
            if(dep.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please enter a valid amount");
            }else{
                Conn c = new Conn();
                String query = "insert into bank values ('"+pin+"','"+date+"','Deposit','"+dep+"')";
                try {
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+dep+" deposited successfully.");
                    setVisible(false);
                    new LoginNew(pin).setVisible(true);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }else if(e.getSource()==back){
            setVisible(false);
            new LoginNew(pin).setVisible(true);
        }
    }
}
