package Lesson_7_testing;

import Lesson_7.FactorialCalculator;

public class FactorialCalculatorTest {

    private FactorialCalculator calculator;

    public void setUp() {
        calculator = new FactorialCalculator();
    }

    public void testFactorialOfZero() {
        setUp();
        long result = calculator.calculateFactorial(0);
        if (result == 1) {
            System.out.println("✓ testFactorialOfZero - PASSED (0! = 1)");
        } else {
            System.out.println("✗ testFactorialOfZero - FAILED. Ожидалось: 1, Получено: " + result);
        }
    }

    public void testFactorialOfOne() {
        setUp();
        long result = calculator.calculateFactorial(1);
        if (result == 1) {
            System.out.println("✓ testFactorialOfOne - PASSED (1! = 1)");
        } else {
            System.out.println("✗ testFactorialOfOne - FAILED. Ожидалось: 1, Получено: " + result);
        }
    }

    public void testFactorialPositiveNumbers() {
        setUp();
        boolean allPassed = true;

        // Тестируем несколько значений
        long[][] testCases = {
                {2, 2},    // 2! = 2
                {3, 6},     // 3! = 6
                {4, 24},    // 4! = 24
                {5, 120},   // 5! = 120
                {6, 720}    // 6! = 720
        };

        for (long[] testCase : testCases) {
            int input = (int) testCase[0];
            long expected = testCase[1];
            long result = calculator.calculateFactorial(input);

            if (result == expected) {
                System.out.println("  ✓ " + input + "! = " + result);
            } else {
                System.out.println("  ✗ " + input + "! Ожидалось: " + expected + ", Получено: " + result);
                allPassed = false;
            }
        }

        if (allPassed) {
            System.out.println("✓ testFactorialPositiveNumbers - PASSED");
        } else {
            System.out.println("✗ testFactorialPositiveNumbers - FAILED");
        }
    }

    public void testFactorialNegativeNumber() {
        setUp();
        try {
            calculator.calculateFactorial(-5);
            System.out.println("✗ testFactorialNegativeNumber - FAILED (ожидалось исключение)");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ testFactorialNegativeNumber - PASSED (исключение перехвачено)");
        } catch (Exception e) {
            System.out.println("✗ testFactorialNegativeNumber - FAILED (неправильное исключение: " + e.getMessage() + ")");
        }
    }

    public void testFactorialLargeNumber() {
        setUp();
        try {
            long result = calculator.calculateFactorial(10);
            if (result == 3628800L) {
                System.out.println("✓ testFactorialLargeNumber - PASSED (10! = 3,628,800)");
            } else {
                System.out.println("✗ testFactorialLargeNumber - FAILED. Ожидалось: 3628800, Получено: " + result);
            }
        } catch (Exception e) {
            System.out.println("✗ testFactorialLargeNumber - FAILED (ошибка: " + e.getMessage() + ")");
        }
    }

    // Метод для запуска всех тестов
    public void runAllTests() {
        System.out.println("=== ЗАПУСК ТЕСТОВ FactorialCalculator ===");

        testFactorialOfZero();
        testFactorialOfOne();
        testFactorialPositiveNumbers();
        testFactorialNegativeNumber();
        testFactorialLargeNumber();

        System.out.println("=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }

    // Главный метод для запуска
    public static void main(String[] args) {
        FactorialCalculatorTest test = new FactorialCalculatorTest();
        test.runAllTests();

        // Демонстрация работы
        System.out.println("\n=== ДЕМОНСТРАЦИЯ ===");
        FactorialCalculator demo = new FactorialCalculator();
        for (int i = 0; i <= 6; i++) {
            System.out.println(i + "! = " + demo.calculateFactorial(i));
        }
    }
}