package Factorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {


    @Test(description = "Позитивный тест при вводе положительного числа ")
    public void testCalculateFactorial() {
        FactorialCalculator calculator = new FactorialCalculator();
        Assert.assertEquals(calculator.calculateFactorial(0), 1);
        Assert.assertEquals(calculator.calculateFactorial(1), 1);
        Assert.assertEquals(calculator.calculateFactorial(5), 120);
        Assert.assertEquals(calculator.calculateFactorial(10), 3628800);
    }

    @Test(description = "Негативный тест при вводе отрицательного  числа ", expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialWithNegativeNumber() {
        FactorialCalculator calculator = new FactorialCalculator();
        calculator.calculateFactorial(-1);
    }
}