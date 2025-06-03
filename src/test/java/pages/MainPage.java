package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.Language;
import io.qameta.allure.Step;


import java.time.Duration;
import java.util.List;
import java.util.Map;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final String pageUrl = "https://freedom-travel.kz/";
    private final String russianLanguage = "Русский";
    private final String moscowCity = "Москва";
    private final String bookingSearchText = "Искать жилье на Booking.com";
    private final SelenideElement seccessButton = $("[type='button']");
    private final SelenideElement freedomLogoFooter = $("figure[aria-label*='Freedom Travel']");
    private final SelenideElement moveFromElement = $("[placeholder='Откуда']");
    private final SelenideElement moveToElement = $("[placeholder='Куда']");
    private final ElementsCollection banners = $$("ul.grid.grid-cols-4 > li");
    private final String[] expectedTitles = {
            "Ищите варианты с поиском «Куда угодно»",
            "Гарантия возврата 90% от стоимости билета",
            "Бонусы за каждую покупку",
            "Оплата через Apple pay и Google pay"
    };
    private final Map<String, String> footerLinks = Map.of(
            "/about", "О компании",
            "/agreement", "Публичная оферта",
            "/security", "Безопасность",
            "https://special.aviata.kz/job", "Вакансии",
            "/contacts", "Контакты"
    );

    SelenideElement banner = $(withText("Хорошо!"));

    public MainPage preconditions(){
        openPage();
        bannerShouldBeAppear();
        return this;
    }

    @Step("Открываем главную страницу {pageUrl}")
    public MainPage openPage(){
        open(pageUrl);
        return this;
    }

    @Step("Проверяем, что появился всплывающий баннер")
    public MainPage bannerShouldBeAppear() {
        if (banner.isDisplayed()) {
            SelenideElement okButton = $(".popup-banner .ui-btn");
            okButton.shouldBe(visible).shouldHave(Condition.exactText("Хорошо!")).click();
        }
        return this;
    }




    @Step("Убираем всплывающий баннер")
    public MainPage removeBanner(){
        $(".ui-btn").shouldHave(Condition.text("Хорошо!")).click();
        return this;
    }

    @Step("Кликаем на смену языка")
    public MainPage languageClick(){
        seccessButton.$(withText(russianLanguage)).click();
        return this;
    }

    @Step("Выбираем откуда мы отправляемся")
    public MainPage moveFrom(){
        moveFromElement.setValue("Алматы");
        $$("div[tabindex='0']").findBy(text("Алматы")).click();
        return this;
    }

    @Step("Выбираем куда мы отправляемся")
    public MainPage moveTo(){
        moveToElement.setValue(moscowCity);
        $$("div[tabindex='0']").findBy(text(moscowCity)).click();
        return this;
    }

    @Step("Нажимаем на кнопку Найти")
    public MainPage searchButtonClick(){
        $(".search-form__btn").click();
        return this;
    }

    @Step("Деактивация чекбокса  Искать жилье на Booking.com")
    public MainPage deactivateCheckboksBooking(){
        $(withText(bookingSearchText)).click();
        return this;
    }

    @Step("Проверка результат поиска")
    public MainPage searchTestResult(){
        $$("div[data-component='offer']").get(0).shouldBe(visible, Duration.ofSeconds(20));
        $$("div[data-component='offer']").shouldBe(CollectionCondition.sizeGreaterThan(10));
        return this;
    }

    @Step("Кликаем на выбор языка")
    public MainPage clickLanguage(){
        $("nav.group.relative span").shouldHave(text("Русский")).click();
        return this;
    }


    @Step("проверяем название кнопок на {language.description} языке")
    public MainPage checkButtonsLanguage(Language language, List<String> list){
        $$("nav.absolute button").findBy(text(language.description)).click();

        for (String expected : list) {
            $$("nav.flex.space-x-10 a").findBy(text(expected)).shouldBe(visible);
        }
        return this;
    }


    @Step("Проверяем наличие информационного блока с баннерами")
    public MainPage checkInfoBlockWithBunners(){
        $("h2.text-2xl.font-bold")
                .shouldBe(visible, Duration.ofSeconds(10))
                .shouldHave(text("Почему авиабилеты лучше покупать на Freedom Travel"));
        return this;
    }

    @Step("Проверка текста на баннерах на русском языке")
    public MainPage checkBannersContent() {

        banners.shouldHave(CollectionCondition.size(4));
        for (int i = 0; i < expectedTitles.length; i++) {
            banners.get(i).shouldHave(text(expectedTitles[i])).shouldBe(visible);
        }
        return this;
    }

    @Step("Клик по кнопке куда угодно с Главной страницы")
    public MainPage anywhereButtonClick(){
        $(withText("Куда угодно")).click();
        return this;
    }

    @Step("Проверяем, что элемент 'Бюджет' отображается")
    public MainPage checkBudgetButtom(){
        $x("//p[text()='Бюджет']").shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что элемент 'Казахстан' отображается")
    public MainPage checkH2TextSearch(){
        $("h2.text-lg.font-bold").shouldHave(text("Казахстан"));
        return this;
    }

    @Step("Проверка кнопки со стоимостью билета")
    public MainPage checkPriceButton(){
        $("button:has(span:text('Найти от'))").shouldBe(visible);
        return this;
    }


    @Step("Проверяем наличие логотипа компании в футере")
    public MainPage checkFooterLogoElement() {
        freedomLogoFooter.scrollIntoView(true).shouldBe(visible);
        return this;
    }

    @Step("Проверяем что элемент {href} соответствует {linkText} в футере")
    public MainPage checkFooterElements() {
        footerLinks.forEach((href, linkText) -> {
            SelenideElement link = $("a[href='" + href + "']");
            link.shouldBe(Condition.visible)
                    .shouldHave(Condition.text(linkText));
        });
        return this;
    }

}
