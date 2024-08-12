package ui_helpers.Demoqa;

import base.BasePage;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static com.codeborne.selenide.Selenide.$x;
import static page_object.demoqa.DemoqaMainPage.MODAL_WINDOW_IDENTIFICATOR_XPATH;

public class DemoqaAsserts extends BasePage {

    public static void checkModalWindowAppeared(){
        Assertions.assertTrue(MODAL_WINDOW_IDENTIFICATOR_XPATH.isDisplayed());
    }

    public static void checkModalWindowNotAppeared(){
        Assertions.assertFalse(MODAL_WINDOW_IDENTIFICATOR_XPATH.isDisplayed());
    }

    public static void checkModalWindowAllContent(){
        LinkedHashMap <String,String> content = new LinkedHashMap<>();
        content.put("Student Name", "first_name last_name");
        content.put("Student Email", "h@mail.com");
        content.put("Gender", "Male");
        content.put("Mobile", "1234567890");
        content.put("Date of Birth", "01 February,2000");
        content.put("Subjects", "Maths");
        content.put("Hobbies", "Sports");
        content.put("Picture", "first_photo.jpg");
        content.put("Address", "Time Square 1");
        content.put("State and City", "NCR Delhi");
        ModalWindowContentAssert(content);
    }

    public static void checkModalWindowNecessaryContent(){
        LinkedHashMap <String,String> content = new LinkedHashMap<>();
        content.put("Student Name", "first_name last_name");
        content.put("Student Email", "h@mail.com");
        content.put("Gender", "Male");
        content.put("Mobile", "1234567890");
        content.put("Date of Birth", "01 February,2000");
        content.put("Subjects", "");
        content.put("Hobbies", "");
        content.put("Picture", "");
        content.put("Address", "");
        content.put("State and City", "");
        ModalWindowContentAssert(content);
    }

    public static void ModalWindowContentAssert(LinkedHashMap <String,String> content){
        ArrayList<String> params = new ArrayList<>();
        params.add("Student Name");
        params.add("Student Email");
        params.add("Gender");
        params.add("Mobile");
        params.add("Date of Birth");
        params.add("Subjects");
        params.add("Hobbies");
        params.add("Picture");
        params.add("Address");
        params.add("State and City");
        for (int i = 0; i < params.size(); i++) {
            String param = $x("//td[text()='" + params.get(i) + "']/following-sibling::td").getText();
            Assertions.assertEquals(content.get(params.get(i)), param);
        }
    }
}
