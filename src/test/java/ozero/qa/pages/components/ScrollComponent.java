package ozero.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;



public class ScrollComponent {

    SelenideElement dateScroll = $("#dateOfBirthInput");
    SelenideElement stateScroll = $("#state");
    SelenideElement closeModal = $("#closeLargeModal");

    public void scrollPageOnDate() {
        dateScroll.scrollTo();

    }

    public void scrollPageOnState() {
        stateScroll.scrollTo().click();
    }

    public void scrollAndClose() {
        closeModal.scrollTo().pressEnter();
    }

}
