package guru.qa.tests;

import guru.qa.pages.*;
import guru.qa.utils.DataExtractor;
import guru.qa.utils.Variables;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ArticleActionsTests extends TestBase {

    OnboardingPage onboardingPage = new OnboardingPage();
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ArticlePage articlePage = new ArticlePage();
    SavedPage savedPage = new SavedPage();
    Variables variables = new Variables();
    DataExtractor dataExtractor = new DataExtractor();

    @Test
    @DisplayName("Добавление статьи в Сохраненное")
    @Tag("local")
    @Feature("Действия со статьями")
    @Owner("jmalkova")
    void articleSavingTest() {
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

        step("Кликаем на кнопку Сохранить", () ->
                articlePage
                        .clickOnSaveButton());

        step("Возвращаемся на главную страницу", () -> {
            articlePage
                    .returnToThePreviousPage();
            searchResultPage
                    .returnToTheMainPage();
        });

        step("Переходим в таб Сохраненное", () ->
                mainPage
                        .clickOnSavedTab());

        step("Переходим в папку со статьями и проверяем наличие добавленной статьи", () ->
                savedPage
                        .checkFolderContent());
    }
}
