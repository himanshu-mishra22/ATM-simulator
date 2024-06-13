package atm_pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ApplicationForm3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton submit,cancel;
    String formno;
    public ApplicationForm3(String formno){
        this.formno = formno;
        setTitle("Application form 3");

        JLabel additionalDetails = new JLabel("Page 3: Account Details. ");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,40);
        add(additionalDetails);

        JLabel type = new JLabel("Account Type: ");
        type.setBounds(100,140,200,30);
        type.setFont(new Font("Raleway",Font.BOLD,22));
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(100,220,200,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(350,180,200,20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setBounds(100,300,200,30);
        card.setFont(new Font("Raleway",Font.BOLD,20));
        add(card);

        JLabel cardnum = new JLabel("XXXX-XXXX-XXXX-4314");
        cardnum.setBounds(330,300,400,30);
        cardnum.setFont(new Font("Raleway",Font.BOLD,20));
        add(cardnum);
        JLabel det = new JLabel("This is your 16-Digit Card number.");
        det.setBounds(100,330,400,30);
        det.setFont(new Font("Raleway",Font.BOLD,12));
        add(det);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(100,380,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        add(pin);

        JLabel pinnum = new JLabel("XXXX");
        pinnum.setBounds(330,380,400,30);
        pinnum.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinnum);
        JLabel pindet = new JLabel("Your 4-Digit PIN.");
        pindet.setBounds(100,410,400,30);
        pindet.setFont(new Font("Raleway",Font.BOLD,12));
        add(pindet);

        JLabel services = new JLabel("Services:");
        services.setBounds(100,460,400,30);
        services.setFont(new Font("Raleway",Font.BOLD,20));
        add(services);
        c1= new JCheckBox("ATM CARD");
        c1.setBounds(100,510,300,20);
        c1.setBackground(Color.WHITE);
        add(c1);
        c2= new JCheckBox("Net Banking");
        c2.setBounds(100,530,300,20);
        c2.setBackground(Color.WHITE);
        add(c2);
        c3= new JCheckBox("Mobile Banking");
        c3.setBounds(100,550,300,20);
        c3.setBackground(Color.WHITE);
        add(c3);
        c4= new JCheckBox("EMAIL & SMS ALERT");
        c4.setBounds(100,570,300,20);
        c4.setBackground(Color.WHITE);
        add(c4);
        c5= new JCheckBox("Cheque Book");
        c5.setBounds(100,590,300,20);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6= new JCheckBox("I hereby declare that the above mentioned details are correct to the best of my knowledge.");
        c6.setBounds(100,630,600,30);
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,12));
        add(c6);


        ButtonGroup group1 = new ButtonGroup();
        group1.add(r1);
        group1.add(r2);
        group1.add(r3);
        group1.add(r4);


        submit = new JButton("Submit");
        submit.setBounds(650,670,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(100,670,100,30);
        cancel.addActionListener(this);
        add(cancel);
        



        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            String type = null;
            if (r1.isSelected()){
                type = "Saving Account";
            }else if (r2.isSelected())
            {
                type = "Fixed Deposit Account";
            }
            else if (r3.isSelected())
            {
                type = "Current Account";
            }
            else if (r4.isSelected())
            {
                type = "Recurrent Deposit Account";
            }
            Random rand = new Random();
            String cardno = ""+ Math.abs((rand.nextLong() % 90000000L) + 5040936000000000L);

            String pin = ""+ Math.abs((rand.nextLong()%9000L)+1000L);

            String facility = "";
                if(c1.isSelected()){
                    facility = facility+ " ATM CARD ";
                }else if(c2.isSelected()){
                    facility = facility+ " Net Banking ";
                }else if(c3.isSelected()){
                    facility = facility+ " Mobile Banking ";
                }else if(c4.isSelected()){
                    facility = facility+ " EMAIL & SMS ALERT ";
                }else if(c5.isSelected()){
                    facility = facility+ " Cheque Book ";
                }

                try{
                    if(type.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Account Type is required!");
                    }else
                    {
                        String query1 = "insert into signup3(formno,type,carno,pin,serv) values('"+formno+"','"+type+"','"+cardno+"','"+pin+"','"+facility+"')";
                        String query2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                        Conn c = new Conn();
                        c.s.executeUpdate(query1);
                        c.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null," Account Number: "+cardno+"\n PIN: "+pin);
                        setVisible(false);
                        new Deposit(pin).setVisible(true);
                    }
                }catch (Exception ae){
                    System.out.println(ae);
                }


        }else if(e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ApplicationForm3("");
    }
}
