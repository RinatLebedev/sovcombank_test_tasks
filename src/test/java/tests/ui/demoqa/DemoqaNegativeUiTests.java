package tests.ui.demoqa;

import base.BasePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page_object.demoqa.DemoqaMainPage;

import java.util.ArrayList;

import static page_object.demoqa.DemoqaMainPage.*;
import static ui_helpers.Demoqa.DemoqaAsserts.checkModalWindowAppeared;
import static ui_helpers.Demoqa.DemoqaAsserts.checkModalWindowNotAppeared;

public class DemoqaNegativeUiTests extends BasePage {

    private DemoqaMainPage demoqaMainPage;

    @Test
    @DisplayName("Валидация поля 'Name'")
    public void nameFieldValidation(){
        demoqaMainPage = new DemoqaMainPage(DEMOQA_URL);

        ArrayList <String> params = new ArrayList<>();
        params.add("ч");
        params.add("h");
        params.add("%");
        params.add("9");

        for (String param: params) {
            demoqaMainPage.fillingFirstNameField(param);
            demoqaMainPage.fillingLastNameField("last_name");
            demoqaMainPage.fillingEmailField("h@mail.com");
            demoqaMainPage.clickToGenderMaleButton();
            demoqaMainPage.fillingMobileField("1234567890");
            demoqaMainPage.clickToDateOfBirthMainField();
            demoqaMainPage.changeMounthInDateOfBirthField(1);
            demoqaMainPage.changeYearInDateOfBirthField("2000");
            demoqaMainPage.changeDateInDateOfBirthField("1", "1");
            demoqaMainPage.clickToSubmitButton();

            checkModalWindowAppeared();

            closeModalWindowButtonClick();
        }
    }

    @Test
    @DisplayName("Валидация поля 'Email'")
    public void emailFieldValidation() {
        demoqaMainPage = new DemoqaMainPage(DEMOQA_URL);

        ArrayList<String> positive_params = new ArrayList<>();
        positive_params.add("h@mail.ru");
        positive_params.add("1@mail.indox");

        for (String param: positive_params) {
            demoqaMainPage.fillingFirstNameField("first_name");
            demoqaMainPage.fillingLastNameField("last_name");
            demoqaMainPage.fillingEmailField(param);
            demoqaMainPage.clickToGenderMaleButton();
            demoqaMainPage.fillingMobileField("1234567890");
            demoqaMainPage.clickToDateOfBirthMainField();
            demoqaMainPage.changeMounthInDateOfBirthField(1);
            demoqaMainPage.changeYearInDateOfBirthField("2000");
            demoqaMainPage.changeDateInDateOfBirthField("1", "1");
            demoqaMainPage.clickToSubmitButton();

            checkModalWindowAppeared();


            closeModalWindowButtonClick();
        }

        ArrayList<String> negative_params = new ArrayList<>();
        negative_params.add("@mail.ru");
        negative_params.add("f@mail.r");
        negative_params.add("h@mail.11");
        negative_params.add("h@mail.%%");
        negative_params.add("h@mail.ру");
        for (String param: negative_params) {
            demoqaMainPage.fillingFirstNameField("first_name");
            demoqaMainPage.fillingLastNameField("last_name");
            demoqaMainPage.fillingEmailField(param);
            demoqaMainPage.clickToGenderMaleButton();
            demoqaMainPage.fillingMobileField("1234567890");
            demoqaMainPage.clickToDateOfBirthMainField();
            demoqaMainPage.changeMounthInDateOfBirthField(1);
            demoqaMainPage.changeYearInDateOfBirthField("2000");
            demoqaMainPage.changeDateInDateOfBirthField("1", "1");
            demoqaMainPage.clickToSubmitButton();

            checkModalWindowNotAppeared();

            EMAIL_XPATH.clear();
        }
    }

    @Test
    @DisplayName("Валидация поля 'Мobile'")
    public void mobileFieldValidation() {
        demoqaMainPage = new DemoqaMainPage(DEMOQA_URL);
        ArrayList<String> positive_params = new ArrayList<>();
        positive_params.add("1234567890");
        for (String param: positive_params) {
            demoqaMainPage.fillingFirstNameField("first_name");
            demoqaMainPage.fillingLastNameField("last_name");
            demoqaMainPage.fillingEmailField("h@mail.com");
            demoqaMainPage.clickToGenderMaleButton();
            demoqaMainPage.fillingMobileField(param);
            demoqaMainPage.clickToDateOfBirthMainField();
            demoqaMainPage.changeMounthInDateOfBirthField(1);
            demoqaMainPage.changeYearInDateOfBirthField("2000");
            demoqaMainPage.changeDateInDateOfBirthField("1", "1");
            demoqaMainPage.clickToSubmitButton();

            checkModalWindowAppeared();

            closeModalWindowButtonClick();
        }

        ArrayList<String> negative_params = new ArrayList<>();
        negative_params.add("123456789");
        negative_params.add("hhhhhhhhhh");
        negative_params.add("##########");
        negative_params.add("зззззззззз");

        for (String param: negative_params) {
            demoqaMainPage.fillingFirstNameField("first_name");
            demoqaMainPage.fillingLastNameField("last_name");
            demoqaMainPage.fillingEmailField("h@mail.com");
            demoqaMainPage.clickToGenderMaleButton();
            demoqaMainPage.fillingMobileField(param);
            demoqaMainPage.clickToDateOfBirthMainField();
            demoqaMainPage.changeMounthInDateOfBirthField(1);
            demoqaMainPage.changeYearInDateOfBirthField("2000");
            demoqaMainPage.changeDateInDateOfBirthField("1", "1");
            demoqaMainPage.clickToSubmitButton();

            checkModalWindowNotAppeared();

            EMAIL_XPATH.clear();
            MOBILE_XPAHT.clear();
        }
    }

    @Test
    @DisplayName("Валидация поля 'Date of Birth'")
    public void dateOfBirthFieldValidation() {
        demoqaMainPage = new DemoqaMainPage(DEMOQA_URL);
        demoqaMainPage.fillingFirstNameField("first_name");
        demoqaMainPage.fillingLastNameField("last_name");
        demoqaMainPage.fillingEmailField("h@mail.com");
        demoqaMainPage.clickToGenderMaleButton();
        demoqaMainPage.fillingMobileField("1234567890");
        demoqaMainPage.clickToDateOfBirthMainField();
        demoqaMainPage.changeMounthInDateOfBirthField(1);
        demoqaMainPage.changeYearInDateOfBirthField("2025");
        demoqaMainPage.changeDateInDateOfBirthField("1", "1");
        demoqaMainPage.clickToSubmitButton();

        checkModalWindowAppeared();
    }
}
