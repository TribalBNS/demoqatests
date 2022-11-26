package utils;

public class BirthdayData {
    private static final String[] allMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    private static boolean LeapYearChecker(String year) {
        int checkedYear = Integer.parseInt(year);
        boolean leap;
        if (checkedYear % 4 == 0) {
            if (checkedYear % 100 == 0) {
                leap = checkedYear % 400 == 0;
            } else
                leap = true;
        } else
            leap = false;

        return leap;
    }



    public static int MaxAvailableDay(String month, String year) {
        int maxDay = 0;
        if (month.equals(allMonths[0]) || month.equals(allMonths[2]) || month.equals(allMonths[4]) || month.equals(allMonths[6]) || month.equals(allMonths[7]) || month.equals(allMonths[9]) || month.equals(allMonths[11])) {

            maxDay = 31;
        } else if (month.equals(allMonths[3]) || month.equals(allMonths[5]) || month.equals(allMonths[8]) || month.equals(allMonths[10])) {

            maxDay = 30;
        } else if (month.equals(allMonths[1]) && LeapYearChecker(year)) {

            maxDay = 29;

        } else if (month.equals(allMonths[1])) {

            maxDay = 28;

        }

        return maxDay;

    }


}
