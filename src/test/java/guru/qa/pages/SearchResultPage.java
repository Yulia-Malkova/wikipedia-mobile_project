package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.utils.DataExtractor;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;


public class SearchResultPage {
    private SelenideElement
            navigateBackButton = $(accessibilityId("Navigate up"));
    private ElementsCollection
            resultName = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    public void checkSearchResult() {
        resultName.shouldHave(sizeGreaterThan(0));
    }

    public void openArticle(DataExtractor dataExtractor) {
        dataExtractor.setArticleName(resultName.first().getText());
        resultName.first().click();
    }

    public void returnToTheMainPage() {
        navigateBackButton.click();
    }
}
