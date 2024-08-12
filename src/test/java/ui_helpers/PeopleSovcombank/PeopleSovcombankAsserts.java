package ui_helpers.PeopleSovcombank;

import base.BasePage;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class PeopleSovcombankAsserts extends BasePage {

    public static void checkTextContains(ArrayList<String> arrayList, String word_1, String word_2){
        for(int i = 0; i < arrayList.size(); i++) {
            Assertions.assertTrue(arrayList.get(i).contains(word_1) || arrayList.get(i).contains(word_2));
        }
    }
}
