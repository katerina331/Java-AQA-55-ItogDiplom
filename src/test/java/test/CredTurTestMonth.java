package test;

import page.DayTripBuyPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static data.DataHelper.*;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class CredTurTestMonth {
    DayTripBuyPage dayTripBuyPage;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        dayTripBuyPage = new DayTripBuyPage();
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные текстовые значения месяца")
    void buyTourCredForTextOnCardMonth() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getTextCardInfo(2));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные символьные значения месяца")
    void buyTourCredForSymbolOnCardMonth() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getSymbolCardInfo(2));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные знаки в значения месяца")
    void buyTourCredForSignOnCardMonth() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getSingCardInfo(2));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные пустые значения месяца")
    void buyTourCredForEmptyOnCardMonth() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard("");
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидный 13 месяц")
    void buyTourCredForThirteenOnCardMonth() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard("13");
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckWrongInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидный нулевой месяц")
    void buyTourCredForZeroOnCardMonth() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard("0");
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидный прошедший месяц текущего года")
    void buyTourCredForOldOnCardMonth() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(-1));
        dayTripBuyPage.setYearCard(getYearCardInfo(0));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckExpiredInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не два ноля в месяц")
    void buyTourCredForDoubleZeroOnCardMonth() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard("0");
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }
}