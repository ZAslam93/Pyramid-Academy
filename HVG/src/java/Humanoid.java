public class Humanoid {
    private int x;
    private int y;
    private int strength;
    private int health;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Humanoid move(String direction) {
        switch (direction) {
            case "w" -> this.setX(this.getX() - 1);
            case "s" -> this.setX(this.getX() + 1);
            case "a" -> this.setY(this.getY() - 1);
            case "d" -> this.setY(this.getY() + 1);

            // Special case, get the player's stats
            case "e" -> System.out.println(this);
        }
        return this;
    }
}
