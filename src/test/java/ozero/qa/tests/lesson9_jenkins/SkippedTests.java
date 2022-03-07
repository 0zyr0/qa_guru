package ozero.qa.tests.lesson9_jenkins;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkippedTests {

    @Test
    @Disabled
    void test00() {
        assertTrue(false);
    }

    @Test
    @Disabled("With some reason")
    void test01() {
        assertTrue(false);
    }

    @Test
    @Disabled("Reason: not actual logic function")
    void test02() {
        assertTrue(false);
    }

}
