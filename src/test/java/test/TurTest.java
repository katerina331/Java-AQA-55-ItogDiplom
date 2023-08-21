package test;

import com.codeborne.selenide.SelenideElement;
import data.MySQLHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static data.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.LoggingUtils.logInfo;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class TurTest {
//    static int mysqlNum;
    private String uri = "http://localhost:8085";
    private SelenideElement heading = $("h2[class=\"heading heading_size_l heading_theme_alfa-on-white\"]");
    private SelenideElement buttonBuy = $("button[class=\"button button_size_m button_theme_alfa-on-white\"]");
    private SelenideElement buttonCred = $("button[class=\"button button_view_extra button_size_m button_theme_alfa-on-white\"]");
    private SelenideElement numberCard = $("input[placeholder=\"0000 0000 0000 0000\"]");
    private SelenideElement month = $("input[placeholder=\"08\"]");
    private SelenideElement year = $("input[placeholder=\"22\"]");
    private SelenideElement cvcCod = $("input[placeholder=\"999\"]");
    private SelenideElement user = $("[class=\"input input_type_text input_view_default input_size_m input_width_available input_has-label input_theme_alfa-on-white\"] input");
    private SelenideElement buttonSend = $("fieldset button[class=\"button button_view_extra button_size_m button_theme_alfa-on-white\"]");
    private SelenideElement messageBlock = $("[class=\"notification notification_visible notification_status_ok notification_has-closer notification_stick-to_right notification_theme_alfa-on-white\"]");
    private SelenideElement errorBlock = $("[class=\"notification notification_visible notification_status_error notification_has-closer notification_stick-to_right notification_theme_alfa-on-white\"]");

//    @BeforeEach
//    void setup() {
//        open("http://localhost:8085");
//    }
//    @BeforeAll
//    static void mysqlDate() {
//        mysqlNum = MySQLHelper.checkNumMySQL();
//    }
    @BeforeEach
    void setup() {
        open(uri);
        logInfo("Переходим по ссылке " + uri);
    }

    @Test
    void BuyTourForCardApprovedCheckDBTest() {
        int mysqlNum = MySQLHelper.checkNumMySQL();
        buttonBuy.click();
        numberCard.setValue(getFirstCardInfo());
        logInfo("В поле номер карты введен " + getFirstCardInfo());
        month.setValue(getMonthsCardInfo(1));
        logInfo("В поле месяц карты введен " + getMonthsCardInfo(1));
        year.setValue(getYearCardInfo(1));
        logInfo("В поле год карты введен " + getYearCardInfo(1));
        user.setValue(getUserCardInfo());
        logInfo("В поле владелец карты введен " + getUserCardInfo());
        cvcCod.setValue(getCvcCodCardInfo());
        logInfo("В поле Cvc код карты введен " + getCvcCodCardInfo());
        buttonSend.click();
        messageBlock.shouldBe(exactText("Успешно\n" + "Операция одобрена Банком."),Duration.ofSeconds(15)).shouldBe(visible);
        int expectedCheck = ++mysqlNum;
        int actualCheck = MySQLHelper.checkNumMySQL();
        assertEquals(expectedCheck,actualCheck);
        logInfo("Проверка новой записи в базе № " + expectedCheck);
        String expectedStatus = "APPROVED";
        String actualStatus = MySQLHelper.checkInfoCad();
        assertEquals(expectedStatus,actualStatus);
        logInfo("Проверка статуса карты " + expectedStatus);
    }

    @Test
    void BuyTourForCardDeclinedCheckDBTest() {
        int mysqlNum = MySQLHelper.checkNumMySQL();
        buttonBuy.click();
        numberCard.setValue(getSecondCardInfo());
        logInfo("В поле номер карты введен " + getFirstCardInfo());
        month.setValue(getMonthsCardInfo(1));
        logInfo("В поле месяц карты введен " + getMonthsCardInfo(1));
        year.setValue(getYearCardInfo(1));
        logInfo("В поле год карты введен " + getYearCardInfo(1));
        user.setValue(getUserCardInfo());
        logInfo("В поле владелец карты введен " + getUserCardInfo());
        cvcCod.setValue(getCvcCodCardInfo());
        logInfo("В поле Cvc код карты введен " + getCvcCodCardInfo());
        buttonSend.click();
        errorBlock.shouldBe(exactText("Ошибка\n" + "Ошибка! Банк отказал в проведении операции."),Duration.ofSeconds(15)).shouldBe(visible);
//        messageBlock.shouldBe(exactText("Успешно\n" + "Операция одобрена Банком."),Duration.ofSeconds(15)).shouldBe(visible);
        int expectedCheck = ++mysqlNum;
        int actualCheck = MySQLHelper.checkNumMySQL();
        assertEquals(expectedCheck,actualCheck);
        logInfo("Проверка новой записи в базе № " + expectedCheck);
        String expectedStatus = "DECLINED";
        String actualStatus = MySQLHelper.checkInfoCad();
        assertEquals(expectedStatus,actualStatus);
        logInfo("Проверка статуса карты " + expectedStatus);
    }

    @Test
    void BuyTourForNonCardTest() {
        buttonBuy.click();
        numberCard.setValue(getThirdCardInfo());
        logInfo("В поле номер карты введен " + getFirstCardInfo());
        month.setValue(getMonthsCardInfo(1));
        logInfo("В поле месяц карты введен " + getMonthsCardInfo(1));
        year.setValue(getYearCardInfo(1));
        logInfo("В поле год карты введен " + getYearCardInfo(1));
        user.setValue(getUserCardInfo());
        logInfo("В поле владелец карты введен " + getUserCardInfo());
        cvcCod.setValue(getCvcCodCardInfo());
        logInfo("В поле Cvc код карты введен " + getCvcCodCardInfo());
        buttonSend.click();
        errorBlock.shouldBe(exactText("Ошибка\n" + "Ошибка! Банк отказал в проведении операции."),Duration.ofSeconds(15)).shouldBe(visible);
//        messageBlock.shouldBe(exactText("Успешно\n" + "Операция одобрена Банком."),Duration.ofSeconds(15)).shouldBe(hidden);
    }

    @Test
    void BuyTourForTextOnCardNumTest() {
        int mysqlNum = MySQLHelper.checkNumMySQL();
        buttonBuy.click();
        String textCardInfo = getTextCardInfo(16);
        numberCard.setValue(textCardInfo);
        logInfo("В поле номер карты введен " + textCardInfo);
        month.setValue(getMonthsCardInfo(1));
        logInfo("В поле месяц карты введен " + getMonthsCardInfo(1));
        year.setValue(getYearCardInfo(1));
        logInfo("В поле год карты введен " + getYearCardInfo(1));
        user.setValue(getUserCardInfo());
        logInfo("В поле владелец карты введен " + getUserCardInfo());
        cvcCod.setValue(getCvcCodCardInfo());
        logInfo("В поле Cvc код карты введен " + getCvcCodCardInfo());
        buttonSend.click();
        messageBlock.shouldBe(exactText("Успешно\n" + "Операция одобрена Банком."),Duration.ofSeconds(15)).shouldBe(visible);
        int expectedCheck = ++mysqlNum;
        int actualCheck = MySQLHelper.checkNumMySQL();
        assertEquals(expectedCheck,actualCheck);
        logInfo("Проверка новой записи в базе № " + expectedCheck);
        String expectedStatus = "APPROVED";
        String actualStatus = MySQLHelper.checkInfoCad();
        assertEquals(expectedStatus,actualStatus);
        logInfo("Проверка статуса карты " + expectedStatus);
    }
}