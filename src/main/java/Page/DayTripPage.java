package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DayTripPage extends DayTripBuyPage {
    public SelenideElement heading = $("h2[class=\"heading heading_size_l heading_theme_alfa-on-white\"]");
    public SelenideElement buttonBuy = $("button[class=\"button button_size_m button_theme_alfa-on-white\"]");
    public SelenideElement buttonCred = $("button[class=\"button button_view_extra button_size_m button_theme_alfa-on-white\"]");

}
