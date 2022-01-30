package ozero.qa.tests.lesson2.homework2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationBestPracticeTests {

    File testFile = new File("src/test/resources/img/test_file.png");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";


    }

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Max");
        $("#lastName").setValue("Zero");
        $("#userEmail").setValue("ozero@mail.com");
        $("[for=\"gender-radio-3\"]").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#userNumber").setValue("8800555353");
        $("#currentAddress").setValue("www.leningrad-spb.ru");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

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
