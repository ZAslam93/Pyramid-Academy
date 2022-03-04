import java.util.ArrayList;

public class Land {
    private final String[][] mapArr;
    private final int size;
    ArrayList<Humanoid> unitArr = new ArrayList<>();

    public Land(int n) {
        this.size = n;
        this.mapArr = new String[size][size];
    }

    public void renderLand() {
        // Check unit positions, put them on the mapArr
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (Humanoid humanoid : this.unitArr) {
                    if (humanoid.getX() < 0) humanoid.setX(0);
                    if (humanoid.getX() >= size) humanoid.setX(size - 1);
                    if (humanoid.getY() < 0) humanoid.setY(0);
                    if (humanoid.getY() >= size) humanoid.setY(size - 1);
                    if (humanoid.getX() == i && humanoid.getY() == j) {
                        placeUnit(humanoid);
                        break;
                    } else {
                        this.mapArr[i][j] = Assets.tree;
                    }
                }

            }
        }
        System.out.println(this);
    }

    public Humanoid checkCollision() {
        for (int i = 1; i < this.unitArr.size(); i++) {
            if (
                    this.unitArr.get(i).getX() == this.unitArr.get(0).getX() &&
                            this.unitArr.get(i).getY() == this.unitArr.get(0).getY()
            )
                return this.unitArr.get(i);
        }
        return null;
    }

    private void placeUnit(Humanoid humanoid) {
        String unitName = humanoid.getClass().getName();

        if (unitName.equals("Human")) {
            this.mapArr[humanoid.getX()][humanoid.getY()] = "\uD83D\uDC6E";
        } else if (unitName.equals("Goblin")) {
            this.mapArr[humanoid.getX()][humanoid.getY()] = "\uD83D\uDC79";
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String[] strings : this.mapArr) {
            result.append(String.join(" ", strings));
            result.append("\n");
        }
        return result.toString();
    }
}
