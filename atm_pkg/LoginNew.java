package atm_pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginNew extends JFrame implements ActionListener {
    JButton exit,deposit,withdrawl,fastCash,miniStatement,pinChange,balanceEnquiry;
String pin;
    public LoginNew(String pin){
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        JLabel text = new JLabel("Please select your Transaction.");
        text.setBounds(175,220,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);
        deposit = new JButton("Deposit");
        deposit.setBounds(125,325,130,20);
        deposit.addActionListener(this);
        image.add(deposit);
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(125,350,130,20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(125,375,130,20);
        fastCash.addActionListener(this);
        image.add(fastCash);
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(265,375,130,20);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(265,325,130,20);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enq.");
        balanceEnquiry.setBounds(265,350,130,20);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

//        JButton fastCash = new JButton("Fast Cash");
//        fastCash.setBounds(265,375,130,20);
//        image.add(fastCash);

        exit = new JButton("Exit");
        exit.setBounds(265,400,130,20);
        exit.addActionListener(this);
        image.add(exit);

        setUndecorated(true);
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);

    }

    public static void main(String[] args) {
        new LoginNew("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }else if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(e.getSource()==withdrawl){
            setVisible(false);
            new Withdraw(pin).setVisible(true);
        }else if(e.getSource()==fastCash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(e.getSource()==pinChange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(e.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnq(pin).setVisible(true);
        }else if(e.getSource()==miniStatement){
            setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }
    }
}
