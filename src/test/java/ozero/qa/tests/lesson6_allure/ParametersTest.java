package ozero.qa.tests.lesson6_allure;

import io.qameta.allure.*;

import org.junit.jupiter.api.Test;


public class ParametersTest {

    @Test
    public void parametersTest() {
        Allure.parameter("Регион", "Москва");
        Allure.parameter("Область", "Московская");
    }

}
