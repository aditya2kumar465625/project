package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class launcher extends JFrame implements ActionListener {
  JButton btn1 ,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
  int count = 0;
   Boolean b1 = true,b2=true,b3=true,b4=true,b5=true,b6=true,b7=true,b8=true,b9=true,draw = true;

    launcher() {
setTitle("Tac Toe");

        game_play g = new game_play();
        g.setBackground(Color.BLACK);
        add(g);


JLabel title = new JLabel("O|X");
title.setFont(new Font(Font.DIALOG,Font.BOLD,60));
title.setBounds(400,30,200,100);
title.setForeground(Color.WHITE);

g.add(title);

         btn1 = new JButton();
        btn1.setBackground(Color.black);
        btn1.setForeground(Color.WHITE);

        btn1.setFont(new Font(Font.DIALOG,Font.BOLD,72));

        btn1.setBorderPainted(false);
        btn1.addActionListener(this);
        btn1.setBounds(172,172,164,164);
      g.add(btn1);

         btn2 = new JButton();
        btn2.setForeground(Color.WHITE);

        btn2.setBackground(Color.black);
        btn2.addActionListener(this);
        btn2.setFont(new Font(Font.DIALOG,Font.BOLD,72));
        btn2.setBorderPainted(false);
        btn2.setBounds(388,172,164,164);
        g.add(btn2);
         btn3 = new JButton();
        btn3.setBackground(Color.black);
        btn3.setFont(new Font(Font.DIALOG,Font.BOLD,72));

        btn3.addActionListener(this);
        btn3.setBorderPainted(false);
        btn3.setBounds(636,172,164,164);
        btn3.setForeground(Color.WHITE);

        g.add(btn3);



        setSize(1000, 900);
        setLocationRelativeTo(null);


         btn4 = new JButton();
        btn4.setForeground(Color.WHITE);

        btn4.addActionListener(this);
         btn4.setBackground(Color.black);
        btn4.setFont(new Font(Font.DIALOG,Font.BOLD,72));
        btn4.setBorderPainted(false);
        btn4.setBounds(172,388,164,164);
        g.add(btn4);

         btn5 = new JButton();
        btn5.setBackground(Color.black);
        btn5.setForeground(Color.WHITE);

        btn5.addActionListener(this);
        btn5.setFont(new Font(Font.DIALOG,Font.BOLD,72));
        btn5.setBorderPainted(false);
        btn5.setBounds(388,388,184,184);
        g.add(btn5);
         btn6 = new JButton();
        btn6.setBackground(Color.black);
        btn6.addActionListener(this);
        btn6.setFont(new Font(Font.DIALOG,Font.BOLD,72));
        btn6.setForeground(Color.WHITE);

        btn6.setBorderPainted(false);
        btn6.setBounds(636,388,184,184);
        g.add(btn6);


         btn7 = new JButton();
        btn7.setBackground(Color.black);
        btn7.addActionListener(this);
        btn7.setFont(new Font(Font.DIALOG,Font.BOLD,72));
        btn7.setForeground(Color.WHITE);

        btn7.setBorderPainted(false);
        btn7.setBounds(172,636,164,164);
        g.add(btn7);

         btn8 = new JButton();
        btn8.setBackground(Color.black);
        btn8.setFont(new Font(Font.DIALOG,Font.BOLD,72));
        btn8.setBorderPainted(false);
        btn8.setForeground(Color.WHITE);

        btn8.addActionListener(this);
        btn8.setBounds(388,636,184,184);
        g.add(btn8);


        btn9 = new JButton();
        btn9.setForeground(Color.WHITE);

        btn9.setBackground(Color.black);
        btn9.setFont(new Font(Font.DIALOG,Font.BOLD,72));
        btn9.setBorderPainted(false);
        btn9.addActionListener(this);
        btn9.setBounds(636,636,184,184);
        g.add(btn9);
        setResizable(false);


    }

    public static void main(String[] args) {
        new launcher().setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
/*
*           1 2 3
*           4 5 6
*           7 8 9
*
* */
        if (count%2 ==0){
        change((JButton) actionEvent.getSource(),"O");
        winner("O");


        }
        else{
            change((JButton) actionEvent.getSource(),"X");
            winner("X");
        }


        if (count == 8&& draw){
            setVisible(false);
            new Draw();
        }
        count++;



    }

    void winner(String str){
        if (btn1.getText().equals(str) && btn2.getText().equals(str) && btn3.getText().equals(str)  ){
            setVisible(false);
            draw= false;
            new winner(str);
        }
    else   if (btn1.getText().equals(str) && btn4.getText().equals(str) && btn7.getText().equals(str)  ){
            setVisible(false);
draw= false;
            new winner(str);
    }

        else   if (btn1.getText().equals(str) && btn5.getText().equals(str) && btn9.getText().equals(str)  ){
            setVisible(false);
draw= false;
            new winner(str);
        }

        else   if (btn2.getText().equals(str) && btn5.getText().equals(str) && btn8.getText().equals(str)  ){
            setVisible(false);
draw= false;
            new winner(str);
        }

        else   if (btn3.getText().equals(str) && btn6.getText().equals(str) && btn9.getText().equals(str)  ){
            setVisible(false);
draw= false;
            new winner(str);
        }

        else   if (btn4.getText().equals(str) && btn5.getText().equals(str) && btn6.getText().equals(str)  ){
            setVisible(false);
draw= false;
            new winner(str);
        }

        else   if (btn7.getText().equals(str) && btn8.getText().equals(str) && btn9.getText().equals(str)  ){
            setVisible(false);
draw= false;
            new winner(str);
        }

        else   if (btn7.getText().equals(str) && btn5.getText().equals(str) && btn3.getText().equals(str)  ){
            setVisible(false);
draw= false;
            new winner(str);
        }





    }
    void change(JButton bt1 ,String str){

        if(bt1 == btn1 && b1){
        btn1.setText(str);
        b1 = false;
    }
    else if(bt1 == btn2 && b2){
        btn2.setText(str);
        b2 = false;
    }
    else if(bt1 == btn3 && b3){
        btn3.setText(str);
        b3 = false;
    } else if (bt1 == btn4 && b4) {
            btn4.setText(str);
            b4 = false;
    }
    else if(bt1 == btn5 && b5){
        btn5.setText(str);
        b5 = false;
    }else if(bt1 == btn6 && b6){
        btn6.setText(str);
        b6 = false;
    } else if(bt1 == btn7 && b7){
        btn7.setText(str);
        b7 = false;
    } else if(bt1 == btn8 && b8){
        btn8.setText(str);
        b8 = false;
    } else if(bt1 == btn9 && b9){
        btn9.setText(str);
        b9 = false;
    }


    }
}
