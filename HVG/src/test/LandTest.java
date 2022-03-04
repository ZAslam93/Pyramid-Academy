import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {

    @Test
    void checkCollision() {
        Land lTest = new Land(4);
        lTest.unitArr.add(new Human(0, 4));
        lTest.unitArr.add(new Goblin(2,2));
        assertEquals("Goblin", lTest.checkCollision().getClass().getName()
        ,"Expected goblin object returned");
    }

    @Test
    void testToString() {
        Land sTest = new Land(3);
        assertNotNull(sTest.toString(), "Expected string to be returned");
    }
}