package ozero.qa.tests.lesson6_allure.homework6;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("zaitsevms")
@Feature("Issues Name")
@Stories({
        @Story("Проверка названия Issue репозитория"),
        @Story("Проверка имени Issue репозитория")
})
@DisplayName("Проверка имени Issue")
@Severity(SeverityLevel.CRITICAL)
@Link(value = "Repository", url = "https://github.com/eroshenkoam/allure-example/issues")
public class CheckIssueName {


    @Test
    public void IssueNameSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/eroshenkoam/allure-example/issues");

        $("#issue_76_link").shouldHave(text("С Новым Годом  (2022)"));
    }

    @Test
    public void IssueNameLambdaTest() {

        step("Открываем страницу репозитория", () -> {
            open("https://github.com/eroshenkoam/allure-example/issues");
        });
        step("Проверяем название Issue ", () -> {
            IssueNameSteps.checkIssueNumber(76, "С Новым Годом  (2022)");
        });

    }



}


