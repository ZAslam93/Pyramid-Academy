import org.junit.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    public void testIntro() {
        assertEquals("Land", Application.introGame().getClass().getName(),
                "Expected method to return land");
    }

    @Test
    public void testInput() {
        Scanner testIn = new Scanner(System.in);
        assertEquals(1, Application.handleInput(testIn).length(),
                "Expected single character returned");
    }
}