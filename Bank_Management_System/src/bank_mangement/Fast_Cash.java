package bank_mangement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.ResultSet;

public class Fast_Cash extends JFrame implements ActionListener {
    String Card;
    JButton hundred, five_hundred, thousand, two_thousand, five_thousand, ten_thousand, exit;

    Fast_Cash(String card) {
        Card = card;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0, 0, 900, 900);
        add(i4);

        JLabel title = new JLabel("Please Select Your Cash Amount");
        title.setForeground(Color.WHITE);
        title.setBounds(200, 300, 700, 30);
        title.setFont(new Font("Raleway", Font.PLAIN, 20));
        i4.add(title);


        hundred = new JButton("100");
        hundred.setBackground(Color.WHITE);
        hundred.setForeground(Color.BLACK);

        hundred.addActionListener(this);

        hundred.setBounds(160, 415, 150, 30);
        i4.add(hundred);

        five_hundred = new JButton("500");
        five_hundred.setBackground(Color.WHITE);
        five_hundred.setForeground(Color.BLACK);
        five_hundred.addActionListener(this);

        five_hundred.setBounds(350, 415, 160, 30);
        i4.add(five_hundred);

        thousand = new JButton("1000");
        thousand.setBackground(Color.WHITE);
        thousand.setForeground(Color.BLACK);
        thousand.addActionListener(this);

        thousand.setBounds(160, 450, 150, 30);
        i4.add(thousand);

        two_thousand = new JButton("2000");
        two_thousand.setBackground(Color.WHITE);
        two_thousand.setForeground(Color.BLACK);
        two_thousand.setBounds(350, 450, 160, 30);
        two_thousand.addActionListener(this);

        i4.add(two_thousand);


        five_thousand = new JButton("5000");
        five_thousand.setBackground(Color.WHITE);
        five_thousand.setForeground(Color.BLACK);
        five_thousand.addActionListener(this);

        five_thousand.setBounds(160, 485, 150, 30);
        i4.add(five_thousand);

        ten_thousand = new JButton("10000");
        ten_thousand.setBackground(Color.WHITE);
        ten_thousand.setForeground(Color.BLACK);
        ten_thousand.setBounds(350, 485, 160, 30);
        ten_thousand.addActionListener(this);

        i4.add(ten_thousand);

        exit = new JButton("EXIT");
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.setBounds(350, 520, 160, 30);
        exit.addActionListener(this);
        i4.add(exit);

        setVisible(true);
        setResizable(false);
        setSize(900, 900);
        setLocation(300, 0);


    }

    public static void main(String[] args) {
        new Fast_Cash("");
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(exit)) {
            setVisible(false);
            new transaction(Card);
        } else {
            String cButton = ((JButton) actionEvent.getSource()).getText();

            conn c = new conn();
            int balance = 0;

            try {
                String query = "select * from bank where card = '" + Card + "'";
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {

                    balance = Integer.parseInt(rs.getString("Balance"));


                }



                Date date = new Date();


                if (actionEvent.getSource() != exit && balance >= Integer.parseInt(cButton)) {
                    balance -= Integer.parseInt(((JButton) (actionEvent.getSource())).getText());
                    String query2 = "insert into bank value('" + Card + "','" + date + "','" + "Withdraw" + "','" + cButton + "','" + balance + "')";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Withdraw successfully \n Current Balance : " + balance);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance ");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
