import java.awt.*;

public class Ball {
    private int  x, y, incX, incY, size, speed;
    private Color color;

    public Ball(int x, int y, int incX, int incY, int size, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.incX = incX;
        this.incY = incY;
        this.size = size;
        this.speed = speed;
        this.color = color;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y,size,size);
    }

    public void moveBall() {
        x += incX;
        y += incY;
    }

    public void reverseIncX () {
        incX *= -1;
    }
    public void reverseIncY () {
        incY *= -1;
    }

    public int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void bounceOffEdges(int top, int bottom) {
        if (y > 510 || y < top) {
            reverseIncY();
            System.out.println("1x: " + x + " " + "y: " + y);
            //System.out.println(Main.frame.getWidth());
        }

        if (x < top || x > bottom - size) {
            reverseIncX();
            System.out.println("2x: " + x + " " + "y: " + y);
        }


    }
}
