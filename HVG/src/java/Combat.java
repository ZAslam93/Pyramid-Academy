public class Combat {
    private final Humanoid player;
    private final Humanoid enemy;

    public Combat(Humanoid player, Humanoid enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean result() {
        int playerDamage = player.getStrength();
        int enemyDamage = enemy.getStrength();
        while (player.getHealth() > 0) {

            // Run combat, and return false if enemy dies
            enemy.setHealth(enemy.getHealth() - (playerDamage + (int) (Math.random() * 4) + 1));
            System.out.println("Attacked enemy for " + (playerDamage + (int) (Math.random() * 4) + 1) + " damage!");
            int eHealth = Math.max(enemy.getHealth(), 0);
            System.out.println("Enemy health left: " + eHealth);
            if (enemy.getHealth() <= 0) {
                System.out.println("Enemy vanquished!");
                return false;
            }
            player.setHealth(player.getHealth() - (enemyDamage + (int) (Math.random() * 7) + 1));
            System.out.println("Sustained " + (enemyDamage + (int) (Math.random() * 7) + 1) + " damage!");
            int pHealth = Math.max(player.getHealth(), 0);
            System.out.println("Health left: " + pHealth);
        }
        System.out.println("Defeated...");
        return true;
    }
}
