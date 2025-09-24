package Lesson_7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorTest {

    @Test
    void testCalculateTriangleArea() {
        // Тестируем статический метод
        assertEquals(25.0, TriangleAreaCalculator.calculateTriangleArea(10, 5), 0.001);
        assertEquals(6.0, TriangleAreaCalculator.calculateTriangleArea(4, 3), 0.001);
    }

    @Test
    void testCalculateTriangleAreaWithNegativeValues() {
        // Тестируем исключение для отрицательных значений
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateTriangleArea(-5, 10));

        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateTriangleArea(10, -5));
    }

    @Test
    void testCalculateTriangleAreaWithZero() {
        // Тестируем граничные случаи
        assertEquals(0.0, TriangleAreaCalculator.calculateTriangleArea(0, 10), 0.001);
        assertEquals(0.0, TriangleAreaCalculator.calculateTriangleArea(10, 0), 0.001);
        assertEquals(0.0, TriangleAreaCalculator.calculateTriangleArea(0, 0), 0.001);
    }
}