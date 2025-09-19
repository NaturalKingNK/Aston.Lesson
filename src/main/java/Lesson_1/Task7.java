package Lesson_1;

public class Task7 {
    public static void main(String[] args) {
        System.out.println("10: " + isNegative(10));
        System.out.println("-5: " + isNegative(-5));
        System.out.println("0: " + isNegative(0));

        int num = -7;
        boolean result = isNegative(num);
        System.out.println(num + " отрицательное: " + result);
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }
}
