package page_object.people_sovkombank;

import base.BasePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PeopleSovcombankMainPage extends BasePage{

    public static final String PEOPLE_SOVCOMBANK_MAIN_PAGE_URL = "https://people.sovcombank.ru/";

    public static SelenideElement VACANCIES_BUTTON = $x("//div[@class = 'header-contacts d-none d-md-flex order-2 ml-8']//button"),
        CHECK_POP_UP = $x("//button[contains(@class, 'button close-btn v-')]//img"),
        CLOSE_POP_UP = $x("//button[contains(@class, 'button close-btn v-')]");

    public PeopleSovcombankMainPage(String url){
        Selenide.open(url);
    }
}
