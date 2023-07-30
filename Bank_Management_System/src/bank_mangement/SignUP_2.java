package bank_mangement;
import com.toedter.calendar.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUP_2 extends JFrame implements ActionListener {
    JTextField pan,City,State,Pin,Email,Name,Fname,Address,aadhar;
    String formNO;

    String ch = "Choose Option";
JComboBox rel,cate,inc,educ,occ;
    JButton next;
    JRadioButton Male ,FeMale,married,single,sYes,sNo,eYes,eNo;
    JDateChooser dob;
    SignUP_2(String form){
        formNO = form;
        setTitle("New Account Application Form - Page 2");
        JLabel ApplicationNo = new JLabel("APPLICATION FORM NO. : "+form);
        ApplicationNo.setFont(new Font("Arial",Font.BOLD,35));
        ApplicationNo.setBounds(75,20,650,30);
        add(ApplicationNo);



        JLabel addDetails = new JLabel("PAGE 2 : ADDITIONAL DETAILS");
        addDetails.setFont(new Font("Arial",Font.BOLD,20));
        addDetails.setBounds(200,65,400,30);
        add(addDetails);


        JLabel Religion = new JLabel("Religion : ");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(120,155,200,30);
        add(Religion);

        String[] R = {"Choose Option","Hindu","Muslim","Sikh","Christian","Other"};
        rel = new JComboBox<>(R);
        rel.setBackground(Color.WHITE);
        rel.setForeground(Color.BLACK);
        rel.setFont(new Font("Raleway",Font.BOLD,15));
        rel.setBounds(400,155,300,30);
        add(rel);


        JLabel Category = new JLabel("Category : ");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(120,205,200,30);
        add(Category);

        String[] C = {"Choose Option","GENERAL","OBC","SC/ST"};
        cate = new JComboBox(C);
        cate.setFont(new Font("Raleway",Font.BOLD,15));
        cate.setBackground(Color.WHITE);
        cate.setForeground(Color.BLACK);
        cate.setBounds(400,205,300,30);
        add(cate);

        JLabel INCOME = new JLabel("Income :");
        INCOME.setFont(new Font("Raleway",Font.BOLD,20));
        INCOME.setBounds(120,255,200,30);
        add(INCOME);

        String[] I ={"Choose Option","NULL","<150000","<200000","<500000","UpTo 10L"};
        inc = new JComboBox(I);


        inc.setForeground(Color.BLACK);
        inc.setBackground(Color.WHITE);
        inc.setBounds(400,255,300,30);
        add(inc);


        JLabel Education = new JLabel("Educational ");
        Education.setFont(new Font("Raleway",Font.BOLD,20));
        Education.setBounds(120,305,200,30);
        add(Education);

        JLabel Qualification = new JLabel("Qualification : ");
        Qualification.setFont(new Font("Raleway",Font.BOLD,20));
        Qualification.setBounds(120,335,200,30);
        add(Qualification);


        String[] E ={"Choose Option","NON-GRADUATION","GRADUATE","POST-GRADUATION","DOCTRATE","OTHERS"};
        educ = new JComboBox(E);
        educ.setBackground(Color.WHITE);
        educ.setForeground(Color.BLACK);
        educ.setBounds(400,325,300,30);
        add(educ);




        JLabel Occupation = new JLabel("Occupation : ");
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        Occupation.setBounds(120,405,200,30);
        add(Occupation);

        String[] O = {"Employee","Student","Retired","Business","Others"};
       occ = new JComboBox(O);
        occ.setFont(new Font("Raleway",Font.BOLD,15));
        occ.setBackground(Color.WHITE);
        occ.setBounds(400,405,300,30);
        add(occ);

        JLabel PAN = new JLabel("PAN No. : ");
        PAN.setFont(new Font("Raleway",Font.BOLD,20));
        PAN.setBounds(120,455,200,30);
        add(PAN);


        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,15));
        pan.setBounds(400,455,300,30);
        add(pan);

        JLabel Aadhar = new JLabel("Aadhar No. : ");
        Aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        Aadhar.setBounds(120,505,200,30);
        add(Aadhar);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,15));
        aadhar.setBounds(400,505,300,30);
        add(aadhar);


        JLabel Citizen = new JLabel("Senior Citizen : ");
        Citizen.setFont(new Font("Raleway",Font.BOLD,20));
        Citizen.setBounds(120,555,400,30);
        add(Citizen);

        sYes = new JRadioButton("YES");
        sYes.setBounds(400,555,100,30);
        sYes.setBackground(Color.WHITE);
        add(sYes);

        sNo = new JRadioButton("NO");
        sNo.setBackground(Color.WHITE);
        sNo.setBounds(600,555,100,30);
        add(sNo);

        ButtonGroup bt =new ButtonGroup();
        bt.add(sYes);
        bt.add(sNo);


        JLabel Existing = new JLabel("Existing Account : ");
        Existing.setFont(new Font("Raleway",Font.BOLD,20));
        Existing.setBounds(120,605,400,30);
        add(Existing);

        eYes = new JRadioButton("YES");
        eYes.setBounds(400,605,100,30);
        eYes.setBackground(Color.WHITE);
        add(eYes);

        eNo = new JRadioButton("NO");
        eNo.setBackground(Color.WHITE);
        eNo.setBounds(600,605,100,30);
        add(eNo);

        ButtonGroup bt1 = new ButtonGroup();
        bt1.add(eYes);
        bt1.add(eNo);


        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(550,670,200,40);
        next.addActionListener(this);
        add(next);


        setResizable(false);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        setSize(800,800);
        setVisible(true);
        setLocation(250,50);


    }

    public static void main(String[] args) {
        new SignUP_2("");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String formNo = ""+formNO;
        String religion = (String) rel.getSelectedItem();
        String category  = (String) cate.getSelectedItem();
        String income = (String) inc.getSelectedItem();
        String eq = (String) educ.getSelectedItem();

        String occupation = (String) occ.getSelectedItem();
        String pan_No = pan.getText();
        String adhar =aadhar.getText();
        String se = null;
        if (eYes.isSelected()){
            se = "YES";
        }
        else {
            se = "NO";
        }

        String eaccount = null;
        if (eYes.isSelected()){
            eaccount = "YES";

        }
        else{
            eaccount = "NO";
        }

        try {
            long pinCheck = 1;
            try {
                long  de = (Integer.parseInt(aadhar.getText().substring(0,6)));
                long  de2 = (Integer.parseInt(aadhar.getText().substring(6)));


                pinCheck = 1;
            } catch (Exception e) {

                pinCheck = -1;
            }
            long pinCheck2;
            try {
                long  de = (Integer.parseInt(pan.getText().substring(0,6)));
                long  de2 = (Integer.parseInt(pan.getText().substring(6)));

                pinCheck2 = 1;
            } catch (Exception e) {
                pinCheck2 = -1;
            }

            if (rel.getSelectedItem().equals(ch)) {
                JOptionPane.showMessageDialog(null, "Religion is Required");

            } else if (cate.getSelectedItem().equals(ch)) {
                JOptionPane.showMessageDialog(null, "Category Name is Required");

            } else if (inc.getSelectedItem().equals(ch)) {
                JOptionPane.showMessageDialog(null,"Income is required");

            }
            else if (educ.getSelectedItem().equals(ch)) {
                JOptionPane.showMessageDialog(null,"Education Qualification  is required");

            }

            else if (occ.getSelectedItem().equals(ch)) {
                JOptionPane.showMessageDialog(null,"Marital status is required");

            }

            else if (pan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Pan is Required");

            }
            else if (aadhar.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar is Required");

            }

            else if (!(sYes.isSelected() || sNo.isSelected())) {
                JOptionPane.showMessageDialog(null, "City is Required ");
            } else if (!(eYes.isSelected() || eNo.isSelected())) {
                JOptionPane.showMessageDialog(null, "Existing account is Required ");
            }
            else if (aadhar.getText().length() != 12){

                JOptionPane.showMessageDialog(null,"Invalid Aadhar ");
            } else if (pinCheck == -1) {
                  JOptionPane.showMessageDialog(null,"Invalid Aadhar  ");

            }

            else if (pan.getText().length() != 10){

                JOptionPane.showMessageDialog(null,"Invalid Pan ");
            } else if (pinCheck2 == -1) {
                JOptionPane.showMessageDialog(null,"Invalid Pan ");

            }

            else {
                conn in = new conn();
                String query = "insert into signup_two values('"+formNO+"','"+religion+"','"+category+"','"+income+"','"+eq+"','"+occupation+"','"+pan_No+"','"+adhar+"','"+se+"','"+eaccount+"')";
                in.s.executeUpdate(query);
                setVisible(false);
                new SignUp_3(formNO);
            }



        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
