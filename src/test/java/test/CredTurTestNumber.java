package test;

import actions.ActionsPages;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static data.DataHelper.*;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class CredTurTestNumber {
    ActionsPages actionsPages;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        actionsPages = new ActionsPages();
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по несуществующему номеру карты")
    void buyTourCredForNonCardTest() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getRandNumbCardInfo(16));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickSendCheckMess(getCheckErrorInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные текстовые значения карты")
    void buyTourCredForTextOnCardNumTest() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getTextCardInfo(16));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные символьные значения карты")
    void buyTourCredForSymbolOnCardNumTest() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getSymbolCardInfo(16));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные знаки в значения карты")
    void buyTourCredForSignOnCardNumTest() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getSingCardInfo(16));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные пустые значения карты")
    void buyTourCredForEmptyOnCardNumTest() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getRandNumbCardInfo(0));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные длинные значения карты")
    void buyTourCredForLongOnCardNumTest() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getRandNumbCardInfo(17));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные короткие значения карты")
    void buyTourCredForShortOnCardNumTest() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getRandNumbCardInfo(15));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные из одной цифры значения карты")
    void buyTourCredForOneNumericOnCardNumTest() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getSingCardInfo(1));
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидный нулевой номер карты")
    void buyTourCredForZerosOnCardNumTest() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard("0000 0000 0000 0000");
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }
}