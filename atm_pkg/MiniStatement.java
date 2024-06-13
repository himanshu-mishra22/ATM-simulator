package atm_pkg;

import javax.swing.*;

import java.sql.ResultSet;


public class MiniStatement extends JFrame {
    String pin;

    public MiniStatement(String pin) {
        this.pin = pin;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 400);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel cardno = new JLabel();
        cardno.setBounds(20, 80, 300, 20);
        add(cardno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin='" + pin + "'");
            while (rs.next()) {
                cardno.setText("Card Number: " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
            rs.close();

            rs = c.s.executeQuery("select * from transactions where pin='" + pin + "'");
            StringBuilder miniStatementHtml = new StringBuilder("<html>");
            while (rs.next()) {
                miniStatementHtml.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("amount")).append("<br>");
            }
            miniStatementHtml.append("</html>");
            mini.setText(miniStatementHtml.toString());

            rs.close();
            c.s.close();
        } catch (Exception ae) {
            System.out.println(ae);
        }

        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}

