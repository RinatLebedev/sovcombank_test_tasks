package base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

public class BasePage extends BaseUiTest{

    public static void buttonClicker(SelenideElement element){
        element.shouldBe(enabled,exist).click();
    }

    public static void setSendKeys(SelenideElement element, String text){
        element.shouldBe(enabled,exist).sendKeys(text);
    }

    public static void pressEnter(SelenideElement element){
        element.pressEnter();
    }

}
