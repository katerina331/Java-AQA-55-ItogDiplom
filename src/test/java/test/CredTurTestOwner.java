package test;

import actions.ActionsPages;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static data.DataHelper.*;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class CredTurTestOwner {
    ActionsPages actionsPages;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        actionsPages = new ActionsPages();
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные числовые значения владельца")
    void buyTourCredForNumericalOnCardOwner() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.setUserCard(getRandNumbCardInfo(15));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные символьные значения владельца")
    void buyTourCredForSymbolOnCardOwner() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.setUserCard(getSymbolCardInfo(15));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные знаки в значения владельца")
    void buyTourCredForSignOnCardOwner() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.setUserCard(getSingCardInfo(15));
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные пустые значения владельца")
    void buyTourCredForEmptyOnCardOwner() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.setUserCard("");
        actionsPages.clickCheckError(getCheckRequiredInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные кириллические значения владельца")
    void buyTourCredForCyrillicOnCardOwner() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.setUserCard(getUserCyrillicCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные длинное значения владельца")
    void buyTourCredForLongOnCardOwner() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.setUserCard(getUserLongCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные только имя значения владельца")
    void buyTourCredForNameOnlyOnCardOwner() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.setUserCard(getUserNameCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные только фамилию значения владельца")
    void buyTourCredForSurnameOnlyOnCardOwner() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.setUserCard(getUserSurnameCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные значения имени с пробелом в начале")
    void buyTourCredForSpaceHomeOnCardOwner() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.setUserCard(" " + getUserCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные значения имени с пробелом в конце")
    void buyTourCredForSpaceEndOnCardOwner() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.setUserCard(getUserCardInfo() + " ");
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты вводя не валидные значения имени с двойным пробелом")
    void buyTourCredForDoubleSpaceOnCardOwner() {
        actionsPages.chooseCred();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.setUserCard(getUserNameCardInfo() + "  " +getUserSurnameCardInfo());
        actionsPages.clickCheckError(getCheckRequiredInfo());
    }
}