import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.*;

class HouseComponent extends JComponent {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        House h = new House(0, 0);
        House h2 = new House(400, 400);
        h.draw(g2);
        h2.draw(g2);
    }

}

public class House {
    private double xLeft;
    private double yTop;

    public House(double x, double y) {
        this.xLeft = x;
        this.yTop = y;
    }

    public void draw(Graphics2D g2) {

        // Recover Graphics2D
        g2.setColor(Color.BLUE);

        // Construct a rectangle and draw it
        Rectangle2D.Double facade = new Rectangle2D.Double(xLeft, yTop + 45, 100, 100);
        g2.draw(facade);

        // Move rectangle 15 units to the right and 25 units down
        Rectangle2D.Double door = new Rectangle2D.Double(xLeft + 15, yTop + 95, 25, 50);
        g2.draw(door);

        Rectangle2D.Double window = new Rectangle2D.Double(xLeft + 60, yTop + 95, 25, 25);
        g2.draw(window);

        Line2D roof1 = new Line2D.Double();
        roof1.setLine(xLeft, yTop + 45, xLeft + 50, yTop + 0);
        g2.draw(roof1);

        Line2D roof2 = new Line2D.Double();
        roof2.setLine(xLeft + 50, yTop, xLeft + 100, yTop + 45);
        g2.draw(roof2);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setTitle("House");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        HouseComponent h = new HouseComponent();
        frame.add(h);
        frame.setVisible(true);
    }
}
