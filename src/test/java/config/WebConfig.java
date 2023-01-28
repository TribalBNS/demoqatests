package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties",
        "file:~/${env}.properties",
        "file:./${env}.properties"
})
public interface WebConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("timeout")
    @DefaultValue("10000")
    Long getTimeout();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("selenoidUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getSelenoidUrl();

    @Key("videoUrl")
    @DefaultValue("https://selenoid.autotests.cloud/video/")
    String getVideoUrl();

    @Key("videoFormat")
    @DefaultValue(".mp4")
    String getVideoFormat();
}
