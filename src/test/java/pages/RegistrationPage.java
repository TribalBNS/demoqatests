package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            photoInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper").$("#state"),
            cityInput = $("#stateCity-wrapper").$("#city"),
            submitFormInput = $("#submit"),
            closeResultsFormInput = $("#closeLargeModal");

    @Step("Открытие страницы")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Ввод имени {firstName}")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    @Step("Ввод фамилии {lastName}")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    @Step("Ввод имейла {userEmail}")
    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    @Step("Выбор пола {gender}")
    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();

        return this;
    }

    @Step("Ввод телефонного номера {userNumber}")
    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    @Step("Ввод даты рождения {day} {month} {year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбор предметов {subjects}")
    public RegistrationPage setSubjects(String[] subjects) {
        for (String s : subjects) {
            subjectsInput.setValue(s).pressEnter();
        }

        return this;
    }

    @Step("Выбор хобби {hobbies}")
    public RegistrationPage setHobbies(String[] hobbies) {
        for (String s : hobbies) {
            hobbiesInput.$(byText(s)).click();
        }

        return this;
    }

    @Step("Выбор фото {photo}")
    public RegistrationPage setPhoto(File photo) {
        photoInput.uploadFile(photo);

        return this;
    }

    @Step("Ввод адреса {currentAddress}")
    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;
    }

    @Step("Выбор штата {state} и города {city}")
    public RegistrationPage setStateCity(String state, String city) {
        stateInput.click();
        $(byText(state)).click();
        cityInput.click();
        $(byText(city)).click();


        return this;
    }

    @Step("Отправка формы")
    public RegistrationPage submitForm() {
        submitFormInput.click();

        return this;
    }

    @Step("Проверка появления таблицы")
    public RegistrationPage verifyResultsModalAppearance() {
        registrationResultsModal.verifyModalAppearance();

        return this;
    }

    @Step("Проверка соответствия {key} {value}")
    public RegistrationPage verifyResults(String key, String value) {
        registrationResultsModal.verifyResults(key, value);

        return this;
    }

    @Step("Закрытие таблицы")
    public RegistrationPage closeResultsForm() {
        closeResultsFormInput.click();

        return this;
    }

}

