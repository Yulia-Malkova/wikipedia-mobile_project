package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.drivers.BrowserstackDriver;
import guru.qa.drivers.LocalDriver;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {

    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() {
        if (deviceHost.equals("remote")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        }
        if (deviceHost.equals("local")) {
            Configuration.browser = LocalDriver.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void afterEach() {
        if (deviceHost.equals("remote")) {
            String sessionId = Selenide.sessionId().toString();
            Attach.pageSource();
            closeWebDriver();
            Attach.addVideo(sessionId);
        }
        if (deviceHost.equals("local")) {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            closeWebDriver();
        }
    }
}