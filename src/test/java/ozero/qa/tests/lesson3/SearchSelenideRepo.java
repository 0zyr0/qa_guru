package ozero.qa.tests.lesson3;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SearchSelenideRepo {

    @Test
    void shouldFindSelenideRepoInGitHub() {

        //open page
        open("https://github.com/");

        //ввести в поле поиска selenide нажать enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //$("[data-test-selector=nav-search-input]").pressEnter();


        //нажимаем на линк первого рез-та поиска
        $$("ul:repo-list li").first().$("a").click();
        //проверка: в заголовке встречается selenide/selenide

        $("h1").shouldHave(text("selenide / selenide"));

        //все проверки лучше делать через shouldHave shouldBe и т.д.

        //sleep(5000);

        //Построение тестов:
        //1. ARRANGE (optional) Подготовка
        //2. ACT Действия
        //3. ASSERT Проверки


        //Построение тестов (Другая версия e2e):
        // ARRANGE (optional) Подготовка
        // ACT Действия
        // ASSERT Проверки
        //..
        // ACT Действия
        // ASSERT Проверки
        // ACT Действия
        // ASSERT Проверки

//        //сохранение значения локатора
//        var element = $("abc");
//
//        element.click();
//        element.shouldBe(visible);

//        //получить текущий url страницы
//        var url = WebDriverRunner.url();
        //вариант 1
        //webdriver().shouldHave(url("https://ozero.com"));
        //вариант 2
//        Assertions.assertEquals("https://ozero.com", url);

    }

}
