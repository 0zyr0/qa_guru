package ozero.qa.tests.lesson6_allure.homework6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class CheckIssueName {

    /* Написать тест на проверку названия Issue в репозитории через Web-интерфейс.

Этот тест представить в трех вариантах:

1. Чистый Selenide (с Listener)

2. Лямбда шаги через step (name, () -> {})

3. Шаги с аннотацией @Step
*/

    IssueNumber issueNumber = new IssueNumber();

    @Test
    @Owner("zaitsevms")
    @Feature("Issues Name")
    @Stories({
            @Story("Проверка названия Issue репозитория"),
            @Story("Проверка имени Issue репозитория")
    })
    @DisplayName("Проверка имени Issue")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Repository", url = "https://github.com/eroshenkoam/allure-example/issues")
    public void IssueNameSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/eroshenkoam/allure-example/issues");

        $("#issue_76_link").shouldHave(text("С Новым Годом  (2022)"));
    }

    @Test
    @Owner("zaitsevms")
    @Feature("Issues Name")
    @Stories({
            @Story("Проверка названия Issue репозитория"),
            @Story("Проверка имени Issue репозитория")
    })
    @DisplayName("Проверка имени Issue")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Repository", url = "https://github.com/eroshenkoam/allure-example/issues")
    public void IssueNameLambdaTest() {

        step("Открываем страницу репозитория", () -> {
            open("https://github.com/eroshenkoam/allure-example/issues");
        });
        step("Проверяем название Issue ", () -> {
            issueNumber.checkIssueNumber(76, "С Новым Годом  (2022)");
        });

    }

}


