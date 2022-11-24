import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class ButtonViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JButton button = new JButton("Click me!");
        JButton button2 = new JButton("Click me 2!");

        panel.add(button);
        panel.add(button2);
        ActionListener listener = new ClickListener();
        ActionListener listener2 = new ClickListener();
        button.addActionListener(listener);
        button2.addActionListener(listener2);
        frame.setContentPane(panel);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
}