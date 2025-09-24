package Lesson_7;

import java.util.Scanner;

public class NumberComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        compareNumbers(a, b);

        scanner.close();
    }

    public static void compareNumbers(int a, int b) {
        System.out.println("Результаты сравнения:");
        System.out.println(a + " == " + b + ": " + (a == b));
        System.out.println(a + " != " + b + ": " + (a != b));
        System.out.println(a + " > " + b + ": " + (a > b));
        System.out.println(a + " < " + b + ": " + (a < b));
        System.out.println(a + " >= " + b + ": " + (a >= b));
        System.out.println(a + " <= " + b + ": " + (a <= b));

        if (a > b) {
            System.out.println(a + " больше чем " + b);
        } else if (a < b) {
            System.out.println(a + " меньше чем " + b);
        } else {
            System.out.println("Числа равны");
        }
    }
}