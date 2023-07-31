package bank_mangement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction extends JFrame implements ActionListener {
    String Card;
    JButton deposit,cash_withdraw,fast_cash,mini_statement,pin_change,balance_enquiry,exit;
    transaction(String  card) {

        Card = card;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0, 0, 900, 900);
        add(i4);

        JLabel title = new JLabel("Please Select Your Transaction");
        title.setForeground(Color.WHITE);
        title.setBounds(200,300,700,30);
        title.setFont(new Font("Raleway",Font.PLAIN,20));
        i4.add(title);



        deposit = new JButton("Deposit");
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);

        deposit.addActionListener(this);

        deposit.setBounds(160,415,150,30);
        i4.add(deposit);

        cash_withdraw = new JButton("CASH WITHDRAW");
        cash_withdraw.setBackground(Color.WHITE);
        cash_withdraw.setForeground(Color.BLACK);
        cash_withdraw.addActionListener(this);

        cash_withdraw.setBounds(350,415,160,30);
        i4.add(cash_withdraw);

        fast_cash = new JButton("FAST CASH");
        fast_cash.setBackground(Color.WHITE);
        fast_cash.setForeground(Color.BLACK);
        fast_cash.addActionListener(this);

        fast_cash.setBounds(160,450,150,30);
        i4.add(fast_cash);

        mini_statement = new JButton("MINI STATEMENT");
        mini_statement.setBackground(Color.WHITE);
        mini_statement.setForeground(Color.BLACK);
        mini_statement.setBounds(350,450,160,30);
        mini_statement.addActionListener(this);

        i4.add(mini_statement);


        pin_change = new JButton("PIN CHANGE");
        pin_change.setBackground(Color.WHITE);
        pin_change.setForeground(Color.BLACK);
        pin_change.addActionListener(this);

        pin_change.setBounds(160,485,150,30);
        i4.add(pin_change);

        balance_enquiry = new JButton("BALANCE ENQUIRY");
        balance_enquiry.setBackground(Color.WHITE);
        balance_enquiry.setForeground(Color.BLACK);
        balance_enquiry.setBounds(350,485,160,30);
        balance_enquiry.addActionListener(this);

        i4.add(balance_enquiry);

        exit = new JButton("EXIT");
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.setBounds(350,520,160,30);
        exit.addActionListener(this);
        i4.add(exit);

        setVisible(true);
        setResizable(false);
        setSize(900, 900);
        setLocation(300, 0);


    }

    public static void main(String[] args) {
        new transaction("");
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(exit)){
            System.exit(0);
        } else if (actionEvent.getSource().equals(deposit)) {
setVisible(false);
            new DepoSit(Card);

        } else if (actionEvent.getSource().equals(cash_withdraw)) {
            setVisible(false);
            new Withdraw(Card);

        } else if (actionEvent.getSource().equals(fast_cash)) {
            setVisible(false);
            new Fast_Cash(Card);

        }
        else if (actionEvent.getSource().equals(pin_change)) {
            setVisible(false);
            new pin_change(Card);

        } else if (actionEvent.getSource().equals(balance_enquiry)) {
            setVisible(false);
            new BalanceEnquiry(Card);

        } else if (actionEvent.getSource().equals(mini_statement)) {


            new MiniStatement(Card);



        }
    }
}
