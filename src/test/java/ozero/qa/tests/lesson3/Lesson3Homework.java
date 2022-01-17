package ozero.qa.tests.lesson3;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.HoverOptions.withOffset;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson3Homework {

    //Задание 1

    @Test
    void openSpotify() {
        open("https://open.spotify.com/");

//      В Приведенном ниже мной примере разницы в обращении к элементам не будет.
//
//      Однако если у нас окажется несколько элементов h1 или div и некоторые из них будут видимыми, а некоторые нет, то
//      $("h1 div"); и $("h1").$("div"); предоставит нам разный результат
//
//        $("body div div .XiVwj5uoqqSFpS4cYOC6").click();
//
//        sleep(5000);
        $("body").$("div div .XiVwj5uoqqSFpS4cYOC6").click();

        //sleep(5000);
    }

    //Задание 2

    @Test
    void wikiPagesOpen() {


        //открыть сраничку репозитория селенида
        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();
        $(byText("Soft assertions")).shouldHave(text("Soft assertions")).click();

        $$("ol").last().shouldHave(text("JUnit5"));
        $$("[class='pl-k']").findBy(text("@ExtendWith"));


    }

    //Задание 3

    @Test
    void internetDragAndDrop() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }

}
