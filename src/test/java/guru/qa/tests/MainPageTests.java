package guru.qa.tests;

import guru.qa.pages.ArticlePage;
import guru.qa.pages.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    ArticlePage articlePage = new ArticlePage();

    @Test
    @DisplayName("In the news секция присутствует на главной странице")
    @Feature("Отображение главной страницы")
    @Owner("jmalkova")
    @Tag("remote")
    void inTheNewsSectionTest() {
        step("Проверить, что карточка In the News отображается на главной странице", () ->
                mainPage
                        .checkInTheNewsCardPresence());
    }

    @Test
    @DisplayName("Ошибка при открытии статьи через раздел Featured Article")
    @Feature("Отображение главной страницы")
    @Owner("jmalkova")
    @Tag("remote")
    void openingArticleFromFeaturedTest() {
        step("Кликнуть на карточку Featured Article", () ->
                mainPage
                        .clickOnTheFeaturedArticle());
        step("Проверяем сообщение об ошибке", () ->
                articlePage
                        .checkErrorMessage());
    }
}