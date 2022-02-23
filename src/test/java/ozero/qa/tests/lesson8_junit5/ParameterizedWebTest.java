package ozero.qa.tests.lesson8_junit5;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;

//@Disabled - чтоб выключить все тесты, находящиеся в классе
@DisplayName("Поиск в Яндексе")
public class ParameterizedWebTest {

    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @ValueSource(strings = {"Selenide", "Allure"})
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}" )
    void commonSearchTest(String testData, String expectedResult) {
        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item")
                .first()
//                .shouldHave(Condition.text(expectedResult));
                .shouldHave(Condition.text(testData));

    }

//    @ValueSource(strings = {"Selenide", "Junit"})
    @CsvSource(value = {
            "Selenide, Вышла Selenide",
            "JUnit, 5 is the next generation of"
    })
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}" )
    void commonParamSearchTest(String testData, String expectedResult) {
        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item")
                .first()
                .shouldHave(Condition.text(expectedResult));
    }

    //    @ValueSource(strings = {"Selenide", "Junit"}) //Аналог стрима
    static Stream<Arguments> commonSearchValueSource() {
        return Stream.of(
                Arguments.of("Selenide", false, List.of("1", "2")),
                Arguments.of("JUnit", true, List.of("3", "4"))
        );
    }

//    @CsvSource(value = {
//            "Selenide, Вышла Selenide",
//            "JUnit, 5 is the next generation of"
//    })                        //Аналог стрима реализующий CsvSource
    static Stream<Arguments> commonSearchCsvSource() {
        return Stream.of(
                Arguments.of("Selenide", "Вышла Selenide"),
                Arguments.of("JUnit", "5 is the next generation of")
        );
    }


    static Stream<Arguments> commonSearchTestDataProvider() {
        return Stream.of(
                Arguments.of("Selenide", false, List.of("1", "2")),
                Arguments.of("JUnit", true, List.of("3", "4"))
        );
    }

    @MethodSource("commonSearchTestDataProvider")
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}" )
    void commonSearchForListTest(String testData, boolean flag, List<String> list) {
        System.out.println("Flag: " + flag);
        System.out.println("List: " + list.toString());

        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item")
                .first()
                .shouldHave(Condition.text(testData));
    }



}
