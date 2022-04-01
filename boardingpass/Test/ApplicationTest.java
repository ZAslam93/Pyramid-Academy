import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    private Application test;

    @BeforeEach
    void setUp() {
        System.out.println("We're building it up...");
        test = new Application();
    }

    @Test
    void testCheckPhoneFormat() {
        assertFalse(Application.checkPhoneFormat("1234567890"));
        assertTrue(Application.checkPhoneFormat("123-456-7890"));
        System.out.println("Phone formatting good.");
    }

    @Test
    void checkEmailFormat() {
        assertFalse(Application.checkEmailFormat("joeblowschmough@jbscom"));
        assertTrue(Application.checkEmailFormat("joeblowschmough@jbs.com"));
        System.out.println("Email formatting good.");
    }

    @Test
    void checkTimeField() {
        assertFalse(Application.checkTimeField("1234"));
        assertTrue(Application.checkTimeField("12:34"));
        System.out.println("Time formatting good.");
    }

    @Test
    void checkDateFormat() {
        assertFalse(Application.checkDateFormat("12312020"));
        assertFalse(Application.checkDateFormat("12/40/1234"));
        assertTrue(Application.checkDateFormat("12/31/2020"));
        System.out.println("Date formatting good.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("and tearing it down.");
        test = null;
        assertNull(test);
    }
}