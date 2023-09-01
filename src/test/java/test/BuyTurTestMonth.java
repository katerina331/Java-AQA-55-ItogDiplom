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
public class BuyTurTestMonth {
    ActionsPages actionsPages;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        actionsPages = new ActionsPages();
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные текстовые значения месяца")
    void buyTourForTextOnCardMonth() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getTextCardInfo(2));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные символьные значения месяца")
    void buyTourForSymbolOnCardMonth() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getSymbolCardInfo(2));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные знаки в значения месяца")
    void buyTourForSignOnCardMonth() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getSingCardInfo(2));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные пустые значения месяца")
    void buyTourForEmptyOnCardMonth() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard("");
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидный 13 месяц")
    void buyTourForThirteenOnCardMonth() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard("13");
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckWrongInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидный нулевой месяц")
    void buyTourForZeroOnCardMonth() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard("0");
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидный прошедший месяц текущего года")
    void buyTourForOldOnCardMonth() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(-1));
        actionsPages.setYearCard(getYearCardInfo(0));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckExpiredInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные два ноля в месяц")
    void buyTourForDoubleZeroOnCardMonth() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard("00");
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }
}