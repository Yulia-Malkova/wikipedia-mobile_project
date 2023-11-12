package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SavedPage {
    private SelenideElement
            savedFolder = $(id("org.wikipedia.alpha:id/item_title")),
            folder = $(id("org.wikipedia.alpha:id/item_reading_list_statistical_description"));

    public void checkFolderContent() {
        folder.shouldHave(text("1 article"));
    }
}
