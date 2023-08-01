package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class winner extends JFrame implements ActionListener {
JButton retry,Exit;
    winner(String str) {
        JLabel jLabel1 = new JLabel("Congratulation ");
        jLabel1.setBounds(40, 100, 350, 100);
        jLabel1.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        add(jLabel1);



        JLabel jLabel = new JLabel("'"+str + "' is Winner ");
        jLabel.setBounds(50, 150, 350, 100);
        jLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        add(jLabel);

        retry = new JButton("Play Again");
        retry.setBounds(60,300,130,50);
        retry.setBackground(Color.BLACK);
        retry.addActionListener(this);
        retry.setForeground(Color.WHITE);
        add(retry);


        Exit = new JButton("Exit");
        Exit.setBounds(250,300,100,50);
        Exit.setBackground(Color.BLACK);
        Exit.addActionListener(this);
        Exit.setForeground(Color.WHITE);
        add(Exit);
        setResizable(false);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new winner("");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
if (actionEvent.getSource().equals(retry)){
   setVisible(false);
    new launcher().setVisible(true);
}
else if (actionEvent.getSource().equals(Exit))
{

    System.exit(0);
}   }

}
