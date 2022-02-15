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
    void opening() {
        Scanner input = new Scanner(System.in);
        assertNotNull(main.opening(input), "Method failed to return string");
    }

    @Test
    void mainGame() {
        Scanner in2 = new Scanner(System.in);
        String str2 = "test";
        assertEquals(0, main.mainGame(in2, str2), "mainGame did not exit with 0");

    }

    @Test
    void guess() {
        Scanner in3 = new Scanner(System.in);
        String str3 = "test";
        assertEquals(0, main.guess(in3, str3), "Guess did not exit successfully");
    }

    @AfterEach
    void tearDown() {
    }
}