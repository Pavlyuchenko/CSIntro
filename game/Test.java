import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Test extends JComponent {
    private int x = 20;
    private int y = 20;

    public Test() {
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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Test());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
