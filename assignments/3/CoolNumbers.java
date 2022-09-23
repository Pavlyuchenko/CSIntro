import java.util.*;

public class CoolNumbers {

    public static void main(String[] args) {

        // This is just to test your method

        Scanner scanner = new Scanner(System.in);

        System.out.println(isCool(111111111, 16));
        // System.out.println(countCools(n, a, b));

        scanner.close();
    }

    public static boolean isCool(int x, int n) {
        if (x == 0) {
            return false;
        }
        int counter = 1;
        while (true) {
            if (counter > x) {
                return true;
            }
            int currentTesting = (int) ((x % (counter * 10)) / counter);

            if (currentTesting == 0) {
                return false;
            }
            if (n % currentTesting != 0) {
                return false;
            }

            counter *= 10;
        }
    }

    /*
     * public static boolean isCool(int x, int n) {
     * // Converting x to string
     * String xString = String.valueOf(x);
     * // Looping over all the numbers of x as string
     * for (int i = 0; i < xString.length(); i++) {
     * // convert the current character to int
     * int testedNumber = (Character.getNumericValue(xString.charAt(i)));
     * if (testedNumber == 0) {
     * return false;
     * }
     * if (!(n % testedNumber == 0)) {
     * return false;
     * }
     * }
     * return true;
     * }
     */

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