package tests.ui.demoqa;

import base.BasePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ui_helpers.Demoqa.DemoqaAsserts.*;
import static ui_helpers.Demoqa.DemoqaSteps.*;

public class DemoqaPositiveUiTests extends BasePage {

    @Test
    @DisplayName("Заполнение всех полей формы корректными данными и проверка отображения результатов во всплывающем окне")
    public void CorrectFillingAllFields() {
        correctFillingAllFields();
        checkModalWindowAppeared();
        checkModalWindowAllContent();
    }

    @Test
    @DisplayName("Заполнение только обязательных полей корректными данными и проверка отображения результатов во всплывающем окне")
    public void CorrectFillingNecessaryFields() {
        correctFillingNecessaryFields();
        checkModalWindowAppeared();
        checkModalWindowNecessaryContent();
    }
}
