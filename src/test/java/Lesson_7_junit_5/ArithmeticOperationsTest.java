package Lesson_7;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    private ArithmeticOperations operations;

    @BeforeEach
    void setUp() {
        operations = new ArithmeticOperations();
    }

    @Nested
    @DisplayName("Тесты сложения")
    class AdditionTests {

        @ParameterizedTest
        @CsvSource({
                "5, 3, 8",
                "-5, -3, -8",
                "5, -3, 2",
                "0, 0, 0",
                "100, 0, 100"
        })
        void testAdd(int a, int b, int expected) {
            assertEquals(expected, operations.add(a, b));
        }
    }

    @Nested
    @DisplayName("Тесты вычитания")
    class SubtractionTests {

        @ParameterizedTest
        @CsvSource({
                "10, 3, 7",
                "5, 10, -5",
                "-5, -3, -2",
                "0, 5, -5"
        })
        void testSubtract(int a, int b, int expected) {
            assertEquals(expected, operations.subtract(a, b));
        }
    }

    @Nested
    @DisplayName("Тесты умножения")
    class MultiplicationTests {

        @ParameterizedTest
        @CsvSource({
                "5, 3, 15",
                "-5, 3, -15",
                "-5, -3, 15",
                "5, 0, 0"
        })
        void testMultiply(int a, int b, int expected) {
            assertEquals(expected, operations.multiply(a, b));
        }
    }

    @Nested
    @DisplayName("Тесты деления")
    class DivisionTests {

        @ParameterizedTest
        @CsvSource({
                "10, 2, 5.0",
                "9, 2, 4.5",
                "-10, 2, -5.0",
                "0, 5, 0.0"
        })
        void testDivideValid(int a, int b, double expected) {
            assertEquals(expected, operations.divide(a, b), 0.001);
        }

        @Test
        @DisplayName("Деление на ноль должно возвращать бесконечность")
        void testDivideByZero() {
            double result = operations.divide(10, 0);
            assertTrue(Double.isInfinite(result));
        }

        @Test
        @DisplayName("Деление нуля на ноль должно возвращать NaN")
        void testDivideZeroByZero() {
            double result = operations.divide(0, 0);
            assertTrue(Double.isNaN(result));
        }
    }

    @Test
    @DisplayName("Коммутативность сложения")
    void testAdditionCommutative() {
        int a = 7;
        int b = 3;
        assertEquals(operations.add(a, b), operations.add(b, a));
    }

    @Test
    @DisplayName("Коммутативность умножения")
    void testMultiplicationCommutative() {
        int a = 4;
        int b = 5;
        assertEquals(operations.multiply(a, b), operations.multiply(b, a));
    }

    @Test
    @DisplayName("Ассоциативность сложения")
    void testAdditionAssociative() {
        int a = 2;
        int b = 3;
        int c = 4;
        int result1 = operations.add(operations.add(a, b), c);
        int result2 = operations.add(a, operations.add(b, c));
        assertEquals(result1, result2);
    }
}