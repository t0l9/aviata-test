package pages;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage {


    @Test
    void openMaintPageTest(){

        open();
        sleep(10000);
    }
}
