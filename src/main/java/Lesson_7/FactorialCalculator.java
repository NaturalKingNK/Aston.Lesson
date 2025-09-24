package Lesson_7;

import java.util.Scanner;

public class FactorialCalculator {

    // Статический метод
    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число для вычисления факториала: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Факториал отрицательного числа не определен.");
        } else {
            // Теперь можно вызывать статический метод
            long factorial = calculateFactorial(number);
            System.out.println("Факториал числа " + number + " = " + factorial);
        }

        scanner.close();
    }
}