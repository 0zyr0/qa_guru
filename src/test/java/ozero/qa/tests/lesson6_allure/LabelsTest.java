package ozero.qa.tests.lesson6_allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LabelsTest {

    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int NUMBER = 68;



    @Test
    public void lambdaLabelsTest() {
        Allure.label("owner", "zms");
        Allure.feature("Issues");
        Allure.story("Создание Issue для авторизованного пользователя");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.link("GitHub", "https://github.com");
    }

    @Test
    @Owner("zms")
    @Feature("Issues")
    @Stories({
            @Story("Создание Issue для авторизованного пользователя"),
            @Story("Создание Issue со страницы репозитория")
    })
    @DisplayName("Создание Issue для авторизованного пользователя")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url = "https://github.com")
    public void annotatedLabelsTest() {
    }

}
