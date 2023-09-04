package test;

import page.DayTripBuyPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static data.DataHelper.*;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class CredTurTestOwner {
    DayTripBuyPage dayTripBuyPage;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        dayTripBuyPage = new DayTripBuyPage();
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные числовые значения владельца")
    void buyTourCredForNumericalOnCardOwner() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.setUserCard(getRandNumbCardInfo(15));
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные символьные значения владельца")
    void buyTourCredForSymbolOnCardOwner() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.setUserCard(getSymbolCardInfo(15));
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные знаки в значения владельца")
    void buyTourCredForSignOnCardOwner() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.setUserCard(getSingCardInfo(15));
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные пустые значения владельца")
    void buyTourCredForEmptyOnCardOwner() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.setUserCard("");
        dayTripBuyPage.clickCheckError(getCheckRequiredInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные кириллические значения владельца")
    void buyTourCredForCyrillicOnCardOwner() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.setUserCard(getUserCyrillicCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные длинное значения владельца")
    void buyTourCredForLongOnCardOwner() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.setUserCard(getUserLongCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные только имя значения владельца")
    void buyTourCredForNameOnlyOnCardOwner() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.setUserCard(getUserNameCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные только фамилию значения владельца")
    void buyTourCredForSurnameOnlyOnCardOwner() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.setUserCard(getUserSurnameCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные значения имени с пробелом в начале")
    void buyTourCredForSpaceHomeOnCardOwner() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.setUserCard(" " + getUserCardInfo());
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные значения имени с пробелом в конце")
    void buyTourCredForSpaceEndOnCardOwner() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.setUserCard(getUserCardInfo() + " ");
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные значения имени с двойным пробелом")
    void buyTourCredForDoubleSpaceOnCardOwner() {
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.setUserCard(getUserNameCardInfo() + "  " +getUserSurnameCardInfo());
        dayTripBuyPage.clickCheckError(getCheckRequiredInfo());
    }
}