package guru.qa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import guru.qa.config.AuthConfig;
import guru.qa.config.RemoteConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        RemoteConfig mobile = ConfigFactory.create(RemoteConfig.class, System.getProperties());
        AuthConfig auth = ConfigFactory.create(AuthConfig.class, System.getProperties());

        MutableCapabilities mutableCapabilities = new MutableCapabilities();

        mutableCapabilities.setCapability("browserstack.user", auth.getUserName());
        mutableCapabilities.setCapability("browserstack.key", auth.getKey());

        mutableCapabilities.setCapability("app", mobile.getApp());
        mutableCapabilities.setCapability("device", mobile.getDevice());
        mutableCapabilities.setCapability("os_version", mobile.getOsVersion());

        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        try {
            return new RemoteWebDriver(
                    new URL(auth.getRemoteUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
