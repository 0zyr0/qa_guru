package ozero.qa.tests.lesson6_allure.homework6;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class IssueNumber {

    public void checkIssueNumber(int issueNumber, String issueName) {
        $("#issue_" + issueNumber + "_link").shouldHave(text(issueName));
    }
}
