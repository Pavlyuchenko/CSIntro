import java.util.Scanner;

public class Game {
    private static Scanner scanner;
    final static int CURRENT_YEAR = 2022;

    public static int calculateAge(int birthYear) {
        return CURRENT_YEAR - birthYear;
    }

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        // ----- Write your code below

        // The ASCII Logo of the Jerry's Adventure
        String gameLogo = ""
                + "       __                    _          ___       __                 __\n"
                + "      / /__  ____________  _( )_____   /   | ____/ /   _____  ____  / /___  __________\n"
                + " __  / / _ \\/ ___/ ___/ / / /// ___/  / /| |/ __  / | / / _ \\/ __ \\/ __/ / / / ___/ _ \\\n"
                + "/ /_/ /  __/ /  / /  / /_/ / (__  )  / ___ / /_/ /| |/ /  __/ / / / /_/ /_/ / /  /  __/\n"
                + "\\____/\\___/_/  /_/   \\__, / /____/  /_/  |_\\__,_/ |___/\\___/_/ /_/\\__/\\__,_/_/   \\___/\n"
                + "                    /____/\n\n"
                + "by: Michal Pavlicek";

        System.out.println(gameLogo);

        // Ask user for their name
        System.out.println("What is your name?: ");
        String userName = scanner.nextLine();
        System.out.println("Hi " + userName + "!");

        // Ask user for their age
        System.out.println("When were you born?: ");
        int birthYear = scanner.nextInt();
        scanner.nextLine();
        int userAge = calculateAge(birthYear);
        System.out.println("You are " + userAge + " years old.\n");

        // Story start
        System.out.println(
                " You are standing in an abandoned university office. There are neither students nor teachers around you. There's a table in front of you with various papers, pens, a small puzzle toy, and a calculator. A large window shows an empty office building; there are no Zombies in the empty building (as far as you can tell). Behind you is a dark and mysterious door that leads to a well-lit corridor with a fireproof ceiling and floor. You feel a sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be heard in the distance. You are not thirsty, but you rather have a craving for justice.");

        // Ask user to submit their action
        System.out.println("What would you like to do?: ");
        String userChoice = scanner.nextLine();
        System.out.println(userChoice);

        scanner.close();

        // ----- Write your code above
    }
}