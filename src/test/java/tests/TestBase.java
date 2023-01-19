package tests;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

public class TestBase {
    RegistrationPage steps = new RegistrationPage();

    @BeforeAll
    static void BeforeAll() {
        String[] browserTypeVersion = System.getProperty("browser", "chrome 100").split("\\s+");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        Configuration.timeout = 10000;
        Configuration.remote = "https://" +
                System.getProperty("login", "user1") +
                ":" +
                System.getProperty("password", "1234") +
                "@" +
                System.getProperty("remoteWebDriverUrl", "selenoid.autotests.cloud") +
                "/wd/hub";
        Configuration.browser = browserTypeVersion[0];
        Configuration.browserVersion = browserTypeVersion[1];

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void BeforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
