import java.util.*;

public class CoolNumbers {

    public static void main(String[] args) {

        // This is just to test your method
        /*
         * Scanner scanner = new Scanner(System.in);
         * 
         * int n = scanner.nextInt();
         * int a = scanner.nextInt();
         * int b = scanner.nextInt();
         * 
         * System.out.println(isCool(a, n));
         * System.out.println(countCools(n, a, b));
         * 
         * scanner.close();
         */
    }

    public static boolean isCool(int x, int n) {
        // Converting x to string
        String xString = String.valueOf(x);
        // Looping over all the numbers of x as string
        for (int i = 0; i < xString.length(); i++) {
            // convert the current character to int
            int testedNumber = (Character.getNumericValue(xString.charAt(i)));
            if (testedNumber == 0) {
                return false;
            }
            if (!(n % testedNumber == 0)) {
                return false;
            }
        }
        return true;
    }

    public static int countCools(int n, int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isCool(i, n)) {
                count++;
            }
        }
        return count;
    }
}