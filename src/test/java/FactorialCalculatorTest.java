import Factorial.FactorialCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
    private FactorialCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new FactorialCalculator();
    }

    @DisplayName("Позитивный тест при вводе положительного числа ")
    @Test
    void testCalculateFactorialWithPositiveNumber() {
        assertEquals(120, calculator.calculateFactorial(5));
        assertEquals(1, calculator.calculateFactorial(0));
        assertEquals(1, calculator.calculateFactorial(1));
    }

    @DisplayName("Негативный тест при вводе отрицательного числа  ")
    @Test
    void testCalculateFactorialWithNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateFactorial(-1);
        });
    }
}
