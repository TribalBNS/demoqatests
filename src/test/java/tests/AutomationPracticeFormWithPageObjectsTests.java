package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.StringArrayToStringUtil.convertStringArrayToString;
import static tests.TestData.*;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase {

    @Test
    @Feature("Форма регистрации студента")
    @Story("Заполнение формы регистрации студента")
    @Owner("TribalBNS")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "TestedURL", url = "https://demoqa.com")
    @DisplayName("Проверка соответствия данных в таблице введённым данным")
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        RegistrationPage steps = new RegistrationPage();

        steps.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(birthDateDay, birthDateMonth, birthDateYear)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPhoto(img)
                .setCurrentAddress(currentAddress)
                .setStateCity(state, city)
                .submitForm();

        steps.verifyResultsModalAppearance()
                .verifyResults("Label", "Values")
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", userNumber)
                .verifyResults("Date of Birth", birthDateDay + " " + birthDateMonth + "," + birthDateYear)
                .verifyResults("Subjects", convertStringArrayToString(subjects, ", "))
                .verifyResults("Hobbies", convertStringArrayToString(hobbies, ", "))
                .verifyResults("Picture", pictureName)
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state + " " + city)
                .attachScreenshot();
                steps.closeResultsForm();

    }
}

