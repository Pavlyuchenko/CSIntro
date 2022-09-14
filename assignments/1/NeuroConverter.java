import java.util.Scanner;

public class NeuroConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your amount?:");
        double amount = scanner.nextDouble();

        scanner.nextLine();
        converter(amount);

        scanner.close();
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
        neuro = (int) Math.floor(amountInt / NEURO_VALUE);
        amountInt = amountInt % NEURO_VALUE;

        secondValue = (int) Math.floor(amountInt / SECOND_VALUE);
        amountInt = amountInt % SECOND_VALUE;

        thirdValue = (int) Math.floor(amountInt / THIRD_VALUE);
        amountInt = amountInt % THIRD_VALUE;

        fourthValue = (int) Math.floor(amountInt / FOURTH_VALUE);
        amountInt = amountInt % FOURTH_VALUE;

        // Print the results
        System.out.println(neuro);
        System.out.println(secondValue);
        System.out.println(thirdValue);
        System.out.println(fourthValue);

        // -- Write your code above
    }
}
