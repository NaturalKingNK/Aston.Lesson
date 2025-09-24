package Lesson_7_testing;

import Lesson_7.TriangleAreaCalculator;

public class TriangleAreaCalculatorTest {

    private TriangleAreaCalculator calculator;

    public void setUp() {
        calculator = new TriangleAreaCalculator();
    }

    private void assertDoubleEquals(double actual, double expected, double delta, String message) {
        if (Math.abs(actual - expected) <= delta) {
            System.out.println("✓ " + message + " - PASSED (ожидалось: " + expected + ", получено: " + actual + ")");
        } else {
            System.out.println("✗ " + message + " - FAILED (ожидалось: " + expected + ", получено: " + actual + ")");
        }
    }

    public void testTriangleAreaPositiveValues() {
        setUp();
        System.out.println("=== Тест положительных значений ===");

        assertDoubleEquals(calculator.calculateTriangleArea(10, 5), 25.0, 0.001,
                "Площадь треугольника с основанием 10 и высотой 5");
        assertDoubleEquals(calculator.calculateTriangleArea(4, 3), 6.0, 0.001,
                "Площадь треугольника с основанием 4 и высотой 3");
        assertDoubleEquals(calculator.calculateTriangleArea(7.5, 2), 7.5, 0.001,
                "Площадь треугольника с основанием 7.5 и высотой 2");
    }

    public void testTriangleAreaWithZero() {
        setUp();
        System.out.println("=== Тест нулевых значений ===");

        assertDoubleEquals(calculator.calculateTriangleArea(0, 10), 0.0, 0.001,
                "Площадь с нулевым основанием");
        assertDoubleEquals(calculator.calculateTriangleArea(10, 0), 0.0, 0.001,
                "Площадь с нулевой высотой");
        assertDoubleEquals(calculator.calculateTriangleArea(0, 0), 0.0, 0.001,
                "Площадь с нулевыми параметрами");
    }

    public void testTriangleAreaNegativeBase() {
        setUp();
        System.out.println("=== Тест отрицательного основания ===");

        try {
            calculator.calculateTriangleArea(-5, 10);
            System.out.println("✗ testTriangleAreaNegativeBase - FAILED (ожидалось исключение)");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ testTriangleAreaNegativeBase - PASSED (исключение перехвачено: " + e.getMessage() + ")");
        } catch (Exception e) {
            System.out.println("✗ testTriangleAreaNegativeBase - FAILED (неправильное исключение: " + e.getMessage() + ")");
        }
    }

    public void testTriangleAreaNegativeHeight() {
        setUp();
        System.out.println("=== Тест отрицательной высоты ===");

        try {
            calculator.calculateTriangleArea(10, -5);
            System.out.println("✗ testTriangleAreaNegativeHeight - FAILED (ожидалось исключение)");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ testTriangleAreaNegativeHeight - PASSED (исключение перехвачено: " + e.getMessage() + ")");
        } catch (Exception e) {
            System.out.println("✗ testTriangleAreaNegativeHeight - FAILED (неправильное исключение: " + e.getMessage() + ")");
        }
    }

    public void testTriangleAreaBothNegative() {
        setUp();
        System.out.println("=== Тест отрицательных основания и высоты ===");

        try {
            calculator.calculateTriangleArea(-5, -10);
            System.out.println("✗ testTriangleAreaBothNegative - FAILED (ожидалось исключение)");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ testTriangleAreaBothNegative - PASSED (исключение перехвачено: " + e.getMessage() + ")");
        } catch (Exception e) {
            System.out.println("✗ testTriangleAreaBothNegative - FAILED (неправильное исключение: " + e.getMessage() + ")");
        }
    }

    public void testTriangleAreaParameterized() {
        setUp();
        System.out.println("=== Параметризованный тест ===");

        double[][] testData = {
                {10.0, 5.0, 25.0},
                {4.0, 3.0, 6.0},
                {8.0, 6.0, 24.0},
                {12.5, 4.0, 25.0},
                {100.0, 50.0, 2500.0}
        };

        boolean allPassed = true;

        for (double[] data : testData) {
            double base = data[0];
            double height = data[1];
            double expected = data[2];
            double result = calculator.calculateTriangleArea(base, height);

            if (Math.abs(result - expected) <= 0.001) {
                System.out.println("  ✓ Площадь (" + base + ", " + height + ") = " + result);
            } else {
                System.out.println("  ✗ Площадь (" + base + ", " + height + ") Ожидалось: " + expected + ", Получено: " + result);
                allPassed = false;
            }
        }

        if (allPassed) {
            System.out.println("✓ testTriangleAreaParameterized - PASSED");
        } else {
            System.out.println("✗ testTriangleAreaParameterized - FAILED");
        }
    }

    public void testTriangleAreaFormula() {
        setUp();
        System.out.println("=== Проверка формулы площади ===");

        double base = 8.0;
        double height = 6.0;
        double expected = (base * height) / 2; // Формула площади треугольника

        double result = calculator.calculateTriangleArea(base, height);

        if (Math.abs(result - expected) <= 0.001) {
            System.out.println("✓ Формула площади проверена: (base * height) / 2 = " + result);
        } else {
            System.out.println("✗ Ошибка в формуле: ожидалось " + expected + ", получено " + result);
        }
    }

    public void runAllTests() {
        System.out.println("=== ЗАПУСК ТЕСТОВ TriangleAreaCalculator ===\n");

        testTriangleAreaPositiveValues();
        System.out.println();

        testTriangleAreaWithZero();
        System.out.println();

        testTriangleAreaNegativeBase();
        testTriangleAreaNegativeHeight();
        testTriangleAreaBothNegative();
        System.out.println();

        testTriangleAreaParameterized();
        System.out.println();

        testTriangleAreaFormula();

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }

    public static void main(String[] args) {
        TriangleAreaCalculatorTest test = new TriangleAreaCalculatorTest();
        test.runAllTests();

        // Демонстрация работы
        System.out.println("\n=== ДЕМОНСТРАЦИЯ РАБОТЫ ===");
        TriangleAreaCalculator demo = new TriangleAreaCalculator();
        double[][] examples = {
                {10, 5}, {4, 3}, {8, 6}, {5.5, 2.2}
        };

        for (double[] example : examples) {
            double area = demo.calculateTriangleArea(example[0], example[1]);
            System.out.printf("Основание: %.1f, Высота: %.1f -> Площадь: %.2f\n",
                    example[0], example[1], area);
        }
    }
}