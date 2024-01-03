import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    static JFrame frame = new JFrame("Pong Game");

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setResizable(false);

        frame.setSize(650,550);

        frame.setLocationRelativeTo(null);

        PongGame game = new PongGame();

        frame.add(game);

        frame.setVisible(true);

        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.gameLogic();
                game.repaint();
            }
        });

        timer.start();
    }
}
