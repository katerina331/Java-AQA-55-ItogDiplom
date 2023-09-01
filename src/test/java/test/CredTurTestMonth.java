package test;

import actions.ActionsPages;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static data.DataHelper.*;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class CredTurTestMonth {
    ActionsPages actionsPages;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        actionsPages = new ActionsPages();
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные текстовые значения месяца")
    void buyTourCredForTextOnCardMonth() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getTextCardInfo(2));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные символьные значения месяца")
    void buyTourCredForSymbolOnCardMonth() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getSymbolCardInfo(2));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные знаки в значения месяца")
    void buyTourCredForSignOnCardMonth() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getSingCardInfo(2));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные пустые значения месяца")
    void buyTourCredForEmptyOnCardMonth() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard("");
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидный 13 месяц")
    void buyTourCredForThirteenOnCardMonth() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard("13");
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckWrongInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидный нулевой месяц")
    void buyTourCredForZeroOnCardMonth() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard("0");
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
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
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не два ноля в месяц")
    void buyTourCredForDoubleZeroOnCardMonth() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard("0");
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }
}