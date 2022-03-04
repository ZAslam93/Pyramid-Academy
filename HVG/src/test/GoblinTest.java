import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {
    @Test
    public void tsTest() {
        var gTest = new Goblin(2,0);
        assertNotNull(gTest.toString(), "Expected toString to return string output");
    }
}