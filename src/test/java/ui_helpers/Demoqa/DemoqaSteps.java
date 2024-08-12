package ui_helpers.Demoqa;

import base.BasePage;
import page_object.demoqa.DemoqaMainPage;

import static page_object.demoqa.DemoqaMainPage.DEMOQA_URL;

public class DemoqaSteps extends BasePage {

    private static DemoqaMainPage demoqaMainPage;

    public static void correctFillingAllFields(){
        demoqaMainPage = new DemoqaMainPage(DEMOQA_URL);
        demoqaMainPage.fillingFirstNameField("first_name");
        demoqaMainPage.fillingLastNameField("last_name");
        demoqaMainPage.fillingEmailField("h@mail.com");
        demoqaMainPage.clickToGenderMaleButton();
        demoqaMainPage.fillingMobileField("1234567890");
        demoqaMainPage.clickToDateOfBirthMainField();
        demoqaMainPage.changeMounthInDateOfBirthField(1);
        demoqaMainPage.changeYearInDateOfBirthField("2000");
        demoqaMainPage.changeDateInDateOfBirthField("1", "1");
        demoqaMainPage.fillingSubjectField("Maths");
        demoqaMainPage.clickToSportInHobbiesField();
        demoqaMainPage.uploadPictureToChooseFileField("C:\\Users\\lebed\\IdeaProjects\\sovcombank_test_tasks\\pictures\\first_photo.jpg");
        demoqaMainPage.fillingCurrentAddressField("Time Square 1");
        demoqaMainPage.selectState();
        demoqaMainPage.selectCity();
        demoqaMainPage.clickToSubmitButton();
    }

    public static void correctFillingNecessaryFields(){
        demoqaMainPage = new DemoqaMainPage(DEMOQA_URL);
        demoqaMainPage.fillingFirstNameField("first_name");
        demoqaMainPage.fillingLastNameField("last_name");
        demoqaMainPage.fillingEmailField("h@mail.com");
        demoqaMainPage.clickToGenderMaleButton();
        demoqaMainPage.fillingMobileField("1234567890");
        demoqaMainPage.clickToDateOfBirthMainField();
        demoqaMainPage.changeMounthInDateOfBirthField(1);
        demoqaMainPage.changeYearInDateOfBirthField("2000");
        demoqaMainPage.changeDateInDateOfBirthField("1", "1");
        demoqaMainPage.clickToSubmitButton();
    }
}
