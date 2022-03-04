import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testToString() {

        var gTest = new Human(2, 0);
        assertNotNull(gTest.toString(), "Expected toString to return string output");

    }
}