package ui_helpers.PeopleSovcombank;

import base.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static page_object.people_sovkombank.PeopleSovcombankMainPage.*;
import static page_object.people_sovkombank.PeopleSovcombankVacanciesPage.*;

public class PeopleSovcombankSteps extends BasePage {
    public static void closePopUp(SelenideElement element){
        element.click();
    }

    public static boolean checkPopUp(SelenideElement element){
        return element.isDisplayed();
    }

    public static void closePopUpIfExist(){
        if(checkPopUp(CHECK_POP_UP)){
            closePopUp(CLOSE_POP_UP);
        }
    }

    public static ArrayList<String> convertElementsCollectionToArrayList(ElementsCollection elementsCollection){
        ArrayList <String> texts = new ArrayList<>();
        for(int i = 0; i < texts.size(); i ++){
            texts.add(elementsCollection.get(i).getText());
        }
        return texts;
    }
}
