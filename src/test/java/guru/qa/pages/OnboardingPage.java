package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingPage {
    private SelenideElement
            primaryTextView = $(id("org.wikipedia.alpha:id/primaryTextView")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
            contunueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            rejectButon = $(id("org.wikipedia.alpha:id/rejectButton")),
            acceptButton = $(id("org.wikipedia.alpha:id/acceptButton")),
            languageAddingButton = $(id("org.wikipedia.alpha:id/addLanguageButton"));

    @Step("Проверяем информацию на первом экране")
    public OnboardingPage checkInformationOnTheFirstScreen() {
        primaryTextView.shouldHave(Condition.text("The Free Encyclopedia …in over 300 languages"));
        skipButton.shouldHave(Condition.text("Skip"));
        contunueButton.shouldHave(Condition.text("Continue"));
        return this;
    }

    @Step("Проверяем информацию на втором экране")
    public OnboardingPage checkInformationOnTheSecondScreen() {
        primaryTextView.shouldHave(Condition.text("New ways to explore"));
        skipButton.shouldHave(Condition.text("Skip"));
        contunueButton.shouldHave(Condition.text("Continue"));
        return this;
    }

    @Step("Проверяем информацию на третьем экране")
    public OnboardingPage checkInformationOnTheThirdScreen() {
        primaryTextView.shouldHave(Condition.text("Reading lists with sync"));
        skipButton.shouldHave(Condition.text("Skip"));
        contunueButton.shouldHave(Condition.text("Continue"));
        return this;
    }

    @Step("Проверяем информацию на четвертом экране")
    public void checkInformationOnTheFourthScreen() {
        primaryTextView.shouldHave(Condition.text("Send anonymous data"));
        rejectButon.shouldHave(Condition.text("Reject"));
        acceptButton.shouldHave(Condition.text("Accept"));
        contunueButton.shouldNotBe(Condition.visible);
        skipButton.shouldNotBe(Condition.visible);
    }

    @Step("Кликаем на кнопку Continue")
    public OnboardingPage clickOnContinueButton() {
        contunueButton.click();
        return this;
    }

    @Step("Кликаем на кнопку Add or edit languages")
    public void clickOnAddingLanguageButton() {
        languageAddingButton.click();
    }

    @Step("Кликаем на кнопку Skip")
    public OnboardingPage clickOnSkipButton() {
        skipButton.click();
        return this;
    }
}
