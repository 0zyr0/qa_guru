package ozero.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeTests {

    File testFile = new File("D:\\QA.GURU\\projects\\qa_guru_lesson_2\\test_file.png");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Max");
        $("#lastName").setValue("Zero");
        $("#userEmail").setValue("ozero@mail.com");
        //$(By.name("gender")).selectRadio("male");
        $("[for=\"gender-radio-3\"]").click();

        $("#userNumber").setValue("8800555353");

        //date

        //$("[class=subjects-auto-complete__input]").setValue("Test fill field");

        $("[for=\"hobbies-checkbox-3\"]").click();

        $("#currentAddress").setValue("www.leningrad-spb.ru");

        $x("//input[@id='uploadPicture']").uploadFile(testFile);

        $("#dateOfBirthInput").click();

        $("[class=react-datepicker__month-select]").selectOption(5);
        $("[class=react-datepicker__year-select]").selectOption(93);
        //$("[class=react-datepicker__day react-datepicker__day--013 react-datepicker__day--weekend]").click();



        //$("#submit").click();

//        $("#output").shouldBe(visible);
//
//        $("#name").shouldHave(text("Alex"));
//        $("#email").shouldHave(text("email@email.com"));
//        $("#output #currentAddress").shouldHave(text("Some address"));
//        $("#output").$("#permanentAddress").shouldHave(text("Another address"));

    }

}
