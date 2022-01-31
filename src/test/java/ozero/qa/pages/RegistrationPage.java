package ozero.qa.pages;

import com.codeborne.selenide.SelenideElement;
import ozero.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive");

    public CalendarComponent calendarComponent = new CalendarComponent();

//Chain fluent DSL
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }


    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }


    public RegistrationPage checkResultsValue(String key, String value) {

        firstNameInput.setValue(value);
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }



    /*
    public AnotherPage clickOnAnotherPage() {
        $("").click();

        return new AnotherPage();
    }
*/
}
