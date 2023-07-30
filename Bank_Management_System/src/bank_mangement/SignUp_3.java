package bank_mangement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SignUp_3  extends JFrame implements ActionListener
{

    JRadioButton a1,a2,a3,a4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formNo;
    JButton submit ,cancel;
    SignUp_3(String formNO){
        formNo = formNO;
        JLabel title = new JLabel("Page 3 : Account Details");
        title.setFont(new Font("Raleway", Font.BOLD,30));
        title.setBounds(270,50,500,30);
        add(title);


        JLabel accType = new JLabel("Account Type");
        accType.setFont(new Font("Raleway", Font.BOLD,20));
        accType.setBounds(140,150,300,20);
        add(accType);

        a1 = new JRadioButton("Saving account");
        a1.setBounds(140,185,300,30);
        a1.setBackground(Color.WHITE);

        a1.setFont(new Font("Raleway", Font.BOLD,15));
        add(a1);

        a2 = new JRadioButton("Fixed Deposit Account");
        a2.setBackground(Color.WHITE);
        a2.setBounds(450,185,300,30);

        a2.setFont(new Font("Raleway", Font.BOLD,15));
        add(a2);

        a3 = new JRadioButton("Current Account");
        a3.setBounds(140,235,300,30);
        a3.setBackground(Color.WHITE);
        a3.setFont(new Font("Raleway", Font.BOLD,15));
        add(a3);

        a4 = new JRadioButton("Recurring Deposit Amount");
        a4.setBackground(Color.WHITE);
        a4.setFont(new Font("Raleway", Font.BOLD,15));
        a4.setBounds(450,235,400,30);
        add(a4);


        ButtonGroup btn = new ButtonGroup();
        btn.add(a1);
        btn.add(a2);
        btn.add(a3);
        btn.add(a4);


        JLabel cardDetails = new JLabel("Card Number");
        cardDetails.setFont(new Font("Raleway", Font.BOLD,20));
        cardDetails.setBounds(140,330,399,30);
        add(cardDetails);

        JLabel carddetails = new JLabel("XXXX-XXXX-XXXX-3242");
        carddetails.setFont(new Font("Raleway", Font.BOLD,25));
        carddetails.setBounds(370,335,399,30);
        add(carddetails);

        JLabel cardInfo = new JLabel("Your 16 digit Card Number");
        cardInfo.setFont(new Font("Raleway", Font.BOLD,10));
        cardInfo.setBounds(140,350,309,30);
        add(cardInfo);


        JLabel pin = new JLabel("PIN ");
        pin.setFont(new Font("Raleway", Font.BOLD,20));
        pin.setBounds(140,380,399,30);
        add(pin);

        JLabel Pin = new JLabel("XXXX");
        Pin.setFont(new Font("Raleway", Font.BOLD,25));
        Pin.setBounds(370,385,399,30);
        add(Pin);

        JLabel pinInfo = new JLabel("Your 4 digit Password ");
        pinInfo.setFont(new Font("Raleway", Font.BOLD,10));
        pinInfo.setBounds(140,395,309,30);
        add(pinInfo);

        JLabel services_ = new JLabel("Services Required ");
        services_.setFont(new Font("Raleway", Font.BOLD,25));

        services_.setBounds(140,460,500,30);
        add(services_);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD,15));
        c1.setBounds(140,510,300,30);
        add(c1);


        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD,15));
        c2.setBounds(440,510,300,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD,15));
        c3.setBounds(140,560,300,30);
        add(c3);

        c4 = new JCheckBox("Email & Sms Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD,15));
        c4.setBounds(440,560,300,30);
        add(c4);


        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD,15));
        c5.setBounds(140,610,300,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD,15));
        c6.setBounds(440,610,300,30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge !");
        c7.setBackground(Color.WHITE);
        c7.setBounds(140,700,700,30);
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setBounds(200,750,200,35);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setBounds(500,750,200,35);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(850,850);
        setLocation(350,100);
        setVisible(true);
        setResizable(false);

        setTitle("Account Details");

    }

    public static void main(String[] args) {
        new SignUp_3("");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == submit){
            String accountType = null;
            if (a1.isSelected()){
                accountType = "Saving Account";
            }
           else if (a2.isSelected()){
                accountType = "Fixed Deposit Amount";
            }else if (a3.isSelected()){
                accountType = "Current Account";

            }else if (a4.isSelected()){
                accountType = "Recurring Deposit Amount";
            }else{
                JOptionPane.showMessageDialog(null,"Please Choose Account Type");
            }
                Random random = new Random();
            long smallest = 1000_0000_0000_0000L;
            long biggest =  9999_9999_9999_9999L;

            // return a long between smallest and biggest (+1 to include biggest as well with the upper bound)
            String re = ""+ ThreadLocalRandom.current().nextLong(smallest, biggest+1);
            System.out.println(re);
            String pin = String.format("%04d", random.nextInt(10000));
            String facility = "";
            if (c1.isSelected()){
                facility += " ATM CARD";

            }
            if (c2.isSelected()){
                facility += " Internet Banking ";

            }
            if (c3.isSelected()){
                facility += " Mobile Banking ";

            }
            if (c4.isSelected()){
                facility += " Email & Sms Alerts ";

            }
            if (c5.isSelected()){
                facility += " Cheque Book ";

            }
            if (c6.isSelected()){
                facility += " E-Statement";

            }
            if (!(c7.isSelected())){
                JOptionPane.showMessageDialog(null,"Please check the last checkBox");
            }
            if (submit != null && c7.isSelected()){

                try
                {
                    conn signUP_3_data = new conn();
                    Date date = new Date();
                    String query = "insert into acc_details value('"+formNo+"','"+accountType+"','"+re+"','"+pin+"','"+facility+"')";
                    String query2 = "insert into login value('"+formNo+"','"+re+"','"+pin+"')";
                    String query3 = "insert into bank value('"+re+"','"+date+"','"+"Withdraw"+"','"+"0"+"','"+"0"+"')";
                    signUP_3_data.s.executeUpdate(query);
                    signUP_3_data.s.executeUpdate(query3);
                    signUP_3_data.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number : "+re+"\nPin : "+pin);
                    JOptionPane.showMessageDialog(null,"You have successfully signed up now you can login");
                    setVisible(false);
                    new Login();

                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                    System.out.println(e.getMessage());

                }
            }


        }
        else if(actionEvent.getSource() == cancel){
            setVisible(false);
            new Login();

        }
    }
}
