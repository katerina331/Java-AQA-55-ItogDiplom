package test;

import actions.ActionsPages;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static data.DataHelper.*;
import static data.SQLHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class BuyTurTestNumber {
    ActionsPages actionsPages;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        actionsPages = new ActionsPages();
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой по несуществующему номеру карты")
    void buyTourForNonCardTest() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getRandNumbCardInfo(16));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickSendCheckMess(getCheckErrorInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные текстовые значения карты")
    void buyTourForTextOnCardNumTest() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getTextCardInfo(16));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные символьные значения карты")
    void buyTourForSymbolOnCardNumTest() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getSymbolCardInfo(16));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные знаки в значения карты")
    void buyTourForSignOnCardNumTest() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getSingCardInfo(16));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные пустые значения карты")
    void buyTourForEmptyOnCardNumTest() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getRandNumbCardInfo(0));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные длинные значения карты")
    void buyTourForLongOnCardNumTest() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getRandNumbCardInfo(17));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные короткие значения карты")
    void buyTourForShortOnCardNumTest() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getRandNumbCardInfo(15));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные из одной цифры значения карты")
    void buyTourForOneNumericOnCardNumTest() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getSingCardInfo(1));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидный нулевой номер карты")
    void buyTourForZerosOnCardNumTest() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard("0000 0000 0000 0000");
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }
}