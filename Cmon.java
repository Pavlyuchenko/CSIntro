import java.io.FileReader;
import java.io.IOException;

public class Cmon {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("Demo.java");

            int next = fr.read();
            while (next != -1) {
                System.out.print((char) next);
                next = fr.read();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}