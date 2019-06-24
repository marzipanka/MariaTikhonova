package hw1;

// fixed TODO Unused imports
import org.testng.Assert;
import org.testng.annotations.*;

public class SubstractTest extends BaseClass {

    @DataProvider
    public static Object[][] numbersForSubLong() {
        return new Object[][]{
                //checking if the calculator is able to work with such big numbers of long data type
                {9223372036854775806L, 1L, 9223372036854775805L},
                //checking if the "b" variable can contain such a big number
                {1L, 9223372036854775806L, -9223372036854775805L},
                //testing the calculator using normal numbers just to check if it's calculations are correct
                {14L, 9L, 5L},
                //checking how it works when all the numbers are negative and the result is also going to be negative
                {-10L, -9L, -1L},
                //checking how it works when the all the numbers are negative but the answer has to be positive
                {-9L, -10L, 1L},
                //checking how it works when the "a" number is negative and the result has to be negative too
                {-2L, 20L, -22L},
                //checking how it works when the "b" number is negative but the result has to be positive
                {2L, -20L, 22L},
                //checking how it works when we substract something from zero
                {0L, 1L, -1L},
                //checking how it works when we substract zero from something
                {-1L, 0L, -1L},
                //checking how it works when all the numbers are zeros
                {0L, 0L, 0L},
                //checking what happens when the "a" and the "b" numbers are similar
                {2L, 2L, 0L}};
    }

    @Test(groups={"addSubstract"}, dataProvider = "numbersForSubLong")
    public void subLongTest(long a, long b, long res) {
        // fixed TODO This variable is redundant
        long actual = calc.sub(a,b);
        Assert.assertEquals(actual, res);
    }


    @DataProvider
    public static Object[][] numbersForSubDouble() {
        return new Object[][]{{Double.MAX_VALUE-0.1, -0.1, Double.MAX_VALUE},
                {0.1, Double.MAX_VALUE, 0.1-Double.MAX_VALUE},
                {12.13345, 10.01, 2.12345},
                {-19.102, -9.1, -10.002},
                {-2.0, 20.99999, -22.99999},
                {-20.99999, 2.0, -22.99999},
                {0.0, 1.5, -1.5},
                {1.5, 0.0, 1.5},
                {0.75, 0.5, 0.25},
                {0.0, 0.0, 0.0}};
    }

    @Test(groups={"addSubstract"}, dataProvider = "numbersForSubDouble")
    public void subDoubleTest(double a, double b, double res) {
        // fixed TODO This variable is redundant
        double actual = calc.sub(a,b);
        Assert.assertEquals(actual, res);
    }
}
