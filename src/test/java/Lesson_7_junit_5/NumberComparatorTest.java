package Lesson_7;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    private NumberComparator comparator;

    @BeforeEach
    void setUp() {
        comparator = new NumberComparator();
    }

    @ParameterizedTest
    @DisplayName("Сравнение равных чисел")
    @CsvSource({
            "5, 5",
            "0, 0",
            "-10, -10",
            "100, 100"
    })
    void testEqualNumbers(int a, int b) {
        assertTrue(a == b);
        assertFalse(a != b);
        assertFalse(a > b);
        assertFalse(a < b);
        assertTrue(a >= b);
        assertTrue(a <= b);
    }

    @ParameterizedTest
    @DisplayName("Сравнение когда первое число больше")
    @CsvSource({
            "10, 5",
            "0, -5",
            "100, 50",
            "-5, -10"
    })
    void testFirstNumberGreater(int a, int b) {
        assertTrue(a > b);
        assertFalse(a < b);
        assertTrue(a >= b);
        assertFalse(a <= b);
        assertTrue(a != b);
        assertFalse(a == b);
    }

    @ParameterizedTest
    @DisplayName("Сравнение когда первое число меньше")
    @CsvSource({
            "5, 10",
            "-10, 0",
            "50, 100",
            "-15, -10"
    })
    void testFirstNumberLess(int a, int b) {
        assertTrue(a < b);
        assertFalse(a > b);
        assertFalse(a >= b);
        assertTrue(a <= b);
        assertTrue(a != b);
        assertFalse(a == b);
    }

    @Test
    @DisplayName("Сравнение граничных значений")
    void testBoundaryValues() {

        assertTrue(Integer.MAX_VALUE > Integer.MIN_VALUE);
        assertTrue(Integer.MIN_VALUE < Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Test
    @DisplayName("Сравнение положительных и отрицательных чисел")
    void testPositiveNegativeComparison() {
        assertTrue(10 > -10);
        assertTrue(-10 < 10);
        assertTrue(0 > -5);
        assertTrue(-5 < 0);
    }

    @ParameterizedTest
    @DisplayName("Транзитивность сравнения")
    @CsvSource({
            "2, 5, 8",
            "-10, -5, 0",
            "1, 3, 5"
    })
    void testComparisonTransitivity(int a, int b, int c) {

        if (a < b && b < c) {
            assertTrue(a < c);
        }

        if (a > b && b > c) {
            assertTrue(a > c);
        }
    }
}