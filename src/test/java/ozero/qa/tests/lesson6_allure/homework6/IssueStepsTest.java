package ozero.qa.tests.lesson6_allure.homework6;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssueStepsTest {

    @Test
    public void annotatedStepsTest() {
        IssueNameSteps issueSteps = new IssueNameSteps();
        issueSteps.openRepositoryPage();
        issueSteps.searchForRepository(76, "С Новым Годом  (2022)");
        issueSteps.attachPageSource();
    }
}
