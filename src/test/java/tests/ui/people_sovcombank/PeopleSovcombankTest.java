package tests.ui.people_sovcombank;

import base.BasePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page_object.people_sovkombank.PeopleSovcombankMainPage;
import page_object.people_sovkombank.PeopleSovcombankVacanciesPage;


import static page_object.people_sovkombank.PeopleSovcombankMainPage.*;
import static page_object.people_sovkombank.PeopleSovcombankVacanciesPage.*;
import static ui_helpers.PeopleSovcombank.PeopleSovcombankAsserts.checkTextContains;
import static ui_helpers.PeopleSovcombank.PeopleSovcombankSteps.*;

public class PeopleSovcombankTest extends BasePage {

    private static PeopleSovcombankMainPage peopleSovcombankMainPage;
    private static PeopleSovcombankVacanciesPage peopleSovcombankVacanciesPage;

    @Test
    @DisplayName("Проверка отображения названия города в списке вакансий при поиске по городу и компании")
    public void CheckingCityInVacanciesList(){
        peopleSovcombankMainPage = new PeopleSovcombankMainPage(PEOPLE_SOVCOMBANK_MAIN_PAGE_URL);
        peopleSovcombankVacanciesPage = new PeopleSovcombankVacanciesPage(VACANCIES_BUTTON);
        closePopUpIfExist();
        peopleSovcombankVacanciesPage.selectCity();
        peopleSovcombankVacanciesPage.selectCompany();
        checkTextContains(convertElementsCollectionToArrayList(VACANCIES_SPAN_COLLECTION), "Москва", "Вся Россия") ;

    }
}
