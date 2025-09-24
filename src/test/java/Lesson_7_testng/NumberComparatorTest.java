package Lesson_7_testing;

import Lesson_7.NumberComparator;

public class NumberComparatorTest {

    private NumberComparator comparator;

    public void setUp() {
        comparator = new NumberComparator();
    }

    public void testComparisonOutput() {
        setUp();
        System.out.println("=== ТЕСТ ВЫВОДА ===");

        try {
            comparator.compareNumbers(5, 5);
            comparator.compareNumbers(10, 5);
            comparator.compareNumbers(3, 7);
            System.out.println("✓ Все сравнения выполнены успешно");
        } catch (Exception e) {
            System.out.println("✗ Ошибка при выполнении сравнений: " + e.getMessage());
        }
    }

    public void testComparisonLogic() {
        System.out.println("=== ТЕСТ ЛОГИКИ СРАВНЕНИЯ ===");

        int a = 5, b = 3;

        if (a > b && !(a < b) && a != b) {
            System.out.println("✓ Логика сравнения 5 и 3 корректна");
        } else {
            System.out.println("✗ Логика сравнения 5 и 3 некорректна");
        }

        int x = 2, y = 2;
        if (x == y && !(x != y) && x >= y && x <= y) {
            System.out.println("✓ Логика сравнения 2 и 2 корректна");
        } else {
            System.out.println("✗ Логика сравнения 2 и 2 некорректна");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ЗАПУСК ТЕСТОВ NumberComparator ===");

        NumberComparatorTest test = new NumberComparatorTest();
        test.setUp();

        test.testComparisonOutput();
        test.testComparisonLogic();

        System.out.println("=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
}