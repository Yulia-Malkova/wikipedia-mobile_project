package guru.qa.tests;

import guru.qa.pages.ArticlePage;
import guru.qa.pages.MainPage;
import guru.qa.pages.OnboardingPage;
import guru.qa.pages.SearchResultPage;
import guru.qa.utils.DataExtractor;
import guru.qa.utils.Variables;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    OnboardingPage onboardingPage = new OnboardingPage();
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ArticlePage articlePage = new ArticlePage();
    Variables variables = new Variables();
    DataExtractor dataExtractor = new DataExtractor();

    @Test
    @DisplayName("Поиск выдает релевантные результаты")
    @Tag("remote")
    @Tag("local")
    @Feature("Поиск")
    @Owner("jmalkova")
    void successfulSearchTest() {
        step("Переходим в строку поиска и вводим релевантное значение", () -> {
            mainPage
                    .clickOnSearchPlaceholder()
                    .enterValueForSearch(variables.randomSearchValue);
        });

        step("Проверяем, что походящие статьи отображаются в списке", () ->
                searchResultPage
                        .checkSearchResult());
    }

    @Test
    @DisplayName("Переход на страницу статьи через поиск")
    @Tag("local")
    @Feature("Поиск")
    @Owner("jmalkova")
    void articleOpeningTest() {
        step("Переходим в строку поиска и вводим релевантное значение", () -> {
            onboardingPage
                    .clickOnSkipButton();
            mainPage
                    .clickOnSearchPlaceholder()
                    .enterValueForSearch(variables.randomSearchValue);
        });

        step("Кликаем на первую статью из списка", () ->
                searchResultPage
                        .openArticle(dataExtractor));
        step("Проверяем, что статья открылась и содержит верную информацию", () ->
                articlePage
                        .checkArticlePage(dataExtractor));
    }

    @Test
    @DisplayName("Ошибка открытия статьи при удаленном запуске приложения")
    @Feature("Поиск")
    @Owner("jmalkova")
    @Tag("remote")
    void errorWhenOpeningArticleTest() {
        step("Переходим в строку поиска и вводим релевантное значение", () -> {
            onboardingPage
                    .clickOnSkipButton();
            mainPage
                    .clickOnSearchPlaceholder()
                    .enterValueForSearch(variables.randomSearchValue);
        });

        step("Кликаем на первую статью из списка", () ->
                searchResultPage
                        .openArticle(dataExtractor));

        step("Проверяем сообщение об ошибке", () ->
                articlePage
                        .checkErrorMessage());
    }
}
