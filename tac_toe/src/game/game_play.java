package game;

import javax.swing.*;
import java.awt.*;

public class game_play extends JPanel {
    JRadioButton light,dark;
    game_play(){
//        light =new JRadioButton("LIGHT");
//        light.setBackground(Color.BLACK);
//        light.setForeground(Color.WHITE);
//        light.setBounds(550,40,70,50);
//        add(light);



        setLayout(null);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.setColor(Color.WHITE);
//       g.drawRect(72,72,656,656);

       g.setColor(Color.WHITE);
       g.drawLine(172,346,828,346);

       g.setColor(Color.WHITE);
        g.drawLine(172,592,828,592);


        g.setColor(Color.WHITE);
        g.drawLine(346,172,346,828);

        g.setColor(Color.WHITE);
        g.drawLine(592,172,592,828);


    }
}
