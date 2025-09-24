package Lesson_7;

import java.util.Scanner;

public class TriangleAreaCalculator {

    // Метод для вычисления площади треугольника
    public static double calculateTriangleArea(double base, double height) {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Основание и высота должны быть неотрицательными");
        }
        return (base * height) / 2;
    }

    // Основной метод
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите основание треугольника: ");
            double base = scanner.nextDouble();

            System.out.print("Введите высоту треугольника: ");
            double height = scanner.nextDouble();

            // Вычисляем площадь
            double area = calculateTriangleArea(base, height);
            System.out.println("Площадь треугольника = " + area);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка ввода: введите числовые значения");
        } finally {
            scanner.close();
        }
    }
}