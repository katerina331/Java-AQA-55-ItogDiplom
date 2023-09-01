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
public class TurTestBDSQL {
    ActionsPages actionsPages;
    CardInfo cardInfo;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        actionsPages = new ActionsPages();
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой с статусом одобрен и сверка с базой")
    void buyTourForCardApprovedCheckDBTest() {
        int expectedCheck = getNumSQL() + 1;
        cardInfo = getFirstCardInfo();
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(cardInfo.getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickSendCheckMess(getCheckGoodInfo());
        int actualCheck = getNumSQL();
        assertEquals(expectedCheck, actualCheck);
        String expectedStatus = cardInfo.getStatusCard();
        String actualStatus = getStatusPaymentCad();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой с статусом отклонен и сверка с базой")
    void buyTourForCardDeclinedCheckDBTest() {
        int expectedCheck = getNumSQL() + 1;
        cardInfo = getSecondCardInfo();
        actionsPages.chooseBuy();
        actionsPages.setNumberCard(cardInfo.getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickSendCheckMess(getCheckErrorInfo());
        int actualCheck = getNumSQL();
        assertEquals(expectedCheck, actualCheck);
        String expectedStatus = cardInfo.getStatusCard();
        String actualStatus = getStatusPaymentCad();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты с статусом одобрен и сверка с базой")
    void buyTourCredCardApprovedCheckDBTest() {
        int expectedCheck = getNumSQL() + 1;
        cardInfo = getFirstCardInfo();
        actionsPages.chooseCred();
        actionsPages.setNumberCard(cardInfo.getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickSendCheckMess(getCheckGoodInfo());
        int actualCheck = getNumSQL();
        assertEquals(expectedCheck, actualCheck);
        String expectedStatus = cardInfo.getStatusCard();
        String actualStatus = getStatusCreditCad();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    @DisplayName("Приобретение тура в приложении в кредит по данным карты с статусом отклонен и сверка с базой")
    void buyTourCredCardDeclinedCheckDBTest() {
        int expectedCheck = getNumSQL() + 1;
        cardInfo = getSecondCardInfo();
        actionsPages.chooseCred();
        actionsPages.setNumberCard(cardInfo.getNumberCard());
        actionsPages.setMonthCard(getMonthsCardInfo(1));
        actionsPages.setYearCard(getYearCardInfo(1));
        actionsPages.setUserCard(getUserCardInfo());
        actionsPages.setCvcCodCard(getCvcCodCardInfo());
        actionsPages.clickSendCheckMess(getCheckErrorInfo());
        int actualCheck = getNumSQL();
        assertEquals(expectedCheck, actualCheck);
        String expectedStatus = cardInfo.getStatusCard();
        String actualStatus = getStatusCreditCad();
        assertEquals(expectedStatus, actualStatus);
    }
}