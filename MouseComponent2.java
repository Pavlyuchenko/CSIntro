import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class MouseComponent2 extends JComponent {
    private int x = 20, y = 20;

    public MouseComponent2() {
        class MousePressListener implements MouseListener {
            public void mousePressed(MouseEvent event) {
                x = event.getX();
                y = event.getY();
                repaint();// repaints the applet
            }

            public void mouseReleased(MouseEvent event) {
            }

            public void mouseClicked(MouseEvent event) {
            }

            public void mouseEntered(MouseEvent event) {
            }

            public void mouseExited(MouseEvent event) {
            }
        }
        MouseListener listener = new MousePressListener();
        addMouseListener(listener);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("Leaaaa", x, y);
        g2.drawRect(10, 10, 100, 100);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(5, 10, 100, 150);
        g2.draw(ellipse);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.add(new MouseComponent2());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
