import java.util.Scanner;

public class RPSLO {

    // Rock = 0, Paper = 1, Scissors = 2, Lizzard = 3, Spock = 4
    // Scissors cut Paper
    // Paper covers Rock
    // Rock crushes Scissors
    // Spock vaporizes Rock
    // Paper disproves Spock
    // Spock smashes Scissors
    // Rock crushes Lizard
    // Lizard eats Paper
    // Scissors decapitate Lizard
    // Lizard poisons Spock

    public static void main(String[] args) {
        System.out.println("Enter your play: R, P, S, L, O");
        Scanner scanner = new Scanner(System.in);

        // Write your code below

        String userPlay = scanner.nextLine().toLowerCase();

        int randomNumber = (int) (Math.random() * 10 / 2);
        String computerPlay = "";
        switch (randomNumber) {
            case 0:
                System.out.println("Computer play is R");
                computerPlay = "r";
                break;
            case 1:
                System.out.println("Computer play is P");
                computerPlay = "p";
                break;
            case 2:
                System.out.println("Computer play is S");
                computerPlay = "s";
                break;
            case 3:
                System.out.println("Computer play is L");
                computerPlay = "l";
                break;
            case 4:
                System.out.println("Computer play is O");
                computerPlay = "o";
                break;
            default:
                System.out.println("Something unexpected happened.");
                break;
        }

        if (userPlay.equals(computerPlay)) {
            tie();
        } else {
            switch (userPlay) {
                case "r":
                    switch (computerPlay) {
                        case "p":
                        case "o":
                            computerWin();
                            break;
                        case "s":
                        case "l":
                            userWins();
                            break;
                        default:
                            break;
                    }
                    break;
                case "p":
                    switch (computerPlay) {
                        case "r":
                        case "o":
                            userWins();
                            break;
                        case "s":
                        case "l":
                            computerWin();
                            break;
                        default:
                            break;
                    }
                    break;
                case "s":
                    switch (computerPlay) {
                        case "r":
                        case "o":
                            computerWin();
                            break;
                        case "p":
                        case "l":
                            userWins();
                            break;
                        default:
                            break;
                    }
                    break;
                case "l":
                    switch (computerPlay) {
                        case "r":
                        case "s":
                            computerWin();
                            break;
                        case "p":
                        case "o":
                            userWins();
                            break;
                        default:
                            break;
                    }
                    break;
                case "o":
                    switch (computerPlay) {
                        case "r":
                        case "s":
                            userWins();
                            break;
                        case "p":
                        case "l":
                            computerWin();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid input (valid inputs: R, P, S, L, O)");
                    break;
            }
        }

        // Write your code above

        scanner.close();
    }

    public static void tie() {
        System.out.println("It is a tie!");
    }

    public static void userWins() {
        System.out.println("You win!");
    }

    public static void computerWin() {
        System.out.println("Computer wins!");
    }
}