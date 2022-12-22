import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Converter {
    public Converter() {
        // JFrame
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setTitle("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        JTextArea textArea = new JTextArea(1, 10);
        textArea.setText("");
        textArea.setBorder(new LineBorder(Color.BLACK));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        JLabel t1 = new JLabel("From");
        JLabel t2 = new JLabel("To");

        JComboBox combo1 = new JComboBox();
        combo1.addItem("€");
        combo1.addItem("$");
        combo1.addItem("£");

        JComboBox combo2 = new JComboBox();
        combo2.addItem("€");
        combo2.addItem("$");
        combo2.addItem("£");

        JPanel panel3 = new JPanel();

        JButton button = new JButton("Convert");

        panel1.add(textArea);
        panel2.add(t1);
        panel2.add(combo1);
        panel2.add(t2);
        panel2.add(combo2);
        panel2.add(button);

        // Frame configuration
        frame.setLayout(new BorderLayout());
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);

        button.addActionListener(e -> {
            String text = textArea.getText();
            String from = (String) combo1.getSelectedItem();
            String to = (String) combo2.getSelectedItem();
            String result = convert(text, from, to);
            panel3.removeAll();
            panel3.add(new JLabel(result));
            frame.revalidate();
            frame.repaint();
        });

        frame.setVisible(true);
    }

    public String convert(String text, String from, String to) {
        if (text.length() == 0) {
            return "You must enter some value";
        }
        double value = Double.parseDouble(text);
        if (from.equals(to)) {
            return "You must select different currencies";
        }
        if (from.equals("€") && to.equals("$")) {
            return String.format("%.2f", value * 1.18);
        } else if (from.equals("€") && to.equals("£")) {
            return String.format("%.2f", value * 0.89);
        } else if (from.equals("$") && to.equals("€")) {
            return String.format("%.2f", value * 0.85);
        } else if (from.equals("$") && to.equals("£")) {
            return String.format("%.2f", value * 0.7575);
        } else if (from.equals("£") && to.equals("€")) {
            return String.format("%.2f", value * 1.12);
        } else if (from.equals("£") && to.equals("$")) {
            return String.format("%.2f", value * 1.32);
        } else {
            return text;
        }
    }

    public static void main(String[] args) {
        Converter converter = new Converter();
    }
}