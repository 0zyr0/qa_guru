package ozero.qa.tests.lesson5;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NegativeTest {

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

        $("#submit").click();
        //проверка что последующая форма не отображается
        $(".modal-content").shouldNot(exist);

    }



}
