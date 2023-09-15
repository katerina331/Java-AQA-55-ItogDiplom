package util;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static util.TestProperties.getProperties;

public class StartTest {

    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.headless = true;
        Configuration.baseUrl = getProperties("server.url") + ":" + getProperties("server.port");
        open();
        getWebDriver().manage().window().maximize();
    }

    public static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
}
