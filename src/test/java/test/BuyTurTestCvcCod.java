package test;

import page.DayTripBuyPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static data.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class BuyTurTestCvcCod {
    DayTripBuyPage dayTripBuyPage;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        dayTripBuyPage = new DayTripBuyPage();
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные текстовые значения cvc/cvv")
    void buyTourForTextOnCardCvcCod() {
        dayTripBuyPage.chooseBuy();
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
        dayTripBuyPage.chooseBuy();
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
        dayTripBuyPage.chooseBuy();
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
        dayTripBuyPage.chooseBuy();
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
        dayTripBuyPage.chooseBuy();
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
        dayTripBuyPage.chooseBuy();
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
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard(getFirstCardInfo().getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(" ");
        dayTripBuyPage.clickCheckError(getCheckNoValidInfo());
    }
}