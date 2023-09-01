package actions;

import Page.DayTripBuyPage;
import Page.DayTripCredPage;
import Page.DayTripPage;
import com.codeborne.selenide.Condition;
import com.epam.reportportal.annotations.Step;
import util.TestProperties;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static util.LoggingUtils.logInfo;
import static util.TestProperties.getProperties;

public class ActionsPages {
    DayTripPage dayTripPage =new DayTripPage();

    public ActionsPages() {
        open(getProperties("server.url") + ":" + getProperties("server.port"));
        getWebDriver().manage().window().maximize();
        dayTripPage.heading.shouldBe(Condition.visible);
        logInfo("Переходим в приложение");
    }
    @Step("Выбрать Купить")
    public DayTripBuyPage chooseBuy() {
        dayTripPage.buttonBuy.click();
        return new DayTripBuyPage();
    }

    @Step("Выбрать Купить в кредит")

    public DayTripCredPage chooseCred() {
        dayTripPage.buttonCred.click();
        return new DayTripCredPage();
    }

    @Step("Заполнить номер карты - {number}")
    public void setNumberCard(String number) {
        dayTripPage.numberCard.setValue(number);
        logInfo("В поле номер карты введен " + number);
    }

    @Step("Заполнить месяц карты - {month}")

    public void setMonthCard(String month) {
        dayTripPage.monthCard.setValue(month);
        logInfo("В поле месяц карты введен " + month);
    }

    @Step("Заполнить год карты - {year}")

    public void setYearCard(String year) {
        dayTripPage.yearCard.setValue(year);
        logInfo("В поле год карты введен " + year);
    }

    @Step("Заполнить владельца карты - {user}")

    public void setUserCard(String user) {
        dayTripPage.userCard.setValue(user);
        logInfo("В поле владелец карты введен " + user);
    }

    @Step("Заполнить CvcCod карты - {cvcCod}")

    public void setCvcCodCard(String cvcCod) {
        dayTripPage.cvcCodCard.setValue(cvcCod);
        logInfo("В поле Cvc код карты введен " + cvcCod);
    }

    @Step("Нажать \"продолжить\" и сравнить ожидаемым результатом - {inf}")
    public void clickSendCheckMess(String inf) {
        dayTripPage.buttonSend.click();
        dayTripPage.messageBlock.shouldBe(Condition.exactText(inf), Duration.ofSeconds(15)).shouldBe(Condition.visible);
        logInfo("Нажатие Продолжить и ожидание сообщения: " + inf);
    }

    @Step("Сравнить ошибку поля с ожидаемой - {textCheck}")
    public void clickCheckError(String textCheck) {
        dayTripPage.buttonSend.click();
        dayTripPage.messageError.shouldBe(Condition.exactText(textCheck)).shouldBe(Condition.visible);
        logInfo("Нажатие Продолжить и ожидание сообщения: " + textCheck);
    }
}
