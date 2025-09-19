package Lesson_1;

public class Task9 {
    public static void main(String[] args) {
        int year = 2024;
        boolean leap = isLeapYear(year);
        System.out.println(year + " год високосный: " + leap);
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

