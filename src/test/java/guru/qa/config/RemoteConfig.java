package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface RemoteConfig extends Config {

    @Key("appUrl")
    @DefaultValue("bs://sample.app")
    String getApp();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Key("os_version")
    @DefaultValue("10.0")
    String getOsVersion();

}
