package test;

import actions.ActionsPages;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static data.DataHelper.*;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class CredTurTestYear {
    ActionsPages actionsPages;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        actionsPages = new ActionsPages();
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидный прошедший месяц текущего года")
    void buyTourCredForOldOnCardMonth() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(-1));
        actionsPages.setYearCard(getYearCardInfo(0));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckExpiredInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидный нулевой месяц")
    void buyTourCredForDoubleZeroOnCardMonth() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard("0");
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные текстовые значения года")
    void buyTourCredForTextOnCardYear() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getTextCardInfo(2));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные символьные значения года")
    void buyTourCredForSymbolOnCardYear() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getSymbolCardInfo(2));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные знаки в значения года")
    void buyTourCredForSignOnCardYear() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getSingCardInfo(2));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные пустые значения года")
    void buyTourCredForEmptyOnCardYear() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard("");
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные прошедший год")
    void buyTourCredForOldOnCardYear() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(-1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckWrongInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные год больше на 6 лет")
    void buyTourCredForBigOnCardYear() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(7));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckWrongInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные полное значения года")
    void buyTourCredForFullOnCardYear() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard("20" + getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckExpiredInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные нулевое значения года")
    void buyTourCredForZeroOnCardYear() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard("0");
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные с двойным нулем значения года")
    void buyTourCredForDoubleZeroOnCardYear() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard("00");
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckExpiredInfo());
    }
}