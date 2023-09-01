package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DayTripBuyPage {
//    public SelenideElement numberCard = $("input[placeholder=\"0000 0000 0000 0000\"]"); .//span [text()='Номер карты'] /following:: input [class="input__control"]
    public SelenideElement numberCard = $x(".//span [text()='Номер карты'] /following:: input");
//    public SelenideElement monthCard = $("input[placeholder=\"08\"]");
    public SelenideElement monthCard = $x(".//span [text()='Месяц'] /following:: input");
//    public SelenideElement yearCard = $("input[placeholder=\"22\"]");
    public SelenideElement yearCard = $x(".//span [text()='Год'] /following:: input");
    public SelenideElement userCard = $x(".//span [text()='Владелец'] /following:: input");
//    public SelenideElement cvcCodCard = $("input[placeholder=\"999\"]");
    public SelenideElement cvcCodCard = $x(".//span [text()='CVC/CVV'] /following:: input");
//    public SelenideElement buttonSend = $("fieldset button[class=\"button button_view_extra button_size_m button_theme_alfa-on-white\"]");
    public SelenideElement buttonSend = $x(".//span [text()='Продолжить']");
    public SelenideElement messageError = $$("span [class=\"input__sub\"]").get(0);
    public SelenideElement messageBlock = $("[class*=\"notification notification_visible\"]");
}
