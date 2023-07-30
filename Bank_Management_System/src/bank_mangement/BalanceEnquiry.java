package bank_mangement;

import org.w3c.dom.html.HTMLImageElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String Card,balance = "0";

    JLabel txt;
    JButton btn ;
    BalanceEnquiry(String Card){
        this.Card = Card;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
conn cn = new conn();

        String query = "select * from bank where card = '"+Card+"'";
        try (ResultSet rs = cn.s.executeQuery(query)) {
            while(rs.next()){

                balance = rs.getString("Balance");
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        txt = new JLabel("Your current balance is : "+balance);
        txt.setBounds(165,340,400,30);
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("Raleway",Font.BOLD,17));
        img.add(txt);

        btn = new JButton("BACK");
        btn.setForeground(Color.black);
        btn.setBackground(Color.white);
        btn.addActionListener(this);
        btn.setBounds(340,510,170,30);
        add(btn);

        setLayout(null);
        setResizable(false);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
            setVisible(false);
            new transaction(Card);
    }
}
