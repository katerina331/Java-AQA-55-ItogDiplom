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
public class BuyTurTestOwner {
    ActionsPages actionsPages;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        actionsPages = new ActionsPages();
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные числовые значения владельца")
    void buyTourForNumericalOnCardOwner() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getRandNumbCardInfo(15));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные символьные значения владельца")
    void buyTourForSymbolOnCardOwner() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getSymbolCardInfo(15));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные знаки в значения владельца")
    void buyTourForSignOnCardOwner() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getSingCardInfo(15));
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные пустые значения владельца")
    void buyTourForEmptyOnCardOwner() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard("");
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckRequiredInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные кириллические значения владельца")
    void buyTourForCyrillicOnCardOwner() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCyrillicCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные длинное значения владельца")
    void buyTourForLongOnCardOwner() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserLongCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные только имя значения владельца")
    void buyTourForNameOnlyOnCardOwner() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserNameCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные только фамилию значения владельца")
    void buyTourForSurnameOnlyOnCardOwner() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserSurnameCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные значения имени с пробелом в начале")
    void buyTourForSpaceHomeOnCardOwner() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(" " + getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные значения имени с пробелом в конце")
    void buyTourForSpaceEndOnCardOwner() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo() + " ");
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckNoValidInfo());
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой вводя не валидные значения имени с двойным пробелом")
    void buyTourForDoubleSpaceOnCardOwner() {
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(getFirstCardInfo().getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserNameCardInfo() + "  " + getUserSurnameCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickCheckError(getCheckRequiredInfo());
    }
}