package hw1;

import org.testng.Assert;
import org.testng.annotations.*;

public class MultiplyTest extends BaseClass {

    @DataProvider
    public static Object[][] numbersForMultiplyLong() {
        return new Object[][]{
                //checking if the calculator is able to work with such big numbers of long data type
                {9223372036854775806L, 1L, 9223372036854775806L},
                //checking if the "b" variable can contain such a big number
                {1L, 9223372036854775806L, 9223372036854775806L},
                //checking how it works when all the number are zeros
                {0L, 0L, 0L},
                //checking if the result is correct using normal positive numbers
                {3L, 2L, 6L},
                //checking how it works when the first number is negative and the second one if positive
                {-5L, 3L, -15L},
                //checking how it works when the first number positive and the second one is negative
                {5L, -3L, -15L},
                //checking how it works if both of the numbers are negative
                {-8L, -5L, 40L}};
    }

    @Test(groups={"divideMultiply"}, dataProvider = "numbersForMultiplyLong")
    public void multiplyLongTest(long a, long b, long res) {
        // fixed TODO This variable is redundant
        long actual = calc.mult(a,b);
        Assert.assertEquals(actual, res);
    }


    @DataProvider
    public static Object[][] numbersForMultiplyDouble() {
        return new Object[][]{{Double.MAX_VALUE, 1.0, Double.MAX_VALUE},
                {1.0, Double.MAX_VALUE, Double.MAX_VALUE},
                {12.13345, 10.01, 12.13345*10.01},
                {-19.102, -10.0, -19.102*(-10.0)},
                {-2.8, 20.0, -2.8*20.0},
                {-20.8, 2.0, -20.8*2.0},
                {0.0, 1.0, 0},
                {0.5, 0.1, 0.5*0.1}};
    }

    @Test(groups={"divideMultiply"}, dataProvider = "numbersForMultiplyDouble")
    public void multiplyDoubleTest(double a, double b, double res) {
        // fixed TODO This variable is redundant
        double actual = calc.mult(a,b);
        Assert.assertEquals(actual, res);
    }
}
