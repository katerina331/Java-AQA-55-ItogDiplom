package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DayTripCredPage {
    public SelenideElement numberCard = $("input[placeholder=\"0000 0000 0000 0000\"]");
    public SelenideElement CardError = $$("span.input__sub").get(0);
    public SelenideElement monthCard = $("input[placeholder=\"08\"]");
    public SelenideElement monthCardError = $$("span.input__sub").get(1);
    public SelenideElement yearCard = $("input[placeholder=\"22\"]");
    public SelenideElement yearCardError = $$("span.input__sub").get(2);
    public SelenideElement userCard = $("[class=\"input input_type_text input_view_default input_size_m input_width_available input_has-label input_theme_alfa-on-white\"] input");
    public SelenideElement userCardError = $$("span.input__sub").get(3);
    public SelenideElement cvcCodCard = $("input[placeholder=\"999\"]");
    public SelenideElement cvcCodCardError = $$("span.input__sub").get(4);
    public SelenideElement buttonSend = $("fieldset button[class=\"button button_view_extra button_size_m button_theme_alfa-on-white\"]");
    public SelenideElement messageBlock = $("[class=\"notification notification_visible notification_status_ok notification_has-closer notification_stick-to_right notification_theme_alfa-on-white\"]");
    public SelenideElement messageError = $("[class=\"notification notification_status_error notification_has-closer notification_stick-to_right notification_theme_alfa-on-white\"]");
}
