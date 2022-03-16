import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    // Initialize paths and constants
    static Path wordPath = Paths.get("src/assets/words.txt");
    static Path scoresPath = Paths.get("src/assets/scores.txt");
    static Path boardPath = Paths.get("src/assets/board.txt");
    static String username = "";

    public static void main(String[] args) throws IOException {

        // Introduce game, get username
        System.out.println("H A N G M A N");
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter your username: ");
            username = input.nextLine();
        }
        System.out.printf("Welcome, %s! Reveal the word within 6 guesses!%n", username);
        String word = Files.readAllLines(wordPath).get((int) ((Math.random() * 9) + 1));
        int finalScore = runGame(word);
        System.out.println(checkScore(username, finalScore));
    }

    public static Integer runGame(String word) throws IOException {
        BufferedReader br = Files.newBufferedReader(boardPath);
        ArrayList<String> wordArr = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        Collections.addAll(wordArr, word.split(""));
        Collections.addAll(ans, word.replaceAll("[a-z]", "_").split(""));
        StringBuilder missedLetters = new StringBuilder();
        ArrayList<Character> allGuesses = new ArrayList<>();
        int scoreCount = 6;
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            System.out.printf("Missed letters | %s", missedLetters);
            char charToCheck = handleGuess(allGuesses);

            // If character has been guessed, continue, don't read next line
            if (allGuesses.contains(charToCheck)) continue;

            // Check for char's occurrence, update answer if exists
            List<String> checkAns = ans.stream().map(e -> {
                if (wordArr.contains(String.valueOf(charToCheck))) {
                    return String.valueOf(charToCheck);
                }
                return "_";
            }).collect(Collectors.toList());

            // Exit loop if word has been discovered
            if (String.join("", checkAns).equals(word)) {
                System.out.println("Yes! The secret word was \"" + word + "\"! You have won!");
                break;
            }

            scoreCount--;
            line = br.readLine();
        }
        return scoreCount;
    }

    public static Character handleGuess(ArrayList<Character> arr) {
        char guessChar;
        System.out.println("Guess a letter [a-z]");
        try (Scanner input = new Scanner(System.in)) {
            guessChar = input.nextLine().toLowerCase(Locale.ROOT).charAt(0);
        }
        if (arr.contains(guessChar)) {
            System.out.println("You have already guessed that character. Choose again");
        }
        return guessChar;
    }

    public static String checkScore(String username, int score) throws IOException {
        String text = username + "|" + score;
        Files.writeString(scoresPath, text);
        List<Integer> scoreList = Files.readAllLines(scoresPath).stream().map(e ->
                Integer.parseInt(e.substring(
                        e.length() - 1
                ))).collect(Collectors.toList());
        int maxScore =  scoreList.stream().max(Comparator.naturalOrder()).orElse(0);
        if (score > maxScore) System.out.println("High Score!");
        return "Your score is: " + score;
    }

}
