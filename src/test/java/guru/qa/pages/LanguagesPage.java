package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LanguagesPage {
    private SelenideElement
            headerText = $(AppiumBy.id("org.wikipedia.alpha:id/section_header_text"));

    private ElementsCollection
            languageNameElement = $$(AppiumBy.id("org.wikipedia.alpha:id/localized_language_name")),
            addLanguageElement = $$(AppiumBy.id("org.wikipedia.alpha:id/wiki_language_title"));

    String chosenLanguage;

    @Step("Проверяем отображение страницы добавления языков")
    public LanguagesPage checkLanguagePage() {
        headerText.shouldHave(text("Your languages"));
        return this;
    }

    @Step("Кликаем на кнопку добавления языка")
    public LanguagesPage clickAddLanguageButton() {
        addLanguageElement.findBy(text("Add language")).click();
        return this;
    }

    @Step("Проверяем список языков")
    public LanguagesPage checkLanguageList() {
        headerText.shouldHave(text("All languages"));
        languageNameElement.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Добавляем новый язык")
    public LanguagesPage addNewLanguage() {
        chosenLanguage = languageNameElement.get(0).getText();
        languageNameElement.get(0).click();
        return this;
    }

    @Step("Проверяем, что добавленный язык появился в списке")
    public void checkAddedLanguage() {
        addLanguageElement.findBy(text(chosenLanguage)).shouldBe(Condition.visible);
    }
}
