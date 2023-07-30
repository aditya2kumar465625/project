package bank_mangement;
import com.toedter.calendar.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUP_Main extends JFrame implements ActionListener {
    JTextField Name , Fname,Address,City,State,Pin,Email;
    long formNO;
    JButton next,back;
    JRadioButton Male ,FeMale,married,single;
    JDateChooser dob;
    SignUP_Main(){
        Random  random = new Random();
        formNO = Math.abs((random.nextLong() % 900 ) + 1000L);
        JLabel ApplicationNo = new JLabel("APPLICATION FORM NO. : "+formNO);
        ApplicationNo.setFont(new Font("Arial",Font.BOLD,35));
        ApplicationNo.setBounds(75,20,650,30);
        add(ApplicationNo);

        JLabel psDetails = new JLabel("PAGE 1 : PERSONAL DETAILS");
        psDetails.setFont(new Font("Arial",Font.BOLD,20));
        psDetails.setBounds(200,65,400,30);
        add(psDetails);


        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(120,155,200,30);
        add(name);

        Name = new JTextField();
        Name.setFont(new Font("Raleway",Font.BOLD,15));
        Name.setBounds(400,155,300,30);
        add(Name);


        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(120,205,200,30);
        add(fname);

        Fname = new JTextField();
        Fname.setFont(new Font("Raleway",Font.BOLD,15));
        Fname.setBounds(400,205,300,30);
        add(Fname);

        JLabel DOB = new JLabel("Date Of Birth : ");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(120,255,200,30);
        add(DOB);

        dob = new JDateChooser();
        dob.setForeground(Color.BLACK);
        dob.setBounds(400,255,300,30);
        add(dob);


        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(120,305,200,30);
        add(gender);

        Male = new JRadioButton("Male");
        Male.setBackground(Color.WHITE);
        Male.setBounds(400,305,100,20);
        add(Male);

        FeMale = new JRadioButton("Female");
        FeMale.setBackground(Color.WHITE);
        FeMale.setBounds(500,305,100,20);
        add(FeMale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(Male);
        genderGroup.add(FeMale);


        JLabel mStatus = new JLabel("Marital Status : ");
        mStatus.setFont(new Font("Raleway",Font.BOLD,20));
        mStatus.setBounds(120,355,200,30);
        add(mStatus);

        married = new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(400,355,100,20);
        add(married);

        single = new JRadioButton("Single");
        single.setBackground(Color.WHITE);
        single.setBounds(500,355,100,20);
        add(single);

        ButtonGroup mGroup = new ButtonGroup();
        mGroup.add(single);
        mGroup.add(married);

        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(120,405,200,30);
        add(email);

        Email = new JTextField();
        Email.setFont(new Font("Raleway",Font.BOLD,15));
        Email.setBounds(400,405,300,30);
        add(Email);

        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(120,455,200,30);
        add(address);


        Address = new JTextField();
        Address.setFont(new Font("Raleway",Font.BOLD,15));
        Address.setBounds(400,455,300,30);
        add(Address);

        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(120,505,200,30);
        add(city);

        City = new JTextField();
        City.setFont(new Font("Raleway",Font.BOLD,15));
        City.setBounds(400,505,300,30);
        add(City);


        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(120,555,200,30);
        add(state);


        State = new JTextField();
        State.setFont(new Font("Raleway",Font.BOLD,15));
        State.setBounds(400,555,300,30);
        add(State);


        JLabel pincode = new JLabel("Pin Code : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(120,605,200,30);
        add(pincode);


        Pin = new JTextField();
        Pin.setFont(new Font("Raleway",Font.BOLD,15));
        Pin.setBounds(400,605,300,30);
        add(Pin);



        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(550,670,200,40);
        next.addActionListener(this);
        add(next);

        back = new JButton("already have a account?");
        back.setBackground(Color.WHITE);
        back.setBorder(null);
        back.addActionListener(this);
        back.setForeground(Color.BLACK);
        back.setBounds(450,730,400,40);
        back.addActionListener(this);
        add(back);





        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800,850);
        setVisible(true);
        setResizable(false);

        setLocation(250,50);
        setTitle("SIGN UP");

    }

    public static void main(String[] args) {
        new SignUP_Main();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String formNo = ""+formNO;
        String name = Name.getText();
        String fatherName  = Fname.getText();
        String Dob = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (Male.isSelected()){
            gender = "Male";
        }
        else{
            gender = "Female";
        }
        String address = Address.getText();
        String city = City.getText();
        String state = State.getText();
        String email = Email.getText();
        String pin = Pin.getText();
        String Marital = null;
        if (married.isSelected()){
            Marital = "Married";

        }
        else{
            Marital = "Single";
        }
if (actionEvent.getSource().equals(back)){
    setVisible(false);
    new Login();
}
else {


try {


    if (Name.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Name is Required");

    } else if (Fname.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Father Name is Required");

    } else if (((JTextField) dob.getDateEditor().getUiComponent()).getText().equals("")) {
        JOptionPane.showMessageDialog(null,"date is required");

    }
    else if (!(Male.isSelected() || FeMale.isSelected())) {
        JOptionPane.showMessageDialog(null,"Gender is required");

    }

    else if (!(married.isSelected() || single.isSelected())) {
        JOptionPane.showMessageDialog(null,"Marital status is required");

    }

    else if (Email.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Email is Required");

    }
    else if (Address.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Address is Required");

    }

    else if (City.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "City is Required ");
    } else if (State.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "State is Required ");
    } else if (Pin.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Pin code  is Required ");
    } else if (Pin.getText().length() != 6) {
        JOptionPane.showMessageDialog(null, "Invalid Pin");


    } else {
        conn in = new conn();
        String query = "insert into signup values('"+formNo+"','"+name+"','"+fatherName+"','"+Dob+"','"+gender+"','"+Marital+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
        in.s.executeUpdate(query);
        setVisible(false);
       new SignUP_2(formNo);
    }



}
catch (Exception e){
    System.out.println(e.getMessage());
}}
    }
}
