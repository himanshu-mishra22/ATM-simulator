package atm_pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton exit, deposit, withdrawl, fastCash, miniStatement, pinChange, balanceEnquiry;
    String pin;

    public FastCash(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);

        JLabel text = new JLabel("Please select your Transaction.");
        text.setBounds(175, 220, 700, 35);
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("Rs 500");
        deposit.setBounds(125, 325, 130, 20);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 1000");
        withdrawl.setBounds(125, 350, 130, 20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Rs 1500");
        fastCash.setBounds(125, 375, 130, 20);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Rs 20000");
        miniStatement.setBounds(265, 375, 130, 20);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Rs 5000");
        pinChange.setBounds(265, 325, 130, 20);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Rs 10000");
        balanceEnquiry.setBounds(265, 350, 130, 20);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Back");
        exit.setBounds(265, 400, 130, 20);
        exit.addActionListener(this);
        image.add(exit);

        setUndecorated(true);
        setSize(700, 700);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            setVisible(false);
            new LoginNew(pin).setVisible(true);
        } else {
            String amt = ((JButton) e.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                 ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
                int bal = 0;

                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        bal += rs.getInt("amount");
                    } else {
                        bal -= rs.getInt("amount");
                    }
                }
                rs.close();

                if (Integer.parseInt(amt) > bal) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    return;
                }
                Date date = new Date();
                String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('"+pin+"', '"+date+"', 'Withdraw', '"+amt+"')";
                try  {
                    c.s.executeUpdate(query);
                }catch(Exception ex){
                    System.out.println(ex);
                }

                JOptionPane.showMessageDialog(null, "Rs " + amt + " Debited Successfully.");
                setVisible(false);
                new LoginNew(pin).setVisible(true);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}


