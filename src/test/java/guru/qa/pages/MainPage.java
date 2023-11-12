package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {
    private SelenideElement
            searchPlaceholder = $(accessibilityId("Search Wikipedia")),
            searchInput = $(id("org.wikipedia.alpha:id/search_src_text")),
            savedButton = $(id("org.wikipedia.alpha:id/nav_tab_reading_lists")),
            menuButton = $(id("org.wikipedia.alpha:id/menu_overflow_button")),
            featuredArticle = $(id("org.wikipedia.alpha:id/view_featured_article_card_article_title")),
            settingsButton = $(id("org.wikipedia.alpha:id/explore_overflow_settings"));

    private ElementsCollection
            card = $$(id("org.wikipedia.alpha:id/view_card_header_title"));


    public MainPage clickOnSearchPlaceholder() {
        searchPlaceholder.click();
        return this;
    }

    public void enterValueForSearch(String value) {
        searchInput.sendKeys(value);
    }

    public MainPage clickOnSavedTab() {
        savedButton.click();
        return this;
    }

    public void checkInTheNewsCardPresence() {
        card.findBy(text("In the News")).shouldBe(Condition.visible);
    }

    public void clickOnTheFeaturedArticle() {
        featuredArticle.click();
    }
}
