package test;

import page.DayTripBuyPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static data.DataHelper.*;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class CredTurTestYear {
    DayTripBuyPage dayTripBuyPage;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        dayTripBuyPage = new DayTripBuyPage();
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
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидный нулевой месяц")
    void buyTourCredForDoubleZeroOnCardMonth() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard("0");
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные текстовые значения года")
    void buyTourCredForTextOnCardYear() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getTextCardInfo(2));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные символьные значения года")
    void buyTourCredForSymbolOnCardYear() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getSymbolCardInfo(2));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные знаки в значения года")
    void buyTourCredForSignOnCardYear() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getSingCardInfo(2));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные пустые значения года")
    void buyTourCredForEmptyOnCardYear() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard("");
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные прошедший год")
    void buyTourCredForOldOnCardYear() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(-1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckWrongInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные год больше на 6 лет")
    void buyTourCredForBigOnCardYear() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(7));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckWrongInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные полное значения года")
    void buyTourCredForFullOnCardYear() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard("20" + getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckExpiredInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные нулевое значения года")
    void buyTourCredForZeroOnCardYear() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard("0");
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные с двойным нулем значения года")
    void buyTourCredForDoubleZeroOnCardYear() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard("00");
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickCheckError(getCheckExpiredInfo());
    }
}