package ozero.qa.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class SubjectDictionaryComponent {

    public void subjectInput(String value1, String value2, String value3) {
        $("#subjectsInput").setValue(value1).pressEnter();
        $("#subjectsInput").setValue(value2).pressEnter();
        $("#subjectsInput").setValue(value3).pressEnter();
    }
}
