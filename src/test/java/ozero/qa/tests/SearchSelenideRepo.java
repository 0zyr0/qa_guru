package ozero.qa.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepo {

    @Test
    void shouldFindSelenideRepo() {

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


        //Построение тестов (Другая версия):
        // ARRANGE (optional) Подготовка
        // ACT Действия
        // ASSERT Проверки
        //..
        // ACT Действия
        // ASSERT Проверки
        // ACT Действия
        // ASSERT Проверки

    }

}
