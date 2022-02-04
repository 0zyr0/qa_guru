package ozero.qa.tests.lesson6_allure.homework6;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class IssueNameSteps {


    @Step("Открываем страницу репозитория")
    public void openRepositoryPage() {
        open("https://github.com/eroshenkoam/allure-example/issues");
    }

    @Step("Проверяем имя Issue {issueNum}")
    public void searchForRepository(int issueNum, String issueName) {
        checkIssueNumber(issueNum, issueName);
    }

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }

    public static void checkIssueNumber(int issueNumber, String issueName) {
        $("#issue_" + issueNumber + "_link").shouldHave(text(issueName));
    }

}
