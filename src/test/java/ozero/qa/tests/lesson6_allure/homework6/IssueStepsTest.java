package ozero.qa.tests.lesson6_allure.homework6;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import ozero.qa.tests.lesson6_allure.WebSteps;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class IssueStepsTest {

    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int NUMBER = 68;

    @Test
    public void annotatedStepsTest() {
        IssueNameStepsTest issueSteps = new IssueNameStepsTest();
        issueSteps.openRepositoryPage();
        issueSteps.searchForRepository(76, "С Новым Годом  (2022)");
        issueSteps.attachPageSource();
    }
}
