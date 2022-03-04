public class Goblin extends Humanoid {
    public Goblin(int x, int y) {

        // Flipping x and y here because coordinates get confusing
        this.setX(x);
        this.setY(y);

        // Goblins have 20 HP and 1 to 5 strength
        this.setHealth(20);
        this.setStrength((int) (Math.random() * 4 + 1));
    }

    @Override
    public String toString() {
        return Assets.goblin + "\nHealth | " + this.getHealth() + "\nStrength | " + this.getStrength();
    }

}
