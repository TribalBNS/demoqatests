package tests;

import org.apache.commons.lang3.RandomStringUtils;
import utils.CityAccordingToState;
import utils.RandomUtils;

import java.io.File;

public class TestData {
    private static final String[] genderChoices = {"Male", "Female", "Other"},
            birthDateMonthChoices = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"},
            subjectChoices = {"English", "Maths", "Chemistry", "Computer Science", "Commerce", "Economics", "Social Studies"},
            hobbyChoices = {"Sports", "Reading", "Music"},
            stateChoices = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            cityNCRChoices = {"Delhi", "Gurgaon", "Noida"},
            cityUttarPradeshChoices = {"Agra", "Lucknow", "Merrut"},
            cityHaryanaChoices = {"Karnal", "Panipat"},
            cityRajasthanChoices = {"Jaipur", "Jaiselmer"};
    private static final String[][] cities = {cityNCRChoices, cityUttarPradeshChoices, cityHaryanaChoices, cityRajasthanChoices};


    public static String firstName = RandomUtils.faker.name().firstName(),
            lastName = RandomUtils.faker.name().lastName(),
            userEmail = RandomUtils.faker.internet().emailAddress(),
            userNumber = RandomStringUtils.randomNumeric(10),
            gender = RandomUtils.RandomStringFromArray(genderChoices),
            birthDateMonth = RandomUtils.RandomStringFromArray(birthDateMonthChoices),
            birthDateYear = Integer.toString(RandomUtils.faker.number().numberBetween(1950, 2000)),
            birthDateDay = RandomUtils.RandomBirthdayDay(birthDateMonth, birthDateYear),
            pictureName = "1.jpeg",
            currentAddress = RandomUtils.faker.address().fullAddress(),
            state = RandomUtils.RandomStringFromArray(stateChoices),
            city = RandomUtils.RandomStringFromArray(cities[CityAccordingToState.cityDeterminant(state)]);
    public static String[] subjects = RandomUtils.SeveralRandomStringsFromArray(subjectChoices),
            hobbies = RandomUtils.SeveralRandomStringsFromArray(hobbyChoices);
    public static File img = new File("src/test/resources/" + pictureName);

}
