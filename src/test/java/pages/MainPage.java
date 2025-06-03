package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.Language;
import io.qameta.allure.Step;


import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {


    @Step("Открываем главную страницу")
    public MainPage openPage(){
        open("https://freedom-travel.kz/");
        return this;
    }


    @Step("Проверяем, что появился всплывающий баннер")
    public MainPage bannerShouldBeAppear() {
        SelenideElement banner = $(withText("Хорошо!"));
        if (banner.exists()) {
            banner.shouldBe(visible);
            $(".ui-btn").shouldHave(Condition.text("Хорошо!")).click();
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
        $("[type='button']").$(withText("Русский")).click();
        return this;
    }

    @Step("Выбираем откуда мы отправляемся")
    public MainPage moveFrom(){
        $("[placeholder='Откуда']").setValue("Алматы");
        $$("div[tabindex='0']").findBy(text("Алматы")).click();
        return this;
    }

    @Step("Выбираем куда мы отправляемся")
    public MainPage moveTo(){
        $("[placeholder='Куда']").setValue("Москва");
        $$("div[tabindex='0']").findBy(text("Москва")).click();
        return this;
    }

    @Step("Нажимаем на кнопку Найти")
    public MainPage searchButtonClick(){
        $(".search-form__btn").click();
        return this;
    }

    @Step("Деактивация чекбокса  Искать жилье на Booking.com")
    public MainPage deactivateCheckboksBooking(){
        $(withText("Искать жилье на Booking.com")).click();
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


}
