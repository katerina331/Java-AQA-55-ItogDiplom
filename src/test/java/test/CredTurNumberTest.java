package test;

import org.junit.jupiter.api.*;
import page.DayTripBuyPage;
import page.DayTripPage;
import util.StartTest;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.*;

public class CredTurNumberTest {
    DayTripPage dayTripPage;

    @BeforeAll
    static void setUpAll() {
        StartTest.setUpAll();
    }

    @AfterAll
    static void tearDownAll() {
        StartTest.tearDownAll();
    }

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        open("/");
        dayTripPage = new DayTripPage();
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по несуществующему номеру карты")
    void buyTourCredForNonCardTest() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseCred();
        dayTripBuyPage.setNumberCard(getRandNumbCardInfo(16));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickSendCheckMess(getCheckErrorInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные текстовые значения карты")
    void buyTourCredForTextOnCardNumTest() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseCred();
        dayTripBuyPage.setNumberCard(getTextCardInfo(16));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные символьные значения карты")
    void buyTourCredForSymbolOnCardNumTest() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseCred();
        dayTripBuyPage.setNumberCard(getSymbolCardInfo(16));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные знаки в значения карты")
    void buyTourCredForSignOnCardNumTest() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseCred();
        dayTripBuyPage.setNumberCard(getSingCardInfo(16));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные пустые значения карты")
    void buyTourCredForEmptyOnCardNumTest() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseCred();
        dayTripBuyPage.setNumberCard(getRandNumbCardInfo(0));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные длинные значения карты")
    void buyTourCredForLongOnCardNumTest() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseCred();
        dayTripBuyPage.setNumberCard(getRandNumbCardInfo(17));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные короткие значения карты")
    void buyTourCredForShortOnCardNumTest() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseCred();
        dayTripBuyPage.setNumberCard(getRandNumbCardInfo(15));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные из одной цифры значения карты")
    void buyTourCredForOneNumericOnCardNumTest() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseCred();
        dayTripBuyPage.setNumberCard(getSingCardInfo(1));
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидный нулевой номер карты")
    void buyTourCredForZerosOnCardNumTest() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseCred();
        dayTripBuyPage.setNumberCard("0000 0000 0000 0000");
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }
}