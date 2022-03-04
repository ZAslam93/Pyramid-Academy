import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Land board;
        board = introGame();
        // Game continues until all goblins are defeated
        Scanner userInput = new Scanner(System.in);
        Humanoid player = board.unitArr.get(0);
        while (board.unitArr.contains(player) && board.unitArr.size() > 1) {
            String direction = handleInput(userInput);
            player.move(direction);
            if (direction.equals("q")) {
                for (Humanoid humanoid : board.unitArr) {
                    System.out.println(humanoid);
                }
            }
            Humanoid target = board.checkCollision();
            if (target != null) {
                Combat combat = new Combat(player, target);
                if (combat.result()) {
                    board.unitArr.remove(player);
                }
                else {
                    board.unitArr.remove(target);
                }
            }
            board.renderLand();
        }
        if (board.unitArr.contains(player)) {
            System.out.println("Victory!");
            System.out.println("Game over!");
        }
        else {
            System.out.println("Game over!");
        }
    }

    public static String handleInput(Scanner input) {
        String inputStr = "";
        do {
            try {
                inputStr = input.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (inputStr.length() != 1);

        return inputStr;
    }

    public static Land introGame() {

        // 5 x 5 board, some goblins and human
        Land board = new Land(5);
        Human h1 = new Human(4, 2);
        Goblin g1 = new Goblin(
                (int) (Math.random() * 3 + 1), (int) (Math.random() * 3 + 1)
        );
        Goblin g2 = new Goblin(
               0, (int) (Math.random() * 3 + 1)
        );
        board.unitArr.add(h1);
        board.unitArr.add(g1);
        board.unitArr.add(g2);
        System.out.println("H U M A N S |VS| G O B L I N S");
        System.out.println("You control " + Assets.human);
        System.out.println("Use W A S D to move");
        System.out.println("Defeat all the " + Assets.goblin + " to win!");

        System.out.println("Choose a direction (w a s d)");
        System.out.println("View your stats by typing \"e\"");
        System.out.println("View all unit stats by typing \"q\"");
        board.renderLand();
        return board;
    }


}
