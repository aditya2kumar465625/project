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
    final int[] x = new int[GAME_UNITS];

    final int[] y = new int[GAME_UNITS];
    int BodyParts = 6;
    int AppleX;
    int AppleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    int countApple = 0;
    Boolean gameover = false;

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
        timer = new Timer(75, this);
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        if (running) {
            g.setColor(Color.RED);
            g.fillOval(AppleX, AppleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < BodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(random.nextInt(255)));
                    //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }


            g.setColor(Color.red);
            g.setFont(new Font(Font.SERIF, Font.PLAIN, 10));
            g.drawString("SCORE : " + countApple, 500, 20);
        }
        if (!running) {
            gameOver(g);
        }

    }

    public void newapple() {
        AppleX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;

        AppleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }


    public void move() {
        for (int i = BodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];

        }
        switch (direction) {
            case 'U' -> y[0] -= UNIT_SIZE;
            case 'D' -> y[0] += UNIT_SIZE;
            case 'L' -> x[0] -= UNIT_SIZE;
            case 'R' -> x[0] += UNIT_SIZE;
        }
    }

    public void checkApple() {

        if (AppleX == x[0] && AppleY == y[0]) {
            BodyParts++;
            newapple();
            countApple++;
        }

    }

    public void gameOver(Graphics g) {
        gameover = true;
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics fm = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - fm.stringWidth("GAME OVER")) / 2, SCREEN_HEIGHT / 2);


        g.setColor(Color.GREEN);
        g.setFont(new Font("Ink Free", Font.BOLD, 35));
        g.drawString("SCORE : " + countApple, (SCREEN_WIDTH - fm.stringWidth("GAME OVER")) / 2 + 200, SCREEN_HEIGHT / 2 + 100);


        g.setColor(Color.white);
        g.drawString("Press enter for play again", (SCREEN_WIDTH - fm.stringWidth("GAME OVER")) / 2, SCREEN_HEIGHT / 2 + 250);


    }

    public void CheckCollisions() {
        for (int i = BodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
                break;
            }
        }
        if (x[0] < 0) {
            running = false;

        }
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }
        if (y[0] < 0) {
            running = false;
        }
        if (y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (running) {
            move();
            checkApple();
            CheckCollisions();

        }
        repaint();


    }

    public class MykeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> {
                    if (direction != 'R') {
                        direction = 'L';
                    }
                }
                case KeyEvent.VK_RIGHT -> {

                    if (direction != 'L') {
                        direction = 'R';
                    }
                }
                case KeyEvent.VK_UP -> {
                    if (direction != 'D') {
                        direction = 'U';
                    }
                }
                case KeyEvent.VK_DOWN -> {

                    if (direction != 'U') {
                        direction = 'D';
                    }
                }
            }
            if (gameover) {
if(e.getKeyCode() == KeyEvent.VK_ENTER){
                make(false);

                gameover = false;}
            }

        }
    }

    public static void main(String[] args) {
        make(true);
    }


    public static void make(Boolean check) {
        JFrame jf = new JFrame();
        jf.setVisible(false);
        jf.add(new GamePlay());
        jf.setTitle("Snake");
        jf.setResizable(false);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        if (check) {
            jf.setVisible(true);
        } else {

            make(true);
        }

    }

}


