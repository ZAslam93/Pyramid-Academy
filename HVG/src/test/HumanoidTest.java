import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanoidTest {

    @Test
    void move() {
        Humanoid hTest = new Humanoid();
        assertEquals("Humanoid", hTest.move("w").getClass().getName(),
                "Move method should return object for chaining");
    }
}