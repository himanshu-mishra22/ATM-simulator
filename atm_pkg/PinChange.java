package atm_pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    String pin;
    JTextArea newPintxt,re_newPintxt;
    JButton change,back;
    public PinChange(String pin){
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        JLabel text = new JLabel("Change PIN");
        text.setBounds(175,220,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);

        JLabel newPin = new JLabel("New PIN:");
        newPin.setBounds(135,260,100,25);
        newPin.setForeground(Color.WHITE);
        image.add(newPin);
        newPintxt = new JTextArea();;
        newPintxt.setBounds(250,260,150,27);
        image.add(newPintxt);

        re_newPintxt = new JTextArea();;
        re_newPintxt.setBounds(250,300,150,27);
        image.add(re_newPintxt);


        JLabel re_newPin = new JLabel("Re-Enter PIN:");
        re_newPin.setBounds(135,300,100,25);
        re_newPin.setForeground(Color.WHITE);
        image.add(re_newPin);

        change = new JButton("Change");
        change.setBounds(265, 375, 130, 20);
        change.addActionListener(this);
        image.add(change);


        back = new JButton("Back");
        back.setBounds(265, 400, 130, 20);
        back.addActionListener(this);
        image.add(back);




        setUndecorated(true);
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new LoginNew(pin).setVisible(true);
        }else if(e.getSource()==change){
            try{
                String npin = newPintxt.getText();
                String rpin = re_newPintxt.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered  PIN doesn't match!");
                    return;
                }
                if(npin.isEmpty() || rpin.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Required field cannot be empty!");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin ='"+pin+"'";
                String query2 = "update signup3 set pin = '"+rpin+"' where pin ='"+pin+"'";
                String query3 = "update login set pin = '"+rpin+"' where pin ='"+pin+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN changed successfully.");
                setVisible(false);
                new LoginNew(pin).setVisible(true);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
}
