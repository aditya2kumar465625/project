package bank_mangement;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JTextField withdraw;
    JButton Withdrawl, Back;
    String Card;

    Withdraw(String card) {
        Card = card;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);

        JLabel jLabel = new JLabel("Enter the amount you want to Withdraw");
        jLabel.setFont(new Font("", Font.BOLD, 15));
        jLabel.setBounds(170, 320, 400, 30);
        jLabel.setForeground(Color.WHITE);
        img.add(jLabel);

        withdraw = new JTextField();
        withdraw.setBounds(170, 360, 330, 25);
        img.add(withdraw);

        Withdrawl = new JButton("Withdraw");
        Withdrawl.addActionListener(this);
        Withdrawl.setBounds(360, 470, 150, 30);
        img.add(Withdrawl);

        Back = new JButton("Back");
        Back.addActionListener(this);
        Back.setBounds(360, 510, 150, 30);
        img.add(Back);


        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setResizable(false);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Withdraw("");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(Back)) {
            setVisible(false);
            new transaction(Card);

        } else if (actionEvent.getSource().equals(Withdrawl)) {
            int amount1;
            try {
                int de = Integer.parseInt(withdraw.getText());
                amount1 = de;
            } catch (Exception e) {
                amount1 = -1;
            }
            if (!(amount1 > 0)) {
                JOptionPane.showMessageDialog(null, "invalid amount");
                withdraw.setText("");
            } else {


                conn cn = new conn();
                Date date = new Date();
                String bl = "select * from bank where card = '"+Card+"'";
                String bl1 ="0";
                int balance =0;
                try (ResultSet rs = cn.s.executeQuery(bl)) {

                    while (rs.next()){

                        balance = Integer.parseInt(rs.getString("Balance"));


                    }
                    balance -= Integer.parseInt(withdraw.getText());
                        

                }
                catch (Exception e){
                    System.out.println(e);
                }
                String query = "insert into bank value('" + Card + "','" + date + "','"+"Withdraw"+"','"+withdraw.getText()+"','"+balance+"')";
                try {
                    cn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Successfully " + withdraw.getText() + " amount Debited ");
                    setVisible(false);
                    new transaction(Card);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            }
        }
    }
}
