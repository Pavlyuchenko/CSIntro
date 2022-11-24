import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.geom.*;

class OlympicRingComponent extends JComponent {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        OlympicRing h = new OlympicRing(0, 0);
        OlympicRing h2 = new OlympicRing(400, 400);
        h.draw(g2);
        h2.draw(g2);
    }

    class OlympicRing {
        private double xLeft;
        private double yTop;

        public OlympicRing(double x, double y) {
            xLeft = x;
            yTop = y;
        }

        public void draw(Graphics2D g2) {
            int stroke = 8;

            g2.setStroke(new BasicStroke(stroke));

            g2.setColor(new Color(0, 129, 200));

            Ellipse2D circle1 = new Ellipse2D.Double();
            circle1.setFrame(xLeft, yTop + 0, 100, 100);
            g2.draw(circle1);

            g2.setColor(new Color(252, 177, 49));

            Ellipse2D circle2 = new Ellipse2D.Double();
            circle2.setFrame(xLeft + 50 + stroke, yTop + 50 + stroke, 100, 100);
            g2.draw(circle2);

            g2.setColor(new Color(0, 0, 0));

            Ellipse2D circle3 = new Ellipse2D.Double();
            circle3.setFrame(xLeft + 100 + stroke, yTop + stroke, 100, 100);
            g2.draw(circle3);

            g2.setColor(new Color(0, 166, 81));

            Ellipse2D circle4 = new Ellipse2D.Double();
            circle4.setFrame(xLeft + 150 + stroke * 2, yTop + 50 + stroke, 100, 100);
            g2.draw(circle4);

            g2.setColor(new Color(238, 51, 78));

            Ellipse2D circle5 = new Ellipse2D.Double();
            circle5.setFrame(xLeft + 200 + stroke * 2, yTop + stroke, 100, 100);
            g2.draw(circle5);
        }
    }
}

public class OlympicRingViewer {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setTitle("Olympics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        OlympicRingComponent component = new OlympicRingComponent();
        frame.add(component);
        frame.setVisible(true);
    }
}
