package test;

import page.DayTripBuyPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static data.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class BuyTurTestNumber {
    DayTripBuyPage dayTripBuyPage;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        dayTripBuyPage = new DayTripBuyPage();
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой по несуществующему номеру карты")
    void buyTourForNonCardTest() {
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getRandNumbCardInfo(16));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickSendCheckMess(getCheckErrorInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные текстовые значения карты")
    void buyTourForTextOnCardNumTest() {
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getTextCardInfo(16));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные символьные значения карты")
    void buyTourForSymbolOnCardNumTest() {
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getSymbolCardInfo(16));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные знаки в значения карты")
    void buyTourForSignOnCardNumTest() {
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getSingCardInfo(16));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные пустые значения карты")
    void buyTourForEmptyOnCardNumTest() {
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getRandNumbCardInfo(0));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные длинные значения карты")
    void buyTourForLongOnCardNumTest() {
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getRandNumbCardInfo(17));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные короткие значения карты")
    void buyTourForShortOnCardNumTest() {
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getRandNumbCardInfo(15));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные из одной цифры значения карты")
    void buyTourForOneNumericOnCardNumTest() {
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getSingCardInfo(1));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидный нулевой номер карты")
    void buyTourForZerosOnCardNumTest() {
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard("0000 0000 0000 0000");
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }
}