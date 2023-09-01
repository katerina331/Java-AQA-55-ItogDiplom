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
public class BuyTurTestCvcCod {
    ActionsPages actionsPages;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        actionsPages = new ActionsPages();
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные текстовые значения cvc/cvv")
    void buyTourForTextOnCardCvcCod() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getTextCardInfo(3));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные символьные значения cvc/cvv")
    void buyTourForSymbolOnCardCvcCod() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getSymbolCardInfo(3));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные знаки в значения cvc/cvv")
    void buyTourForSignOnCardCvcCod() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getSingCardInfo(3));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные пустые значения cvc/cvv")
    void buyTourForEmptyOnCardCvcCod() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard("");
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидную одну цифру в значения cvc/cvv")
    void buyTourForCyrillicOnCardCvcCod() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getRandNumbCardInfo(1));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные большее значения cvc/cvv")
    void buyTourForLongOnCardCvcCod() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getRandNumbCardInfo(4));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидный пробел в значения cvc/cvv")
    void buyTourForSpaceOnCardCvcCod() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(" ");
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }
}