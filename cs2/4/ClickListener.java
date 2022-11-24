import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An action listener that prints a message.
 */
public class ClickListener implements ActionListener {
    private int count = 0;

    public void actionPerformed(ActionEvent event) {
        count++;
        System.out.println("I was clicked " + Integer.toString(count) + " times.");
    }
}