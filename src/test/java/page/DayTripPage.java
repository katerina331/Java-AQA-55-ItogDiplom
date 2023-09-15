package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static util.Screenshot.saveAllureScreenshot;

public class DayTripPage {
    public SelenideElement heading = $("h2[class=\"heading heading_size_l heading_theme_alfa-on-white\"]");
    public SelenideElement buttonBuy = $("button[class=\"button button_size_m button_theme_alfa-on-white\"]");
    public SelenideElement buttonCred = $("button[class=\"button button_view_extra button_size_m button_theme_alfa-on-white\"]");

    public DayTripPage() {
        heading.shouldBe(Condition.visible);
        saveAllureScreenshot();
    }

    @Step("Выбрать Купить")
    public DayTripBuyPage chooseBuy() {
        buttonBuy.click();
        return new DayTripBuyPage("Buy");
    }

    @Step("Выбрать Купить в кредит")
    public DayTripBuyPage chooseCred() {
        buttonCred.click();
        return new DayTripBuyPage("Cred");
    }
}