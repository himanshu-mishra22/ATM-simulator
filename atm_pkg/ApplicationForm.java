package atm_pkg;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ApplicationForm extends JFrame implements ActionListener {
    JTextField nameTxt,fnameTxt, mnameTxt,addTxt,cityTxt,stateTxt,pinTxt,emailTxt;
    long random;
    JDateChooser dobTxt;
    JRadioButton single,married,male,female;
    ButtonGroup gru,gru1;
    JButton next;
    public ApplicationForm(){
        setLayout(null);
        Random rand = new Random();
        random = Math.abs((rand.nextLong() % 9000L) + 1600L);

        JLabel heading = new JLabel("APPLICATION FORM NO. "+ random);
        heading.setFont(new Font("Raleway",Font.BOLD,38));
        heading.setBounds(140,20,640,40);
        add(heading);

        JLabel personalDetails = new JLabel("Page 1: Personal Details. ");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,40);
        add(personalDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,18));
        name.setBounds(160,160,160,30);
        add(name);

        nameTxt = new JTextField();
        nameTxt.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        nameTxt.setBounds(400,160,250,30);
        add(nameTxt);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        fname.setBounds(160,210,150,30);
        add(fname);

        fnameTxt = new JTextField();
        fnameTxt.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        fnameTxt.setBounds(400,210,250,30);
        add(fnameTxt);

        JLabel mname = new JLabel("Mother's Name: ");
        mname.setFont(new Font("Raleway",Font.BOLD,18));
        mname.setBounds(160,260,150,30);
        add(mname);

        mnameTxt = new JTextField();
        mnameTxt.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        mnameTxt.setBounds(400,260,250,30);
        add(mnameTxt);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,18));
        dob.setBounds(160,310,170,30);
        add(dob);

        dobTxt = new JDateChooser();
        dobTxt.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        dobTxt.setBounds(400,310,250,30);
        add(dobTxt);
        male = new JRadioButton("Male");
        male.setBounds(400,360,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(550,360,100,30);
        add(female);
        gru = new ButtonGroup();
        gru.add(male);
        gru.add(female);
        JLabel gen = new JLabel("Gender: ");
        gen.setFont(new Font("Raleway",Font.BOLD,18));
        gen.setBounds(160,360,170,30);
        add(gen);




        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD,18));
        email.setBounds(160,410,170,30);
        add(email);

        emailTxt = new JTextField();
        emailTxt.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        emailTxt.setBounds(400,410,250,30);
        add(emailTxt);

        JLabel status = new JLabel("Marital Status: ");
        status.setFont(new Font("Raleway",Font.BOLD,18));
        status.setBounds(160,460,170,30);
        add(status);
        single = new JRadioButton("Single");
        single.setBounds(400,460,100,30);
        single.setBackground(Color.WHITE);
        add(single);
        married = new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(550,460,100,30);
        add(married);
        gru1 = new ButtonGroup();
        gru1.add(single);
        gru1.add(married);

        next = new JButton("Next");
        next.setBounds(680,660,80,30);
        next.addActionListener(this);
        add(next);



        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,18));
        address.setBounds(160,510,170,30);
        add(address);

        addTxt = new JTextField();
        addTxt.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        addTxt.setBounds(400,510,250,30);
        add(addTxt);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,18));
        city.setBounds(160,560,170,30);
        add(city);

        cityTxt = new JTextField();
        cityTxt.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        cityTxt.setBounds(400,560,250,30);
        add(cityTxt);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,18));
        state.setBounds(160,610,170,30);
        add(state);

        stateTxt = new JTextField();
        stateTxt.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        stateTxt.setBounds(400,610,250,30);
        add(stateTxt);

        JLabel pin = new JLabel("Pin Code: ");
        pin.setFont(new Font("Raleway",Font.BOLD,18));
        pin.setBounds(160,660,170,30);
        add(pin);

        pinTxt = new JTextField();
        pinTxt.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        pinTxt.setBounds(400,660,250,30);
        add(pinTxt);



        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ApplicationForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = ""+random;
        String name = nameTxt.getText();
        String fname = fnameTxt.getText();
        String mname = mnameTxt.getText();
        String dob = ((JTextField) dobTxt.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
         String email = emailTxt.getText();
        String marital = null;
        if(single.isSelected()){
            marital = "Single";
        }else if(married.isSelected()){
            marital = "Married";
        }
        String add = addTxt.getText();
        String city = cityTxt.getText();
        String state = stateTxt.getText();
        String pin = pinTxt.getText();

        try {
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signup1 (formno, name, fname, mname, dob, gender, email, marital, addr, city, state, pin) VALUES ('"
                        + formno + "','" + name + "','" + fname + "','" + mname + "','" + dob + "','" + gender + "','"
                        + email + "','" + marital + "','" + add + "','" + city + "','" + state + "','" + pin + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Application Submitted Successfully");

                setVisible(false);
                new ApplicationForm2(formno).setVisible(true);

            }
        } catch (Exception ae) {
            System.out.println(ae);
        }
    }
}
