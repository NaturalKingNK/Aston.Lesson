package Lesson_1;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("5 + 5: " + isSumInRange(5, 5));
        System.out.println("10 + 10: " + isSumInRange(10, 10));
        System.out.println("1 + 2: " + isSumInRange(1, 2));
        System.out.println("15 + 6: " + isSumInRange(15, 6));
    }
    public static boolean isSumInRange(int num1, int num2) {
        int sum = num1 + num2;
        boolean result = false;
        int i = 0;

        while (i < 1) {
            if (sum >= 10 && sum <= 20) {
                result = true;
            }
            i++;
        }
        return result;
    }
}
