package atm_pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceEnq extends JFrame implements ActionListener
{
    String pin;
    JButton back;
    public BalanceEnq(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);

        Conn c = new Conn();
        int bal = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        JLabel balVal = new JLabel("Your Current balance is: "+ bal);
        balVal.setForeground(Color.WHITE);
        balVal.setBounds(170,250,250,35);
        image.add(balVal);

        back = new JButton("Back");
        back.setBounds(265, 400, 130, 20);
        back.addActionListener(this);
        image.add(back);

        setUndecorated(true);
        setSize(700, 700);
        setLocation(300, 0);
        setVisible(true);
    }

        @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            new LoginNew(pin).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new BalanceEnq("");
    }
}
