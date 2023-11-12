package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})
public interface AuthConfig extends Config {

    @Key("userName")
    @DefaultValue("bsuser_3OxLng")
    String getUserName();

    @Key("key")
    @DefaultValue("v6xodqfnVqbu5YouZhC1")
    String getKey();

    @Key("remoteUrl")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String getRemoteUrl();
}
