package page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class DayTripBuyPage extends DayTripPage {
    public SelenideElement numberCard = $x(".//span [text()='Номер карты'] /following:: input");
    public SelenideElement chapterBuy = $x(".//span [text()='Номер карты'] /following:: input");
    public SelenideElement chapterCred = $x(".//span [text()='Номер карты'] /following:: input");
    public SelenideElement monthCard = $x(".//span [text()='Месяц'] /following:: input");
    public SelenideElement yearCard = $x(".//span [text()='Год'] /following:: input");
    public SelenideElement userCard = $x(".//span [text()='Владелец'] /following:: input");
    public SelenideElement cvcCodCard = $x(".//span [text()='CVC/CVV'] /following:: input");
    public SelenideElement buttonSend = $x(".//span [text()='Продолжить']");
    public SelenideElement messageError = $$("span [class=\"input__sub\"]").get(0);
    public SelenideElement messageBlock = $("[class*=\"notification notification_visible\"]");

    private DayTripBuyPage() {
    }

    public DayTripBuyPage(String chapter) {
        switch (chapter) {
            case  ("Buy"):
                chapterBuy.shouldBe(Condition.visible);
                break;
            case  ("Cred"):
                chapterCred.shouldBe(Condition.visible);
                break;
        }
    }

    @Step("Заполнить номер карты - {number}")
    public void setNumberCard(String number) {
        numberCard.setValue(number);
    }

    @Step("Заполнить месяц карты - {month}")
    public void setMonthCard(String month) {
        monthCard.setValue(month);
    }

    @Step("Заполнить год карты - {year}")
    public void setYearCard(String year) {
        yearCard.setValue(year);
    }

    @Step("Заполнить владельца карты - {user}")
    public void setUserCard(String user) {
        userCard.setValue(user);
    }

    @Step("Заполнить CvcCod карты - {cvcCod}")
    public void setCvcCodCard(String cvcCod) {
        cvcCodCard.setValue(cvcCod);
    }

    @Step("Нажать \"продолжить\" и сравнить ожидаемым результатом - {inf}")
    public void clickSendCheckMess(String inf) {
        buttonSend.click();
        messageBlock.shouldBe(Condition.exactText(inf), Duration.ofSeconds(15)).shouldBe(Condition.visible);
    }

    @Step("Сравнить ошибку поля с ожидаемой - {textCheck}")
    public void clickCheckError(String textCheck) {
        buttonSend.click();
        messageError.shouldBe(Condition.exactText(textCheck)).shouldBe(Condition.visible);
    }
}