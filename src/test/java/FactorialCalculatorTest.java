import Factorial.FactorialCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
    @DisplayName("Позитивный тест при вводе положительного числа ")
    @Test
    void testCalculateFactorialWithPositiveNumber() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
    }

    @DisplayName("Негативный тест при вводе отрицательного числа  ")
    @Test
    void testCalculateFactorialWithNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-1);
        });
    }
}
