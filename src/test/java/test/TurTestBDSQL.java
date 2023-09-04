package test;

import page.DayTripBuyPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import util.ScreenShooterReportPortalExtension;

import static data.DataHelper.*;
import static data.SQLHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ScreenShooterReportPortalExtension.class)
public class TurTestBDSQL {
    DayTripBuyPage dayTripBuyPage;
    CardInfo cardInfo;

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        dayTripBuyPage = new DayTripBuyPage();
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой с статусом одобрен и сверка с базой")
    void buyTourForCardApprovedCheckDBTest() {
        int expectedCheck = getNumSQL() + 1;
        cardInfo = getFirstCardInfo();
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard(cardInfo.getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickSendCheckMess(getCheckGoodInfo());
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
        dayTripBuyPage.chooseBuy();
        dayTripBuyPage.setNumberCard(cardInfo.getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickSendCheckMess(getCheckErrorInfo());
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
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(cardInfo.getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickSendCheckMess(getCheckGoodInfo());
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
        dayTripBuyPage.chooseCred();
        dayTripBuyPage.setNumberCard(cardInfo.getNumberCard());
        dayTripBuyPage.setMonthCard(getMonthsCardInfo(1));
        dayTripBuyPage.setYearCard(getYearCardInfo(1));
        dayTripBuyPage.setUserCard(getUserCardInfo());
        dayTripBuyPage.setCvcCodCard(getCvcCodCardInfo());
        dayTripBuyPage.clickSendCheckMess(getCheckErrorInfo());
        int actualCheck = getNumSQL();
        assertEquals(expectedCheck, actualCheck);
        String expectedStatus = cardInfo.getStatusCard();
        String actualStatus = getStatusCreditCad();
        assertEquals(expectedStatus, actualStatus);
    }
}