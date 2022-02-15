import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        String userName = opening(userIn);
        mainGame(userIn, userName);
    }

    public static String opening(Scanner input) {
        System.out.println("Hello! What is your name?");
        String str = null;
        try {
            str = input.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Well, " + str + ", I am thinking of a number between 1 and 20.");
        return str;
    }

    public static void mainGame(Scanner input, String str) {
        boolean playAgain = true;
        while (playAgain) {
            guess(input, str);
            System.out.println("Would you like to play again?");
            System.out.println("y/n");
            String yorN = null;
            try {
                yorN = input.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Please provide correct input");
            }
            assert yorN != null;
            if (!yorN.equals("y")) playAgain = false;
        }
    }

    public static void guess(Scanner input, String str) {
        int randNum = (int) (Math.random() * 20);
        for (int i = 1; i <= 6; i++) {
            System.out.println("Take a guess.");
            int guess;
            try {
                guess = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Please provide correct input");
                break;
            }
            int guessesLeft = 6 - i;
            if (guess == randNum) {
                System.out.println("Good job, " + str + "! You guessed my number in " + i + " guesses!");
                break;
            } else if (guess > randNum) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Your guess is too low.");
            }
            System.out.println("Guesses remaining: " + guessesLeft);
        }
    }
}