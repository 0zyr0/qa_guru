package ozero.qa.tests.lesson5.homework5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ozero.qa.pages.RegistrationPage;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentFormHW5PageObjectFakerTest {

    RegistrationPage registrationPage = new RegistrationPage();


    Faker faker = new Faker(new Locale("ru"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().phoneNumber();
    String address = faker.address().fullAddress();
    String currentAddress = faker.lebowski().quote() + faker.medical().medicineName();


    File testFile = new File("src/test/resources/img/test_file.png");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .markRadioButton(2)
                .typePhoneNumber(phoneNumber);

        registrationPage.scrollComponent.scrollPage($("#dateOfBirthInput"));

        registrationPage.calendarComponent.setDate("30", "July", "2008");
        registrationPage.subjectDictionaryComponent.subjectInput("Math", "Physics", "Commerce");

        //Остановился здесь

        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("www.leningrad-spb.ru");
        $("#state").scrollTo().click();

        registrationPage.stateCityDropdownComponent.selectCountryAndCity( "NCR", "Noida");




        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("www.leningrad-spb.ru");
        $("#state").scrollTo().click();

        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();



        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //
        $(".table-responsive").shouldHave(text("Student Name"))
                .parent().shouldHave(text("Max Zero"));

        registrationPage.checkResultsValue("Student Name", "Maxim Zetter");

        $(".table").shouldHave(text("Student Name"), text("Max Zero"));
        $(".table").shouldHave(text("Student Email"), text("ozero@mail.com"));
        $(".table").shouldHave(text("Gender"), text("Other"));
        $(".table").shouldHave(text("Mobile"), text("8800555353"));
        $(".table").shouldHave(text("Date of Birth"), text("30 July,2008"));
        $(".table").shouldHave(text("Subjects"), text("Maths"));
        $(".table").shouldHave(text("Hobbies"), text("Music"));
        $(".table").shouldHave(text("Picture"), text("1.png"));
        $(".table").shouldHave(text("Address"), text("www.leningrad-spb.ru"));
        $(".table").shouldHave(text("State and City"), text("NCR Noida"));
        $("#closeLargeModal").scrollTo().pressEnter();
    }

}
