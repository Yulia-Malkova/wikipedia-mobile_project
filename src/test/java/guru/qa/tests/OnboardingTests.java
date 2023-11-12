package guru.qa.tests;

import guru.qa.pages.LanguagesPage;
import guru.qa.pages.OnboardingPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OnboardingTests extends TestBase {
    OnboardingPage onboardingPage = new OnboardingPage();
    LanguagesPage languagesPage = new LanguagesPage();

    @Test
    @DisplayName("Проверка четырех экранов онбоардинга")
    @Tag("local")
    @Feature("Онбоардинг")
    @Owner("jmalkova")
    void onboardingScreenTest() {
        onboardingPage
                .checkInformationOnTheFirstScreen()
                .clickOnContinueButton()
                .checkInformationOnTheSecondScreen()
                .clickOnContinueButton()
                .checkInformationOnTheThirdScreen()
                .clickOnContinueButton()
                .checkInformationOnTheFourthScreen();
    }

    @Test
    @DisplayName("Пользователь может добавить язык через первый экран онбоардинга")
    @Tag("local")
    @Feature("Онбоардинг")
    @Owner("jmalkova")
    void languageAddingTest() {
        onboardingPage
                .clickOnAddingLanguageButton();
        languagesPage
                .checkLanguagePage()
                .clickAddLanguageButton()
                .checkLanguageList()
                .addNewLanguage()
                .checkAddedLanguage();
    }
}

