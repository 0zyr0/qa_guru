package ozero.qa.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import ozero.qa.pages.components.CalendarComponent;
import ozero.qa.pages.components.ScrollComponent;
import ozero.qa.pages.components.StateCityDropdownComponent;
import ozero.qa.pages.components.SubjectDictionaryComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            radioButtonMale = $("[for=\"gender-radio-1\"]"),
            radioButtonFeMale = $("[for=\"gender-radio-2\"]"),
            radioButtonOther = $("[for=\"gender-radio-1\"]"),
            resultsTable = $(".table-responsive"),
            mobilePhoneNumber = $("#userNumber");

    public CalendarComponent calendarComponent = new CalendarComponent();
    public SubjectDictionaryComponent subjectDictionaryComponent = new SubjectDictionaryComponent();
    public StateCityDropdownComponent stateCityDropdownComponent = new StateCityDropdownComponent();
    public ScrollComponent scrollComponent = new ScrollComponent();

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

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage markRadioButton(int value) {

        switch (value) {
            case 1:
                radioButtonMale.click();
                break;
            case 2:
                radioButtonFeMale.click();
                break;
            case 3:
                radioButtonOther.click();
        }

        return this;
    }

    public RegistrationPage typePhoneNumber(String value) {
        mobilePhoneNumber.setValue(value);
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


    public RegistrationPage uploadPicture() {
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        return this;
    }



    /*
    public AnotherPage clickOnAnotherPage() {
        $("").click();

        return new AnotherPage();
    }
*/
}
