import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatTest {

    @Test
    void resultTest() {
        Human playerTest = new Human(1,1);
        Goblin enemyTest = new Goblin(2,2);
        Combat cTest = new Combat(playerTest, enemyTest);
        assertFalse(cTest.result(), "Expected false, got true");
    }
}