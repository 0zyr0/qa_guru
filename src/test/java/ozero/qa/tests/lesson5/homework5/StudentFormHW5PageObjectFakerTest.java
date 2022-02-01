package ozero.qa.tests.lesson5.homework5;

import com.codeborne.selenide.Configuration;
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
import static ozero.qa.utils.RandomUtils.getRandomPhone;

public class StudentFormHW5PageObjectFakerTest {

    RegistrationPage registrationPage = new RegistrationPage();


    Faker fakerRus = new Faker(new Locale("ru"));
    Faker fakerEng = new Faker(new Locale("en"));
    String firstName = fakerRus.name().firstName();
    String lastName = fakerRus.name().lastName();
    String userEmail = fakerEng.internet().emailAddress();
    String phoneNumber = getRandomPhone();
    String filePath = "img/1.png";
    String hobby = "Music";
    String address = fakerRus.address().fullAddress();

    File testFile = new File("src/test/resources/img/test_file.png");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        //ACTIONS способ 1
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .markRadioButton(2)
                .typePhoneNumber(phoneNumber);

        registrationPage.scrollComponent.scrollPageOnDate();
        registrationPage.calendarComponent.setDate("30", "July", "2008");
        registrationPage.subjectDictionaryComponent.subjectInput("Math", "Physics", "Commerce");
        registrationPage.markHobbies(hobby);
        registrationPage.uploadPicture(filePath);
        registrationPage.typeAddress(address);
        registrationPage.scrollComponent.scrollPageOnState();
        registrationPage.stateCityDropdownComponent.selectCountryAndCity( "NCR", "Noida");
        registrationPage.submitForm();

//        ACTIONS способ 2
//        registrationPage.openPage()
//                .typeFirstName(firstName)
//                .typeLastName(lastName)
//                .typeEmail(userEmail)
//                .markRadioButton(2)
//                .typePhoneNumber(phoneNumber)
//                .scrollComponent.scrollPageOnDate();
//
//        registrationPage.calendarComponent.setDate("30", "July", "2008");
//        registrationPage.subjectDictionaryComponent.subjectInput("Math", "Physics", "Commerce");
//        registrationPage.markHobbies(hobby)
//                        .uploadPicture(filePath)
//                        .typeAddress(address)
//                        .scrollComponent.scrollPageOnState();
//
//        registrationPage.stateCityDropdownComponent.selectCountryAndCity( "NCR", "Noida");
//        registrationPage.submitForm();

        //ASSERTS

        registrationPage.checkHeaderForm("Thanks for submitting the form");


        registrationPage.сheckTableValues("Student Name", firstName + " " + lastName);
        registrationPage.сheckTableValues("Student Email", userEmail);

        registrationPage.сheckTableValues("Gender", "Female");
        registrationPage.сheckTableValues("Mobile", phoneNumber);
        registrationPage.сheckTableValues("Date of Birth", "30 July,2008");

        registrationPage.сheckTableValues("Hobbies", hobby);
        registrationPage.сheckTableValues("Picture", "1.png");
        registrationPage.сheckTableValues("Address", address);
        registrationPage.сheckTableValues("State and City", "NCR Noida");

        registrationPage.сheckTableValues("Subjects", "Maths, Physics, Commerce");
        //registrationPage.сheckTableValues("Subjects", "Math" + ", " + "Physics" +", " + "Commerce");

        registrationPage.scrollComponent.scrollAndClose();
    }

}
