package test;

import actions.ActionsPages;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static data.DataHelper.*;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class CredTurTestCvcCod {
    ActionsPages actionsPages;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        actionsPages = new ActionsPages();
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные текстовые значения cvc/cvv")
    void buyTourCredForTextOnCardCvcCod() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getTextCardInfo(3));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные символьные значения cvc/cvv")
    void buyTourCredForSymbolOnCardCvcCod() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getSymbolCardInfo(3));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные знаки в значения cvc/cvv")
    void buyTourCredForSignOnCardCvcCod() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные пустые значения cvc/cvv")
    void buyTourCredForEmptyOnCardCvcCod() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard("");
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидную одну цифру в значения cvc/cvv")
    void buyTourCredForCyrillicOnCardCvcCod() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getRandNumbCardInfo(1));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные большее значения cvc/cvv")
    void buyTourCredForLongOnCardCvcCod() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getRandNumbCardInfo(4));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидный пробел в значения cvc/cvv")
    void buyTourCredForSpaceOnCardCvcCod() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(" ");
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }
}