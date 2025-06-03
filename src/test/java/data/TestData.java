package data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class TestData {

    public static Stream<Arguments> MainPageChoiceLanguageTest(){

        return Stream.of(
                Arguments.of(Language.RU, List.of("Авиабилеты", "Билеты на поезд", "Отели", "Для бизнеса", "Бонусы", "Блог")),
                Arguments.of(Language.QAZ, List.of("Әуе билеттері", "Пойыз билеттері", "Қонақүйлер", "Бизнес үшін", "Бонустар", "Блог"))

        );
    }
}
