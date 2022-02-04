package ozero.qa.tests.lesson7_java_file;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class SelenideFilesTest {

    @Test
    void downloadTest() {
        try {
            File dowloadedFile = Selenide.$("#raw-url").download();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
