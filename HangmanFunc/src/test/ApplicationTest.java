import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void testRunGame() throws IOException {
        assertEquals("java.lang.Integer", Application.runGame("test").getClass().getName(),
                "Expected integer (score) return");
    }

    @Test
    void testHandleGuess() {
        ArrayList<Character> testArr = new ArrayList<>();
        assertEquals("java.lang.Character", Application.handleGuess(testArr).getClass().getName(),
                "Expected char to be returned, after scanner input");

    }

    @Test
    void testCheckScore() throws IOException {
        assertEquals("java.lang.String", Application.checkScore("test", 5).getClass().getName(),
                "Expected string output from checkScore");
    }
}