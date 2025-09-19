package Lesson_1;

public class Task2 {
    public static void main(String[] args) {
        checkSumSign();
    }
     public static void checkSumSign() {
        int a = 11;
        int b = 5;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
}
