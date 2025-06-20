package tests;

import data.Language;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;

import java.util.List;
import java.util.stream.Stream;


public class MainPagesTests extends TestBase{

    MainPage mainPage = new MainPage();


    @Test
    @Feature("Проверка наличия информационных блоков на главной странице")
    @Story("Проверка баннеров")
    @Owner("Kolyshkin A.S.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Наличие информационных блоков на главной странице")
    @Tags({@Tag("auto"), @Tag("smoke"), @Tag("regression"), @Tag("information")})
    void checkInformationBlockTest(){
        mainPage.openPage()
                .bannerShouldBeAppear()
                .removeBanner()
                .closeModalIfPresent()
                .checkInfoBlockWithBunners()
                .checkBannersContent();

    }

    @Test
    @Feature("Проверка информации в футере главной страницы")
    @Story("Проверка футера")
    @Owner("Kolyshkin A.S.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка отображения логотипа и ссылок")
    @Tags({@Tag("auto"), @Tag("smoke"), @Tag("regression"), @Tag("footer")})
    void checkFooterBlockTest(){
        mainPage.openPage()
                .bannerShouldBeAppear()
                .removeBanner()
                .closeModalIfPresent()
                .checkFooterLogoElement()
                .checkBannersContent()
                .checkFooterElements();
    }


    @Test
    @Feature("Проверка кнопки Куда Угодно с Главной страницы")
    @Story("Проверка кнопок на главной странице")
    @Owner("Kolyshkin A.S.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка кнопки Куда Угодно с Главной страницы")
    @Tags({@Tag("auto"), @Tag("smoke"), @Tag("regression"), @Tag("search")})
    void checkAnywhereButtonFromMainPageTest(){
        mainPage.openPage()
                .bannerShouldBeAppear()
                .removeBanner()
                .closeModalIfPresent()
                .anywhereButtonClick()
                .checkBudgetButtom()
                .checkH2TextSearch();

    }

    @Test
    @Feature("Проверка поиска авиаперелета на главной странице")
    @Story("Поиск авиаперелетов")
    @Owner("Kolyshkin A.S.")
    @Disabled("Тест валится при проверке на робота")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Поиск авиаперелетов с главной страницы")
    @Tags({@Tag("auto"), @Tag("smoke"), @Tag("regression"), @Tag("search")})
    void mainPageSearchTravelTest(){

        mainPage.openPage()
                .bannerShouldBeAppear()
                .removeBanner()
                .closeModalIfPresent()
                .moveFrom()
                .moveTo()
                .deactivateCheckboksBooking()
                .searchButtonClick()
                .searchTestResult();
    }


    public static Stream<Arguments> checkUpMenuButtomsElementsTest(){

        return Stream.of(
                Arguments.of(Language.RU, List.of("Авиабилеты", "Билеты на поезд", "Отели", "Для бизнеса", "Бонусы", "Блог")),
                Arguments.of(Language.QAZ, List.of("Әуе билеттері", "Пойыз билеттері", "Қонақүйлер", "Бизнес үшін", "Бонустар", "Блог"))

        );
    }

    @ParameterizedTest
    @MethodSource
    @Tags({@Tag("auto"), @Tag("smoke"), @Tag("regression"), @Tag("localization")})
    @Feature("Проверка заголовков Меню в хедере главной страницы на 2 языках.")
    @Story("Хэдер")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Kolyshkin A.S.")
    void checkUpMenuButtomsElementsTest(Language language, List<String> list){

        mainPage.openPage()
                .bannerShouldBeAppear()
                .removeBanner()
                .closeModalIfPresent()
                .clickLanguage()
                .checkButtonsLanguage(language, list);
    }

}
