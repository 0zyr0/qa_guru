package ozero.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
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

        //Check Name form
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue("Max");
        $("#lastName").setValue("Zero");
        $("#userEmail").setValue("ozero@mail.com");
        //$(By.name("gender")).selectRadio("male");

        //Radio button
        //$("#gender-radio-3\").click() NOT WORKING
        //$("#gender-radio-3").doubleClick() WORKING BUT WHY?

        //Способ 1. Поиск родственного элемента
        //$("#gender-radio-3").parent().click();

        //Способ 2. По тексту. BAD PRACTICE, т.к. слово Other может встречаться в DOM несколько раз
        //$(byText("Other")).click();

        //Способ 2. GOOD PRACTICE
        //$("#genterWrapper").$(byText("Other")).click();

        //Способ 3. for
        //$("[for='gender-radio-3']").click(); Апостроф ' используется для случаев, если в названии есть пробел
        //$(label"[for='gender-radio-3']").click();
        $("[for=\"gender-radio-3\"]").click();


        //Date field
        $("#dateOfBirthInput").click();

        //Month
        $(".react-datepicker__month-select").selectOption("July");
        //$("[class=react-datepicker__month-select]").selectOption(5);

        //Year
        $(".react-datepicker__year-select").selectOption("2008");

        //Day
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        //Day Other method
//        $$(".react-datepicker__day--030")
//                .filter(not(cssClass(".react-datepicker__day--outside-month")))
//                .first() // .get(0) //alternative method
//                .click();

        //Day Another method

//        $("[aria-label=\"Choose Sunday, July 30th, 2008\"]").click(); //WORK
//        $("[aria-label='Choose Sunday, July 30th, 2008']").click(); //WORK
//        $("[aria-label$='July 30th, 2008']").click(); //WORK
//        $("[aria-label=Choose Sunday, July 30th, 2008]").click(); //NOT Work Не учитываются пробелы

        //Day by xpath
//        $x("//*[contains(@aria-label, \"July 30th, 2008\"]").click();

            //1:33

        //<div class="react-datepicker__day react-datepicker__day--013 react-datepicker__day--weekend" tabindex="-1" aria-label="Choose Sunday, June 13th, 1993" role="option" aria-disabled="false">13</div>

        //Subject Input
        $("#subjectsInput").setValue("Math").pressEnter();

        //Subject Input Alternative
//        $("#subjectsInput").setValue("Math") //todo why not working
        //$("#subjectsWrapper").$(byText("Math")).click();


        // CheckBoxes
        $("#hobbiesWrapper").$(byText("Music")).click();


        // Attach file
        $x("//input[@id='uploadPicture']").uploadFile(testFile);

        // Attach alternative 1.1
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));

        // Attach alternative 1.2
//        File someFile = new File("src/test/resources/img/1.png");
//        $("#uploadPicture").uploadFile(someFile);

        // Attach alternative 2. So shortly method and effective
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        //userNumber
        $("#userNumber").setValue("8800555353");


        //Current Address
        $("#currentAddress").setValue("www.leningrad-spb.ru");

        //Drop-Down List
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();


        //Assert

        $$(".table tr td").get(1).equals("Max Zero");

        $$(".table tr td").get(3).equals("ozero@mail.com");

        $$(".table tr td").get(5).equals("Other");

        $$(".table tr td").get(7).equals("8800555353");

        $$(".table tr td").get(9).equals("30 July,2008");

        $$(".table tr td").get(11).equals("Maths");

        $$(".table tr td").get(13).equals("Music");

        $$(".table tr td").get(15).equals("1.png");

        $$(".table tr td").get(17).equals("www.leningrad-spb.ru");

        $$(".table tr td").get(19).equals("NCR Noida");



//        String name = $$(".table tr td").get(7).toString();
//
//        System.out.println(" 7 elem = " + name);

//        $$(byClassName("table table-dark table-striped table-bordered table-hover"));

        $("#closeLargeModal").scrollTo().pressEnter();






        //date

        //$("[class=subjects-auto-complete__input]").setValue("Test fill field");

//        $("[for=\"hobbies-checkbox-3\"]").click();
//
//
//        $("#dateOfBirthInput").click();





        //$("#submit").click();

//        $("#output").shouldBe(visible);
//
//        $("#name").shouldHave(text("Alex"));
//        $("#email").shouldHave(text("email@email.com"));
//        $("#output #currentAddress").shouldHave(text("Some address"));
//        $("#output").$("#permanentAddress").shouldHave(text("Another address"));

    }

}
