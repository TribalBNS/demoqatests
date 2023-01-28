package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfig {
    private final WebConfig webConfig;

    public ProjectConfig(WebConfig webConfig) {
        this.webConfig = webConfig;
    }
    public void webConfig() {
        Configuration.browser = webConfig.getBrowser();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.timeout = webConfig.getTimeout();

        if (webConfig.isRemote()) {
            Configuration.remote = webConfig.getSelenoidUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
    public String getVideoUrl(){
        return webConfig.getVideoUrl();
    }
    public String getVideoFormat(){
        return webConfig.getVideoFormat();
    }
}
