import java.util.Scanner;

public class NeuroConverterWorse {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your amount?:");
        double amount = scanner.nextDouble();

        scanner.nextLine();
        converter(amount);
    }

    public static void converter(double amount) {
        // -- Write your code below

        // NOTE:
        // Converting everything to integers,
        // since doubles are broken in Java.
        int amountInt = (int) (amount * 100);

        // Define the values of coins
        final int NEURO_VALUE = 100;
        final int SECOND_VALUE = 49;
        final int THIRD_VALUE = 9;
        final int FOURTH_VALUE = 1;

        // Initialize used variables
        int neuro, secondValue, thirdValue, fourthValue;
        neuro = secondValue = thirdValue = fourthValue = 0;

        // The algorithm itself

        while (amountInt >= NEURO_VALUE && amountInt > 0) {
            neuro++;
            amountInt -= NEURO_VALUE;
        }
        while (amountInt >= SECOND_VALUE && amountInt > 0) {
            secondValue++;
            amountInt -= SECOND_VALUE;
        }
        while (amountInt >= THIRD_VALUE && amountInt > 0) {
            thirdValue++;
            amountInt -= THIRD_VALUE;
        }
        while (amountInt >= FOURTH_VALUE && amountInt > 0) {
            fourthValue++;
            amountInt -= FOURTH_VALUE;
        }

        // Print the results
        System.out.println(neuro);
        System.out.println(secondValue);
        System.out.println(thirdValue);
        System.out.println(fourthValue);

        // -- Write your code above
    }
}
