import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    // Application assets -- word bank and board ASCII
    public static String secret = "cat";
    public static String[] board = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========",
    };

    public static void main(String[] args) {
        System.out.println(secret);
        Scanner userInput = new Scanner(System.in);
        boolean playAgain = true;
        while(playAgain) {
            playAgain = playGame(secret, userInput);
        }
    }

    public static boolean playGame(String word, Scanner input) {
        System.out.println("H A N G M A N");
        // Initialize answer string and arraylists for guesses
        char[] answer = (word.replaceAll("[a-z]", "_")).toCharArray();
        StringBuilder missedLetters = new StringBuilder();
        ArrayList<Character> allGuesses = new ArrayList<>();
        String ansStr = "";
        // In this version six guesses are permitted
        int guessCount = 0;
        while (guessCount < 6) {
            System.out.println(board[guessCount]);
            //System.out.println(answer);
            System.out.println("Missed letters: " + missedLetters);

            char charToCheck = handleGuess(input, allGuesses).charAt(0);
            allGuesses.add(charToCheck);
            // Traverse word and check for char occurrences
            for (int i = 0; i < word.length(); i++) {
                if (charToCheck == word.charAt(i)) {
                   ansStr += charToCheck;
                   answer[i] = charToCheck;
                }
            }
            if (word.indexOf(charToCheck) == -1) {
                guessCount++;
                missedLetters.append(charToCheck);
            }
            System.out.println(ansStr);
            System.out.println(word);
            if (word.equals(ansStr)) {
                System.out.println("Yes! The secret word was \"" + word + "\"! You have won!");
                break;
            }
        }

        if (guessCount == 6) {
            System.out.println(board[6]);
            System.out.println("G A M E O V E R");
            System.out.printf("The secret word was %s!\n", word);
        }
        System.out.println("Do you want to play again? (yes or no)");
        String response = "";
        try {
            response = input.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.equals("yes");

    }

    public static String handleGuess(Scanner input, ArrayList<Character> arr) {
        boolean keepGuessing = true;
        String guessStr = "";
        do {
            System.out.println("Guess a letter");
            try {
                guessStr = input.nextLine();
                if (guessStr.length() != 1) {
                    System.out.println("Please enter a single alphabetical character.");
                }
                else if (arr.contains(guessStr.charAt(0))) {
                    System.out.println("You have already guessed that letter. Choose again.");
                }
                else {
                    keepGuessing = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                keepGuessing = false;
            }
        } while (keepGuessing);
        return guessStr;
    }
}
