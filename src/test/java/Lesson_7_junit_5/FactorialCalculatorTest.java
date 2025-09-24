package Lesson_7;
//

//
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void testCalculateFactorialStatic() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }

    @Test
    void testCalculateFactorialInstance() {
        FactorialCalculator calculator = new FactorialCalculator();
        assertEquals(1, calculator.calculateFactorial(0));
        assertEquals(1, calculator.calculateFactorial(1));
        assertEquals(120, calculator.calculateFactorial(5));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "6, 720"
    })
    void testFactorialVariousNumbers(int input, long expected) {
        FactorialCalculator calculator = new FactorialCalculator();
        assertEquals(expected, calculator.calculateFactorial(input));
    }

    @Test
    void testFactorialNegativeNumber() {
        FactorialCalculator calculator = new FactorialCalculator();
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateFactorial(-5));
    }
}