package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePlay extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;

    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_WIDTH) / UNIT_SIZE;
    static int delay = 75;
    final int x[] = new int[GAME_UNITS];

    final int y[] = new int[GAME_UNITS];
    int BodyParts = 6;
    int AppleX;
    int AppleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    GamePlay() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setFocusable(true);
        this.setBackground(Color.black);
        this.addKeyListener(new MykeyAdapter());
        newapple();
        startGame();


    }

    public void startGame() {

        running = true;
        timer = new Timer(150, this);
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        for (int i = 0; i <= SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g.setColor(Color.white);
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.setColor(Color.white);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);

        }

        g.setColor(Color.RED);
        g.fillOval(AppleX, AppleY, UNIT_SIZE, UNIT_SIZE);

        for (int i = 0 ; i<BodyParts;i++){
            if(i == 0) {
                g.setColor(Color.green);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
            else {
                g.setColor(new Color(45,180,0));
                //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    public void newapple(){
          AppleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;

        AppleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }


    public void move() {
        for(int i = BodyParts;i>0;i--){
            x[i] = x[i-1];
            y[i] = y[i-1];

        }
        switch (direction) {
            case 'U' -> y[0] -= UNIT_SIZE;
            case 'D' -> y[0] += UNIT_SIZE;
            case 'L' -> x[0] -= UNIT_SIZE;
            case 'R' -> x[0] += UNIT_SIZE;
        }
    }

    public void checkApple() {

    }

    public void gameOver(Graphics g) {

    }
    public void CheckCollisions(){
        if (x[0]<0){
            running = false;

        }
        if (x[0]>SCREEN_WIDTH){
            running = false;
        }
        if (y[0] < 0){
            running = false;
        }
        if (y[0] > SCREEN_HEIGHT){
            running = false;
        }
        if (!running){
            timer.stop();
        }

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
            if(running){
                move();
                checkApple();
                CheckCollisions();

            }repaint();

    }

public class MykeyAdapter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {

    }
}

}

