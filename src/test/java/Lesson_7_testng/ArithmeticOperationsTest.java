package Lesson_7_testing;

import Lesson_7.ArithmeticOperations;

public class ArithmeticOperationsTest {

    private ArithmeticOperations operations;

    // Аналог @BeforeMethod
    public void setUp() {
        operations = new ArithmeticOperations();
    }

    // Простые методы проверки
    private void assertIntEquals(int actual, int expected, String message) {
        if (actual == expected) {
            System.out.println("✓ " + message + " - PASSED (" + actual + ")");
        } else {
            System.out.println("✗ " + message + " - FAILED (ожидалось: " + expected + ", получено: " + actual + ")");
        }
    }

    private void assertDoubleEquals(double actual, double expected, double delta, String message) {
        if (Math.abs(actual - expected) <= delta) {
            System.out.println("✓ " + message + " - PASSED (" + actual + ")");
        } else {
            System.out.println("✗ " + message + " - FAILED (ожидалось: " + expected + ", получено: " + actual + ")");
        }
    }

    private void assertException(Runnable code, Class<?> expectedException, String message) {
        try {
            code.run();
            System.out.println("✗ " + message + " - FAILED (ожидалось исключение " + expectedException.getSimpleName() + ")");
        } catch (Exception e) {
            if (e.getClass().equals(expectedException)) {
                System.out.println("✓ " + message + " - PASSED (исключение перехвачено: " + e.getMessage() + ")");
            } else {
                System.out.println("✗ " + message + " - FAILED (неправильное исключение: " + e.getClass().getSimpleName() + ")");
            }
        }
    }

    public void testAddition() {
        setUp();
        System.out.println("=== Тест сложения ===");

        assertIntEquals(operations.add(5, 3), 8, "5 + 3 = 8");
        assertIntEquals(operations.add(-5, -3), -8, "-5 + (-3) = -8");
        assertIntEquals(operations.add(5, -3), 2, "5 + (-3) = 2");
        assertIntEquals(operations.add(0, 0), 0, "0 + 0 = 0");
        assertIntEquals(operations.add(100, 0), 100, "100 + 0 = 100");
    }

    public void testSubtraction() {
        setUp();
        System.out.println("=== Тест вычитания ===");

        assertIntEquals(operations.subtract(10, 3), 7, "10 - 3 = 7");
        assertIntEquals(operations.subtract(5, 10), -5, "5 - 10 = -5");
        assertIntEquals(operations.subtract(-5, -3), -2, "-5 - (-3) = -2");
        assertIntEquals(operations.subtract(0, 5), -5, "0 - 5 = -5");
        assertIntEquals(operations.subtract(5, 5), 0, "5 - 5 = 0");
    }

    public void testMultiplication() {
        setUp();
        System.out.println("=== Тест умножения ===");

        assertIntEquals(operations.multiply(5, 3), 15, "5 * 3 = 15");
        assertIntEquals(operations.multiply(-5, 3), -15, "-5 * 3 = -15");
        assertIntEquals(operations.multiply(-5, -3), 15, "-5 * (-3) = 15");
        assertIntEquals(operations.multiply(5, 0), 0, "5 * 0 = 0");
        assertIntEquals(operations.multiply(0, 100), 0, "0 * 100 = 0");
        assertIntEquals(operations.multiply(10, 1), 10, "10 * 1 = 10");
    }

    public void testDivision() {
        setUp();
        System.out.println("=== Тест деления ===");

        assertDoubleEquals(operations.divide(10, 2), 5.0, 0.001, "10 / 2 = 5.0");
        assertDoubleEquals(operations.divide(9, 2), 4.5, 0.001, "9 / 2 = 4.5");
        assertDoubleEquals(operations.divide(-10, 2), -5.0, 0.001, "-10 / 2 = -5.0");
        assertDoubleEquals(operations.divide(0, 5), 0.0, 0.001, "0 / 5 = 0.0");
        assertDoubleEquals(operations.divide(7, 3), 2.333, 0.001, "7 / 3 ≈ 2.333");
    }

    public void testDivisionByZero() {
        setUp();
        System.out.println("=== Тест деления на ноль ===");

        assertException(() -> operations.divide(10, 0), ArithmeticException.class, "Деление на ноль");
        assertException(() -> operations.divide(0, 0), ArithmeticException.class, "Деление нуля на ноль");
        assertException(() -> operations.divide(-5, 0), ArithmeticException.class, "Деление отрицательного на ноль");
    }

    public void testCommutativeProperty() {
        setUp();
        System.out.println("=== Проверка коммутативности ===");

        // Коммутативность сложения: a + b = b + a
        int a = 7, b = 3;
        int result1 = operations.add(a, b);
        int result2 = operations.add(b, a);

        if (result1 == result2) {
            System.out.println("✓ Коммутативность сложения: " + a + " + " + b + " = " + b + " + " + a + " = " + result1);
        } else {
            System.out.println("✗ Ошибка коммутативности сложения");
        }

        // Коммутативность умножения: a * b = b * a
        result1 = operations.multiply(a, b);
        result2 = operations.multiply(b, a);

        if (result1 == result2) {
            System.out.println("✓ Коммутативность умножения: " + a + " * " + b + " = " + b + " * " + a + " = " + result1);
        } else {
            System.out.println("✗ Ошибка коммутативности умножения");
        }
    }

    public void testAllOperationsTogether() {
        setUp();
        System.out.println("=== Комплексный тест всех операций ===");

        int a = 8, b = 4;
        boolean allPassed = true;

        // Сложение
        if (operations.add(a, b) == 12) {
            System.out.println("  ✓ " + a + " + " + b + " = 12");
        } else {
            System.out.println("  ✗ Ошибка сложения");
            allPassed = false;
        }

        // Вычитание
        if (operations.subtract(a, b) == 4) {
            System.out.println("  ✓ " + a + " - " + b + " = 4");
        } else {
            System.out.println("  ✗ Ошибка вычитания");
            allPassed = false;
        }

        // Умножение
        if (operations.multiply(a, b) == 32) {
            System.out.println("  ✓ " + a + " * " + b + " = 32");
        } else {
            System.out.println("  ✗ Ошибка умножения");
            allPassed = false;
        }

        // Деление
        if (Math.abs(operations.divide(a, b) - 2.0) < 0.001) {
            System.out.println("  ✓ " + a + " / " + b + " = 2.0");
        } else {
            System.out.println("  ✗ Ошибка деления");
            allPassed = false;
        }

        if (allPassed) {
            System.out.println("✓ Все операции работают корректно");
        } else {
            System.out.println("✗ Обнаружены ошибки в операциях");
        }
    }

    public void testPerformance() {
        setUp();
        System.out.println("=== Тест производительности ===");

        long startTime = System.currentTimeMillis();
        int iterations = 10000;

        for (int i = 0; i < iterations; i++) {
            operations.add(i, i + 1);
            operations.multiply(i, i);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Выполнено " + iterations + " операций за " + duration + " мс");

        if (duration < 1000) {
            System.out.println("✓ Производительность в норме");
        } else {
            System.out.println("⚠ Производительность низкая");
        }
    }

    // Метод для запуска всех тестов
    public void runAllTests() {
        System.out.println("=== ЗАПУСК ТЕСТОВ ARITHMETIC OPERATIONS ===\n");

        testAddition();
        System.out.println();

        testSubtraction();
        System.out.println();

        testMultiplication();
        System.out.println();

        testDivision();
        System.out.println();

        testDivisionByZero();
        System.out.println();

        testCommutativeProperty();
        System.out.println();

        testAllOperationsTogether();
        System.out.println();

        testPerformance();

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }

    // Главный метод для запуска
    public static void main(String[] args) {
        ArithmeticOperationsTest test = new ArithmeticOperationsTest();
        test.runAllTests();

        // Демонстрация работы
        System.out.println("\n=== ДЕМОНСТРАЦИЯ РАБОТЫ ===");
        ArithmeticOperations demo = new ArithmeticOperations();

        System.out.println("Примеры вычислений:");
        System.out.println("15 + 7 = " + demo.add(15, 7));
        System.out.println("15 - 7 = " + demo.subtract(15, 7));
        System.out.println("15 * 7 = " + demo.multiply(15, 7));
        System.out.println("15 / 7 = " + demo.divide(15, 7));
    }
}