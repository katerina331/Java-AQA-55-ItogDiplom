package test;

import org.junit.jupiter.api.*;
import page.DayTripBuyPage;
import page.DayTripPage;
import util.StartTest;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.*;

public class BuyTurCvcCodTest {
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
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные текстовые значения cvc/cvv")
    void buyTourForTextOnCardCvcCod() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getTextCardInfo(3));
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные символьные значения cvc/cvv")
    void buyTourForSymbolOnCardCvcCod() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getSymbolCardInfo(3));
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные знаки в значения cvc/cvv")
    void buyTourForSignOnCardCvcCod() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getSingCardInfo(3));
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные пустые значения cvc/cvv")
    void buyTourForEmptyOnCardCvcCod() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard("");
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидную одну цифру в значения cvc/cvv")
    void buyTourForCyrillicOnCardCvcCod() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getRandNumbCardInfo(1));
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные большее значения cvc/cvv")
    void buyTourForLongOnCardCvcCod() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getRandNumbCardInfo(4));
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидный пробел в значения cvc/cvv")
    void buyTourForSpaceOnCardCvcCod() {
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(" ");
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }
}