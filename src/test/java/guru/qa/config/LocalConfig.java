package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface LocalConfig extends Config {
    @Key("platformVersion")
    String getPlatformVersion();

    @Key("deviceName")
    String getDeviceName();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}