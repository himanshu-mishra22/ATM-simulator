package atm_pkg;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ApplicationForm2 extends JFrame implements ActionListener  {
    JTextField emailTxt,addhr;
    JRadioButton yes,no,eyes,eno;
    ButtonGroup gru,gru1;
    JComboBox  religion,category,income,educated,occupation;
    String Formno;


    JButton next;
    public ApplicationForm2(String FormNo){
        this.Formno = Formno;
        setLayout(null);

        setTitle("Application form 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details. ");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,40);
        add(additionalDetails);

        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway",Font.BOLD,18));
        name.setBounds(160,160,160,30);
        add(name);

        String []val ={"Hindu","Muslim","Sikh","Christian","Other"} ;
        religion = new JComboBox(val);
        religion.setBackground(Color.WHITE);
        religion.setBounds(400,160,250,30);
        add(religion);

        JLabel fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        fname.setBounds(160,210,150,30);
        add(fname);

        String []cat ={"UR","SC","ST","OBC","Other"} ;
        category = new JComboBox(cat);
        category.setBackground(Color.WHITE);
        category.setBounds(400,210,250,30);
        add(category);

        JLabel mname = new JLabel("Income: ");
        mname.setFont(new Font("Raleway",Font.BOLD,18));
        mname.setBounds(160,260,150,30);
        add(mname);

        String []inc ={"NIL","less than 100000","less than 500000","less than 1000000","less than 2000000"} ;
        income = new JComboBox(inc);
        income.setBackground(Color.WHITE);
        income.setBounds(400,260,250,30);
        add(income);

        JLabel dob = new JLabel("Education: ");
        dob.setFont(new Font("Raleway",Font.BOLD,18));
        dob.setBounds(160,310,170,30);
        add(dob);

        String []edu ={"Uneducated","Matric","Intermediate or equi.","Graduate","Post Graduate","Doctorate"} ;
        educated = new JComboBox(edu);
        educated.setBackground(Color.WHITE);
        educated.setBounds(400,310,250,30);
        add(educated);

        JLabel gen = new JLabel("Occupation: ");
        gen.setFont(new Font("Raleway",Font.BOLD,18));
        gen.setBounds(160,360,170,30);
        add(gen);

        String []occ ={"Unemployed","Private sector","Government Job","House wife","Other"} ;
        occupation= new JComboBox(occ);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(400,360,250,30);
        add(occupation);



        JLabel email = new JLabel("PAN Card number: ");
        email.setFont(new Font("Raleway",Font.BOLD,18));
        email.setBounds(160,410,200,30);
        add(email);

        emailTxt = new JTextField();
        emailTxt.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        emailTxt.setBounds(400,410,250,30);
        add(emailTxt);

        JLabel status = new JLabel("Adhaar Card number: ");
        status.setFont(new Font("Raleway",Font.BOLD,18));
        status.setBounds(160,460,200,30);
        add(status);

        addhr = new JTextField();
        addhr.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        addhr.setBounds(400,460,250,30);
        add(addhr);

        next = new JButton("Next");
        next.setBounds(680,660,80,30);
        next.addActionListener(this);
        add(next);



        JLabel address = new JLabel("Senior Citizen: ");
        address.setFont(new Font("Raleway",Font.BOLD,18));
        address.setBounds(160,510,170,30);
        add(address);

        yes = new JRadioButton("Yes");
        yes.setBounds(400,510,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        no = new JRadioButton("No");
        no.setBackground(Color.WHITE);
        no.setBounds(550,510,100,30);
        add(no);
        gru = new ButtonGroup();
        gru.add(yes);
        gru.add(no);

        JLabel city = new JLabel("Existing Account: ");
        city.setFont(new Font("Raleway",Font.BOLD,18));
        city.setBounds(160,560,170,30);
        add(city);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(400,560,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBackground(Color.WHITE);
        eno.setBounds(550,560,100,30);
        add(eno);
        gru1 = new ButtonGroup();
        gru1.add(eyes);
        gru1.add(eno);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ApplicationForm2("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String rel = (String)religion.getSelectedItem();
        String cate = (String)category.getSelectedItem();
        String inco  = (String)income.getSelectedItem();
        String educ = (String)educated.getSelectedItem();
        String occc = (String)occupation.getSelectedItem();
        String senCit = null;
        if(yes.isSelected()){
            senCit = "Yes";
        }else if(no.isSelected()){
            senCit = "No";
        }

        String exist = null;
        if(eyes.isSelected()){
            exist = "Yes";
        }else if(eno.isSelected()){
            exist = "No";
        }
        String pan = emailTxt.getText();
        String addh = addhr.getText();


        try {
            if (pan.equals("")) {
                JOptionPane.showMessageDialog(null, "PAN is required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signup2 (formno,rel,cate,inco,edu,occ,senCit,exist,pan,addr ) VALUES ('"
                         +Formno+ "','" + rel + "','" + cate+ "','" + inco + "','" + educ+ "','" + occc + "','"
                        + senCit + "','" + exist + "','" + pan+ "','" + addh +"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Application Submitted Successfully");
                setVisible(false);
                new ApplicationForm3(Formno).setVisible(true);
            }
        } catch (Exception ae) {
            System.out.println(ae);
        }
    }
}

