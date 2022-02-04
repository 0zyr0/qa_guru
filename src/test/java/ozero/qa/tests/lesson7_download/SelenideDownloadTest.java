package ozero.qa.tests.lesson7_download;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class SelenideDownloadTest {

    @Test
    void downloadTest() throws FileNotFoundException {
            File dowloadedFile = Selenide.$("#raw-url").download();
    }

}
