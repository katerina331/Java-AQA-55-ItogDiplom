package test;

import org.junit.jupiter.api.*;
import page.DayTripBuyPage;
import page.DayTripPage;
import util.StartTest;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.*;
import static data.SQLHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurBDSQLTest {
    DayTripPage dayTripPage;
    CardInfo cardInfo;

    @BeforeAll
    static void setUpAll() {
        StartTest.setUpAll();
    }

    @AfterAll
    static void tearDownAll() {
        StartTest.tearDownAll();
    }

    @BeforeEach
    @DisplayName("Начальные установки Теста")
    void setup() {
        open("/");
        dayTripPage = new DayTripPage();
    }

    @Test
    @DisplayName("Приобретение тура в приложении оплачивая картой с статусом одобрен и сверка с базой")
    void buyTourForCardApprovedCheckDBTest() {
        int expectedCheck = getNumSQL() + 1;
        cardInfo = getFirstCardInfo();
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseBuy();
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
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseBuy();
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
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseCred();
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
        DayTripBuyPage dayTripBuyPage = dayTripPage.chooseCred();
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