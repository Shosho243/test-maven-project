package Factorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {


    @Test(description = "Позитивный тест при вводе положительного числа ")
    public void testCalculateFactorial() {

        Assert.assertEquals(FactorialCalculator.calculateFactorial(0), 1);
        Assert.assertEquals(FactorialCalculator.calculateFactorial(1), 1);
        Assert.assertEquals(FactorialCalculator.calculateFactorial(5), 120);
        Assert.assertEquals(FactorialCalculator.calculateFactorial(10), 3628800);
    }

    @Test(description = "Негативный тест при вводе отрицательного  числа ", expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialWithNegativeNumber() {

        FactorialCalculator.calculateFactorial(-1);
    }
}