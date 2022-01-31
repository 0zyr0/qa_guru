package ozero.qa.tests.lesson5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentFormWithElementsCollectionTest {

    File testFile = new File("src/test/resources/img/test_file.png");

    //ElementsCollection elementsCollection = new ElementsCollection();

    //executeJavascript()

    Faker faker = new Faker(new Locale("ru"));
    String firstName = faker.name().firstName();
    String userEmail = faker.internet().emailAddress();
    String address = faker.address().fullAddress();
    String currentAddress = faker.lebowski().quote() + faker.medical().medicineName();


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";


    }

    @Test
    void successTest() {


        open("https://demoqa.com/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue("Zero");
        $("#userEmail").setValue(userEmail);
        $("[for=\"gender-radio-3\"]").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#userNumber").setValue("8800555353");
        $("#currentAddress").setValue(currentAddress);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //
        $(".table-responsive").shouldHave(text("Student Name"))
                .parent().shouldHave(text(firstName + " Zero"));

        $(".table").shouldHave(text("Student Name"), text(firstName + " Zero"));
        $(".table").shouldHave(text("Student Email"), text(userEmail));
        $(".table").shouldHave(text("Gender"), text("Other"));
        $(".table").shouldHave(text("Mobile"), text("8800555353"));
        $(".table").shouldHave(text("Date of Birth"), text("30 July,2008"));
        $(".table").shouldHave(text("Subjects"), text("Maths"));
        $(".table").shouldHave(text("Hobbies"), text("Music"));
        $(".table").shouldHave(text("Picture"), text("1.png"));
        $(".table").shouldHave(text("Address"), text(currentAddress));
        $(".table").shouldHave(text("State and City"), text("NCR Noida"));
        $("#closeLargeModal").scrollTo().pressEnter();
    }



}
