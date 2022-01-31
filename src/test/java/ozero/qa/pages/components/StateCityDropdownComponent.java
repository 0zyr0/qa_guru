package ozero.qa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateCityDropdownComponent {


    public void selectCountryAndCity(String country, String city) {
        //Способ 1
        $("#stateCity-wrapper").$(byText(country)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        //Способ 2
//        switch (country) {
//
//            case ("NCR"):
//                $("#stateCity-wrapper").$(byText("NCR")).click();
//                $("#city").click();
//                switch (city) {
//                    case ("Delhi"):
//                        $("#stateCity-wrapper").$(byText("Delhi")).click();
//                        break;
//                    case ("Guargon"):
//                        $("#stateCity-wrapper").$(byText("Guargon")).click();
//                        break;
//                    case ("Noida"):
//                        $("#stateCity-wrapper").$(byText("Noida")).click();
//                        break;
//                }
//                break;
//
//            case ("Uttar Pradesh"):
//                $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
//                $("#city").click();
//                switch (city) {
//                    case ("Agra"):
//                        $("#stateCity-wrapper").$(byText("Agra")).click();
//                        break;
//                    case ("Lucknow"):
//                        $("#stateCity-wrapper").$(byText("Lucknow")).click();
//                        break;
//                    case ("Merrut"):
//                        $("#stateCity-wrapper").$(byText("Merrut")).click();
//                        break;
//                }
//                break;
//            case ("Haryana"):
//                $("#stateCity-wrapper").$(byText("Haryana")).click();
//                $("#city").click();
//                switch (city) {
//                    case ("Karnal"):
//                        $("#stateCity-wrapper").$(byText("Karnal")).click();
//                        break;
//                    case ("Panipat"):
//                        $("#stateCity-wrapper").$(byText("Panipat")).click();
//                        break;
//                }
//                break;
//            case ("Rajasthan"):
//                $("#stateCity-wrapper").$(byText("Rajasthan")).click();
//                $("#city").click();
//                switch (city) {
//                    case ("Jaipur"):
//                        $("#stateCity-wrapper").$(byText("Jaipur")).click();
//                        break;
//                    case ("Jaiselmer"):
//                        $("#stateCity-wrapper").$(byText("Jaiselmer")).click();
//                        break;
//                }
//                break;
//        }
    }
}
