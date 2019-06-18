package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class SumTest {

    private Calculator calc;

    @BeforeMethod
    public void creatingInstanceOfCalculator() {
        calc = new Calculator();
    }

    @AfterMethod
    public void deletingInstanceOfCalculator() {
        calc = null;
    }



    @DataProvider
    public static Object[][] numbersForSumLong() {

        return new Object[][]{{9223372036854775805L, 1L, 9223372036854775806L},
                {1L, 9223372036854775805L, 9223372036854775806L},
                {5L, 9L, 14L},
                {-10L, -9L, -19L},
                {-9L, -10L, -19L},
                {-2L, 20L, 18L},
                {-20L, 2L, -18L},
                {0L, 1L, 1L},
                {-1L, 0L, -1L},
                {0L, 0L, 0L},};
    }

    @Test(groups={"addSubstract"}, dataProvider = "numbersForSumLong")
    public void sumLongTest(long a, long b, long res) {
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
        double expected = res;
        double actual = calc.sum(a,b);
        Assert.assertEquals(actual, expected);
    }
}
