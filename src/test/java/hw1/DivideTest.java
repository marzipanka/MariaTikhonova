package hw1;

import org.testng.Assert;
import org.testng.annotations.*;

public class DivideTest extends BaseClass {

    @DataProvider
    public static Object[][] numbersForDivLong() {
        return new Object[][]{
                //checking if the calculator is able to work with such big numbers of long data type
                {9223372036854775806L, 1L, 9223372036854775806L},
                //checking if the "b" variable can contain such a big number
                {1L, 9223372036854775806L, 0L},
                //checking what happens if the first number is negative and the second one is positive
                {-20L, 4L, -5L},
                //checking what happens if the first number is positive and the second one is negative
                {20L, -4L, -5L},
                //checking how it works if both of the numbers are negative
                {-1L, -1L, 1L},
                //checking how it works if the first number is zero
                {0L, 1L, 0L},
                //checking how it works if both of the numbers are similar
                {3L, 3L, 1L}};
    }

    @Test(groups={"divideMultiply"}, dataProvider = "numbersForDivLong")
    public void divLongTest(long a, long b, long res) {
        // TODO This variable is redundant
        long expected = res;
        long actual = calc.div(a,b);
        Assert.assertEquals(actual, expected);
    }



    @DataProvider
    public static Object[][] numbersForDivDouble() {
        return new Object[][]{{Double.MAX_VALUE, 1.0, Double.MAX_VALUE},
                {1.0, Double.MAX_VALUE, 1.0/Double.MAX_VALUE},
                {12.13345, 10.01, 12.13345/10.01},
                {-19.102, -10.0, -19.102/(-10.0)},
                {-2.8, 20.0, -2.8/20.0},
                {-20.8, 2.0, -10.4},
                {0.0, 1.5, 0},
                {0.5, 0.1, 5.0}};
    }

    @Test(groups={"divideMultiply"}, dataProvider = "numbersForDivDouble")
    public void divDoubleTest(double a, double b, double res) {
        // TODO This variable is redundant
        double expected = res;
        double actual = calc.div(a,b);
        Assert.assertEquals(actual, expected);
    }
}
