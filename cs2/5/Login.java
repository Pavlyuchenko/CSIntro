import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.text.html.HTMLDocument.BlockElement;

class LoginManager {
    private String[] allowed_usernames = { "jerry", "tom", "enrique" };
    private String[] allowed_passwords = { "123Welcome", "Qwerti", "Azertu2" };
    private int attempts = 3;

    public boolean login(String userName, String password) {
        attempts--;

        for (int i = 0; i < allowed_usernames.length; i++) {
            if (userName.equals(allowed_usernames[i]) && password.equals(allowed_passwords[i])) {
                return true;
            }
        }
        return false;
    }

    public int getAttempts() {
        return attempts;
    }
}

public class Login {
    LoginManager lm = new LoginManager();

    public Login() {
        // JFrame
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setTitle("Login Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        JTextArea username = new JTextArea(1, 10);
        JPasswordField password = new JPasswordField(10);
        username.setText("");
        password.setText("");
        username.setBorder(new LineBorder(Color.BLACK));
        password.setBorder(new LineBorder(Color.BLACK));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        JLabel t1 = new JLabel("Attempts left: " + lm.getAttempts());

        JButton button = new JButton("Login");

        panel1.add(username);
        panel1.add(password);
        panel2.add(t1);
        panel2.add(button);

        // Frame configuration
        frame.setLayout(new BorderLayout());
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);

        button.addActionListener(e -> {
            System.out.println("Checking validity of username and password...");

            String username_text = username.getText().toLowerCase();
            String password_text = password.getText();

            if (lm.login(username_text, password_text)) {
                frame.dispose();

                JOptionPane.showMessageDialog(null, "Entered credentials are right, welcome!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (lm.getAttempts() == 0) {
                frame.dispose();

                JOptionPane.showMessageDialog(null, "Login failed! You have no more attempts left.", "Error",
                        JOptionPane.ERROR_MESSAGE);

            }

            t1.setText("Attempts left: " + lm.getAttempts());
            frame.repaint();
        });

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Login textManipulation = new Login();
    }
}