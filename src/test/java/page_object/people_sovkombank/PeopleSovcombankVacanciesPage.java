package page_object.people_sovkombank;

import base.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static page_object.people_sovkombank.PeopleSovcombankMainPage.*;

public class PeopleSovcombankVacanciesPage extends BasePage {

    public static SelenideElement SELECT_CITY = $x("//label[contains(.,'Город')]"),
        CHOOSE_MOSCOW_IN_CITY_COLLECTION = $x("//div[contains(text(),'Москва')]/parent::*"),
        SELECT_COMPANY = $x("//label[contains(.,'Компания')]"),
        CHOOSE_SOVCOMBANK_TECHNOLOGIES_IN_COMPANY_COLLECTION = $x("//div[contains(text(), 'Совкомбанк Технологии')]");

    public static ElementsCollection CITIES_COLLECTION = $$x("//div[@id = 'list-1845']"),
        VACANCIES_SPAN_COLLECTION = $$x("//span[@class= 't2vac']"),
        VACANCIES_HREFS_COLLECTION = $$x("//div[@class= 'section-vacancies full-width']//a");

    public PeopleSovcombankVacanciesPage(SelenideElement path){
        buttonClicker(path);
    }

    public static void selectCity(){
        buttonClicker(SELECT_CITY);
        buttonClicker(CHOOSE_MOSCOW_IN_CITY_COLLECTION);
    }

    public static void selectCompany(){
        buttonClicker(SELECT_COMPANY);
        buttonClicker(CHOOSE_SOVCOMBANK_TECHNOLOGIES_IN_COMPANY_COLLECTION);
    }
}
