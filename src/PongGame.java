import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener, KeyListener {

    private Ball ball;
    private Paddles paddleUser;
    private Paddles paddlePC;
    private int userMouseYCoordinate;

    public PongGame() {
        this.ball = new Ball(300,200,2,2,10,10,Color.white);
        this.paddlePC = new Paddles(100,0,215,2,Color.lightGray);
        this.paddleUser = new Paddles(100,635,215,2,Color.lightGray);
        this.userMouseYCoordinate = 0;
        addMouseMotionListener(this);

        /* TO MOVE THE PADDLE BY THE ARROW KEYS
        setFocusable(true);
        addKeyListener(this);
         */
    }
    static final int WIDTH = 640;
    static final int HEIGHT = 520;

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);

        g.fillRect(0,0,Main.frame.getWidth(),Main.frame.getHeight());

        ball.paint(g);
        paddleUser.paint(g);
        paddlePC.paint(g);
        paddlePC.move(600);
    }

    public void gameLogic() {
        ball.moveBall();
        ball.bounceOffEdges(0,Main.frame.getWidth());
        paddleUser.move(userMouseYCoordinate);

        paddlePC.move(ball.getY());
        System.out.println(ball.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseYCoordinate = e.getY();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyPressed = e.getKeyCode();
        System.out.println(keyPressed);
        if (keyPressed == KeyEvent.VK_DOWN) {
            userMouseYCoordinate += 20;
        }
        if (keyPressed == KeyEvent.VK_UP) {
            userMouseYCoordinate -= 20;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        userMouseYCoordinate = paddleUser.getY() + (paddleUser.getHeight()/2);
    }
}
