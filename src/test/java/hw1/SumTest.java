package hw1;

import org.testng.Assert;
import org.testng.annotations.*;

public class SumTest extends BaseClass {

    @DataProvider
    public static Object[][] numbersForSumLong() {
        return new Object[][]{
                //these numbers were chosen to check if the calculator is able to work with such big numbers of long data type
                {9223372036854775805L, 1L, 9223372036854775806L},
                //checking if the "b" variable can contain such a big number
                {1L, 9223372036854775805L, 9223372036854775806L},
                //testing the calculator using normal numbers just to check if it's calculations are correct
                {5L, 9L, 14L},
                //checking how it works when all the numbers are negative
                {-10L, -9L, -19L},
                //checking how it works when one of the numbers is negative and the result is going to be positive
                {-2L, 20L, 18L},
                //checking how copes with giving the negative result
                {-20L, 2L, -18L},
                //checking what happens when the "a" variable is zero
                {0L, 1L, 1L},
                //checking what happens when the "b" variable is zero
                {-1L, 0L, -1L},
                //checking what happens when all the variables are zeros
                {0L, 0L, 0L},};
    }

    @Test(groups={"addSubstract"}, dataProvider = "numbersForSumLong")
    public void sumLongTest(long a, long b, long res) {
        // TODO This variable is redundant
        long expected = res;
        long actual = calc.sum(a,b);
        Assert.assertEquals(actual, expected);
    }



    @DataProvider
    public static Object[][] numbersForSumDouble() {
        return new Object[][]{{Double.MAX_VALUE, -0.1, Double.MAX_VALUE-0.1},
                {-0.1, Double.MAX_VALUE, Double.MAX_VALUE-0.1},
                {2.12345, 10.01, 12.13345},
                {-10.002, -9.1, -19.102},
                {-9.1, -10.002, -19.102},
                {-2.0, 20.99999, 18.99999},
                {-20.99999, 2.0, -18.99999},
                {0.0, 1.5, 1.5},
                {1.5, 0.0, 1.5},
                {0.2, 0.65, 0.2+0.65},
                {0.0, 0.0, 0.0}};
    }

    @Test(groups={"addSubstract"}, dataProvider = "numbersForSumDouble")
    public void sumDoubleTest(double a, double b, double res) {
        // TODO This variable is redundant
        double expected = res;
        double actual = calc.sum(a,b);
        Assert.assertEquals(actual, expected);
    }
}
