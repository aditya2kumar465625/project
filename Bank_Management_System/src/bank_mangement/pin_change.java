package bank_mangement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class pin_change extends JFrame implements ActionListener {
    String Card;
    JPasswordField crPin, newPin, newPin2;
    JButton changePin, back;

    pin_change(String card) {
        Card = card;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);


        JLabel jLabel = new JLabel("Enter Your Current Pin : ");
        jLabel.setFont(new Font("", Font.BOLD, 20));
        jLabel.setBounds(170, 290, 400, 20);
        jLabel.setForeground(Color.WHITE);
        img.add(jLabel);

        crPin = new JPasswordField();
        crPin.setBounds(170, 320, 330, 30);
        img.add(crPin);


        JLabel crpin = new JLabel("New Pin : ");
        crpin.setFont(new Font("", Font.BOLD, 20));
        crpin.setBounds(170, 360, 400, 20);
        crpin.setForeground(Color.WHITE);
        img.add(crpin);

        newPin = new JPasswordField();
        newPin.setBounds(170, 390, 330, 30);
        img.add(newPin);


        JLabel crpin2 = new JLabel("Re-Enter Pin : ");
        crpin2.setFont(new Font("", Font.BOLD, 20));
        crpin2.setBounds(170, 430, 400, 20);
        crpin2.setForeground(Color.WHITE);
        img.add(crpin2);

        newPin2 = new JPasswordField();
        newPin2.setBounds(170, 460, 330, 30);
        img.add(newPin2);

        changePin = new JButton("CHANGE PIN");
        changePin.setBackground(Color.white);
        changePin.setForeground(Color.black);
        changePin.setBounds(350, 510, 150, 30);
        changePin.addActionListener(this);
        img.add(changePin);


        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBounds(170, 510, 150, 30);
        back.addActionListener(this);
        img.add(back);

        setLayout(null);
        setVisible(true);
        setResizable(false);
        setSize(900, 900);
        setLocation(300, 0);


    }


    public static void main(String[] args) {
        new pin_change("");

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource().equals(changePin)) {
            String query = "select * from login where car_no  = '" + Card + "'";

            conn c = new conn();
            Boolean Pin = false;
            try (ResultSet rs = c.s.executeQuery(query)) {
                rs.next();
                Pin = rs.getString("PIN").equals(crPin.getText());


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.out.println(e.getMessage());
            }
            if (Pin) {

                int pinCheck;
                try {
                    int de = Integer.parseInt(newPin.getText());
                    pinCheck = de;
                } catch (Exception e) {
                    pinCheck = -1;
                }
                if (!(pinCheck > 0)) {
                    JOptionPane.showMessageDialog(null, "invalid Pin");
                    newPin.setText("");
                    newPin2.setText("");
                    crPin.setText("");
                }else {
                    if (newPin.getText().equals(newPin2.getText())) {
                        if (newPin.getText().length() == 4) {

                            String query1 = "UPDATE login SET pin = '" + newPin.getText() + "' where car_no = '" + Card + "'";
                            String query2 = "UPDATE acc_details SET PIN = '" + newPin.getText() + "' where Card_Numbers = '" + Card + "'";

                            try {
                                c.s.executeUpdate(query1);
                                c.s.executeUpdate(query2);
                                JOptionPane.showMessageDialog(null, "Pin updated successfully");
                                setVisible(false);
                                new transaction(Card);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Pin must be 4 digit \n" +
                                    "and can't be empty");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "new pin or re enter pin doesn't match");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Old pin doesn't match");

            }

        } else if (actionEvent.getSource().equals(back)) {
            setVisible(false);
            new transaction(Card);

        }
    }

}
