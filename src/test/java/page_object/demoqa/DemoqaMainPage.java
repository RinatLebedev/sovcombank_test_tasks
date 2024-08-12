package page_object.demoqa;
import base.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DemoqaMainPage extends BasePage {

    public static final String DEMOQA_URL = "https://demoqa.com/automation-practice-form";

    public static SelenideElement FIRST_NAME_XPATH = $x("//input[@placeholder = 'First Name']"),
        LAST_NAME_XPATH = $x("//input[@placeholder = 'Last Name']"),
        EMAIL_XPATH = $x("//input[@placeholder = 'name@example.com']"),
        GENDER_MALE_XPATH = $x("//label[@for = 'gender-radio-1']"),
        MOBILE_XPAHT = $x("//input[@placeholder = 'Mobile Number']"),
        DATE_OF_BIRTH_MAIN_XPATH = $x("//input[@id= 'dateOfBirthInput']"),
        DATE_OF_BIRTH_CHANGE_MOUNTH = $x("//select[@class= 'react-datepicker__month-select']"),
        DATE_OF_BIRTH_CHANGE_YEAR = $x("//select[@class= 'react-datepicker__year-select']"),
        SUBJECTS_XPATH = $x("//input[@id = 'subjectsInput']"),
        SPORTS_CHECKBOX_XPATH = $x("//label[@for= 'hobbies-checkbox-1']"),
        PICTURE_XPATH = $x("//input[@id= 'uploadPicture']"),
        CURRENT_ADDRESS_XPATH = $x("//textarea[@id= 'currentAddress']"),
        SELECT_STATE_XPATH = $x("//div[contains(text(),'Select State')]"),
        SELECT_STATE_DROPDOWN_XPATH = $x("//input[@id = 'react-select-3-input']"),
        SELECT_CITY_XPATH = $x("//div[contains(text(),'Select City')]"),
        SELECT_CITY_DROPDOWN_XPATH = $x("//input[@id = 'react-select-4-input']"),
        SUBMIT_BUTTON_XPATH = $x("//button[@id= 'submit']"),
        MODAL_WINDOW_IDENTIFICATOR_XPATH = $x("//div[@id = 'example-modal-sizes-title-lg']"),
        CLOSE_MODAL_WINDOW_BUTTON_XPATH = $x("//button[@id = 'closeLargeModal']");


    public static ElementsCollection RESULT_FORM_COLLECTION = $$x("//tbody/descendant::td"),
            DATE_OF_BIRTH_CHANGE_MOUNTH_COLLECTION = $$x("//select[@class= 'react-datepicker__month-select']/option"),
            DATE_OF_BIRTH_CHANGE_YEAR_COLLECTION = $$x("//select[@class= 'react-datepicker__year-select']/option");


    public DemoqaMainPage(String url){
        Selenide.open(url);
    }

    public static void fillingFirstNameField(String first_name){
        setSendKeys(FIRST_NAME_XPATH, first_name);
    }

    public static void fillingLastNameField(String last_name){
        setSendKeys(LAST_NAME_XPATH, last_name);
    }

    public static void fillingEmailField(String email){
        setSendKeys(EMAIL_XPATH, email);
    }

    public static void clickToGenderMaleButton(){
        buttonClicker(GENDER_MALE_XPATH);
    }

    public static void fillingMobileField(String mobile_number){
        setSendKeys(MOBILE_XPAHT, mobile_number);
    }

    public static void clickToDateOfBirthMainField(){
        buttonClicker(DATE_OF_BIRTH_MAIN_XPATH);
    }

    public static void changeMounthInDateOfBirthField(int numberOfMounth){
        buttonClicker(DATE_OF_BIRTH_CHANGE_MOUNTH);
        buttonClicker(DATE_OF_BIRTH_CHANGE_MOUNTH_COLLECTION.get(numberOfMounth));
    }

    public static void changeYearInDateOfBirthField(String numberOfYear){
        buttonClicker(DATE_OF_BIRTH_CHANGE_YEAR);
        buttonClicker(chooseYearInCalendar(numberOfYear));
    }

    public static SelenideElement chooseYearInCalendar(String year){
        return $x("//select[@class= 'react-datepicker__year-select']/option[@value = '" + year + "']");
    }

    public static void changeDateInDateOfBirthField(String date, String matchNumber){
        buttonClicker(chooseDateInCalendar(date, matchNumber));
    }

    public static SelenideElement chooseDateInCalendar(String date, String matchNumber){
        return $x("//div[@class= 'react-datepicker__month']/descendant::div[text() = '" + date + "']" + "[" + matchNumber + "]");
    }

    public static void fillingSubjectField(String subject){
        SUBJECTS_XPATH.sendKeys(subject);
        pressEnter(SUBJECTS_XPATH);
    }

    public static void clickToSportInHobbiesField(){
        buttonClicker(SPORTS_CHECKBOX_XPATH);
    }

    public static void uploadPictureToChooseFileField(String path) throws IllegalArgumentException{
        PICTURE_XPATH.sendKeys(path);
    }

    public static void fillingCurrentAddressField(String address){
        setSendKeys(CURRENT_ADDRESS_XPATH, address);
    }

    public static void selectState(){
        SELECT_STATE_XPATH.scrollTo().click();
        pressEnter(SELECT_STATE_DROPDOWN_XPATH);
    }

    public static void selectCity(){
        SELECT_CITY_XPATH.scrollTo().click();
        SELECT_CITY_DROPDOWN_XPATH.pressEnter();
    }

    public static void clickToSubmitButton(){
        SUBMIT_BUTTON_XPATH.scrollTo();
        buttonClicker(SUBMIT_BUTTON_XPATH);
    }

    public static void closeModalWindowButtonClick(){
        buttonClicker(CLOSE_MODAL_WINDOW_BUTTON_XPATH);
    }

}
