import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner userIn = new Scanner(System.in);
        intro();
        String userChoice = choose(userIn);
        outcomes(userChoice);

    }

    public static void intro() {
        System.out.println("You are in a land of dragons, in front of you,");
        System.out.println("you see two caves. In one cave the dragon is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? 1 or 2");
    }

    public static String choose(Scanner input) {
        String userChoice = null;
        try {
            userChoice = input.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userChoice;
    }

    public static void outcomes(String str) {
        if (str.equals("1")) {
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Gobbles you down in one bite!");
        } else if (str.equals("2")) {
            System.out.println("You approach the cave...");
            System.out.println("It is bright and welcoming...");
            System.out.println("A large dragon emerges from his eyrie! He flies down and...");
            System.out.println("Lifts a boulder, revealing a hoard of priceless jewels!");
        }
    }
}
