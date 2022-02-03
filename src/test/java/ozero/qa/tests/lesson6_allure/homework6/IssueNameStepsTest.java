package ozero.qa.tests.lesson6_allure.homework6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class IssueNameStepsTest {

    IssueNumber issueNumber = new IssueNumber();

    @Step("Открываем страницу репозитория")
    public void openRepositoryPage() {
        open("https://github.com/eroshenkoam/allure-example/issues");
    }

    @Step("Проверяем имя Issue {issueNum}")
    public void searchForRepository(int issueNum, String issueName) {
        issueNumber.checkIssueNumber(issueNum, issueName);
    }

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }

}
