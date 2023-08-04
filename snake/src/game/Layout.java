package game;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {

    Layout(){
add(new GamePlay());
this.setTitle("Snake");
this.setResizable(false);
this.pack();
this.setLocationRelativeTo(null);
this.setVisible(true);
    }
}
