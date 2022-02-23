package ozero.qa.tests.lesson8_junit5.homework8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static com.codeborne.selenide.Selectors.byText;

public class ParamSpotifyTest {

//1) Написать свои варианты параметризованных веб-тестов (не на поиск в яндексе или гугле)
//
//1.1) Попробовать разные варианты атапровайдеров (аннотаций)
//
//2) Опционально (advanced!)- доработать класс Junit из репо для того, чтоб он поддерживал выполнение методов @BeforeEach / @AfterEach, @BeforeAll/AfterAll



    @CsvSource(value = {
            "Bring me the horizon",
            "Breaking Benjamin"
    })
    @ParameterizedTest(name = "Тестирование алгоритма поиска с тестовыми данными: {0}" )
    void commonParamSearchTest(String testData, String expectedResult) {
        Selenide.open("https://open.spotify.com/");
        Selenide.$(byText("Поиск")).click();
        Selenide.$("[data-testid='search-input']").setValue(testData).pressEnter();

//        Selenide.$$("li.serp-item")
//                .first()
//                .shouldHave(Condition.text(expectedResult));
    }


//    void testForNatashaScott() {
//        Selenide.open("https://open.spotify.com/"); //Эта штука говорит, открой спотифай
////        "//" - это комментарии, созданы для пояснения, можешь их писать когда что-то непонятно и оно никак не испортит код
//        Selenide.$(byText("Поиск")).click();
//        Selenide.$("[data-testid='search-input']").setValue("Наташа Скотт").pressEnter();
//        //Пишем в поиск имя и жмем Enter
//    }

}
