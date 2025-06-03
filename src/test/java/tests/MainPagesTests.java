package tests;

import data.Language;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPagesTests extends MainPage{


    MainPage mainPage = new MainPage();


    @Test
    void mainPageSearchTravelTest(){

        mainPage.openPage()
                .bannerShouldBeAppear()
                .removeBanner()
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
    void checkUpMenuButtomsElementsTest(Language language, List<String> list){

        mainPage.openPage()
                .bannerShouldBeAppear()
                .clickLanguage()
                .checkButtonsLanguage(language, list);

    }

}
