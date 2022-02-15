import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.Scanner;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void intro() {
        assertEquals(0, Main.intro(), "Intro did not exit with status 0");
    }

    @Test
    void choose() {
        Scanner input = new Scanner(System.in);
        assertNotNull(main.choose(input), "Method failed to return value");
    }

    @Test
    void outcomes() {
        String str = "test";
        assertEquals(0, main.outcomes(str), "Method did not exit with 0");
    }

    @AfterEach
    void tearDown() {
    }
}