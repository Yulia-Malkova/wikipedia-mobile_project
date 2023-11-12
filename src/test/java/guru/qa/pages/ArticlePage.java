package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.utils.DataExtractor;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.className;

public class ArticlePage {

    private SelenideElement
            saveButton = $(id("org.wikipedia.alpha:id/page_save")),
            navigateBackButton = $(accessibilityId("Navigate up")),
            errorText = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));

    private ElementsCollection
            articleTitle = $$(className("android.view.View"));

    public void checkArticlePage(DataExtractor dataExtractor) {
        articleTitle.findBy(text(dataExtractor.getArticleName())).should(exist);
    }

    public void checkErrorMessage() {
        errorText.shouldHave(text("An error occurred"));
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void returnToThePreviousPage() {
        navigateBackButton.click();
    }
}
