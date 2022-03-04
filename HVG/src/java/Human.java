public class Human extends Humanoid {
    public Human(int x, int y) {

        // Flipping x and y here because coordinates get confusing
        this.setX(x);
        this.setY(y);

        // Human character has 50 HP and 5 strength
        this.setHealth(50);
        this.setStrength(5);
    }

    @Override
    public String toString() {
        return Assets.human + "\nHealth | " + this.getHealth() + "\nStrength | " + this.getStrength();
    }
}
