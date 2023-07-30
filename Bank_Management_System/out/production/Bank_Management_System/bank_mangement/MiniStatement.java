package bank_mangement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String Card;
    JButton btn;
    MiniStatement(String card){
        Card = card;

        JLabel label = new JLabel("Previous Transaction history ");
        label.setFont(new Font("Raleway",Font.BOLD,18));
        label.setBounds(50,50,300,30);
        add(label);

        JLabel cardInfo = new JLabel("Card Detail. : ");
        cardInfo.setBounds(50,85,300,20);
        add(cardInfo);

        JLabel cardDetails = new JLabel("XXXX-XXXX-XXXX-XXXX-"+Card.substring(12));
        cardDetails.setBounds(50,100,400,30);
        add(cardDetails);

conn c = new conn();
int y = 0,i = 0;
JLabel info = new JLabel();
String[] str = new String[5];
        JLabel info1 = new JLabel();
        JLabel inf2 = new JLabel();
        JLabel inf3 = new JLabel();
        JLabel info4 = new JLabel();

           String cn= "";
           JLabel type = new JLabel("                  Date                                   Type              Amount");
           type.setBounds(50,140,400,30);
           add(type);
           try {
               String query = "select * from bank where card = '"+Card+"' order by date desc limit 5";
               ResultSet rs = c.s.executeQuery(query);
              while (rs.next()) {
                  if (rs.getString("type").equals("Withdraw")) {
                      str[i] = "" + rs.getString("date") + "            " + rs.getString("type") + "          " + rs.getString("amount");
                  }else {
                      str[i] = "" + rs.getString("date") + "            " + rs.getString("type") + "              " + rs.getString("amount");

                  }

                  if (i==0){
                        cn = rs.getString("Balance");
                    }
                        i++;
              }
               info.setText(str[0]);
               info.setBounds(50,170,400,30);
               add(info);

               info1.setText(str[1]);
               info1.setBounds(50,200,400,30);
               add(info1);
               inf2.setText(str[2]);
               inf2.setBounds(50,230,400,30);
               add(inf2);
               inf3.setText(str[3]);
               inf3.setBounds(50,270,400,30);
               add(inf3);
               info4.setText(str[4]);
               info4.setBounds(50,300,400,30);
               add(info4);

               JLabel balance = new JLabel("Your current Balance is : "+cn);
               balance.setFont(new Font("Raleway",Font.BOLD,20));
               balance.setBounds(50,370,400,40);
               add(balance);

           }
           catch (Exception e){
               JOptionPane.showMessageDialog(null,e.getMessage());

           }

btn = new JButton("BACK");
           btn.setBackground(Color.BLACK);
           btn.setForeground(Color.white);
           btn.setBounds(300,470,150,30);
           btn.addActionListener(this);
           add(btn);

        setLayout(null);
        setResizable(false);
        setSize(500,550);
        setLocation(300,50);
        setVisible(true);

    }


    public static void main(String[] args) {
        new MiniStatement("5067302602996798");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        new transaction(Card);
    }
}
