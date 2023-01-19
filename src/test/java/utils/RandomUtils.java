package utils;

import com.github.javafaker.Faker;

import java.util.Random;

import static utils.BirthdayData.maxAvailableDay;

public class RandomUtils {
    public static Faker faker = new Faker();

    public static String randomStringFromArray(String[] input) {
        Random random = new Random();
        int index = random.nextInt(input.length);

        return input[index];
    }

    public static String[] severalRandomStringsFromArray(String[] input) {
        Random random = new Random();
        boolean check = true;
        int l = 0;
        while(check) {
            l = random.nextInt(input.length);
            if (l < 1 || l > input.length)
                continue;
            check = false;
        }
        String[] result = new String[l];
        int[] mix = random.ints(0, result.length).distinct().limit(result.length).toArray();
        for (int i = 0; i < result.length; i++) {
            result[i] = input[mix[i]];
        }

        return result;
    }

    public static int randomIntInRange(int min, int max) {
        Random random = new Random();

        return random.nextInt(max - min) + min;
    }

    public static String randomBirthdayDay(String month, String year) {
        String value = Integer.toString(RandomUtils.randomIntInRange(1, maxAvailableDay(month, year)));
        if (value.length() == 1)
            value = "0" + value;

        return value;
    }
}
