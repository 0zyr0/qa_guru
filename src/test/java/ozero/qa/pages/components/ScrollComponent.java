package ozero.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class ScrollComponent {

    public void scrollPage(SelenideElement element) {
        element.scrollTo();

    }
}
