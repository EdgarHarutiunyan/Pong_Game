import java.awt.*;

public class Paddles {
    private int height, x ,y, speed;
    private Color color;

    private static final int PADDLE_WIDTH = 15;

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * @param height the height of the paddles
     * @param x coordinate x of the paddle
     * @param y coordinate y of the paddle
     * @param speed the speed that the paddle moves
     * @param color color of the paddle
     */
    public Paddles (int height, int x, int y, int speed, Color color) {
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,PADDLE_WIDTH,height);
    }

    public void move(int yCoordinate) {
        //Center of the paddle
        int yCenter = y + (height/2);

        if (Math.abs(yCenter - yCoordinate) > speed) {
            if (yCenter > yCoordinate) {
                this.y -= speed;
            }
            if (yCenter < yCoordinate) {
                this.y += speed;
            }
        }

    }
}
