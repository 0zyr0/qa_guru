package ozero.qa.tests.lesson2;

import org.junit.jupiter.api.*;

@DisplayName("My first test")
public class FirstSimpleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll Method!");
    }

    /*@BeforeEach аннотация используется для всех тестов, если одно и тоже действие нужно повторять
    в каждом тесте
     */

    @BeforeEach
    void beforeEach() {
        System.out.println("    @BeforeEach Method!");
    }


    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll Method!");
    }


    @AfterEach
    void afterEach() {
        System.out.println("    @AfterEach Method!");
    }


    @DisplayName("Test 1")
    @Test
    void firstTest() {
        System.out.println(" Test Assert Equals");
        Assertions.assertEquals(1, 1);
    }

    @DisplayName("Test 2")
    @Test
    void secondTest() {
        System.out.println(" Test Assert True");
        Assertions.assertTrue(1 < 2);
    }
}
