package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class DivideTest {

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
    public static Object[][] numbersForDivLong() {
        return new Object[][]{{9223372036854775806L, 1L, 9223372036854775806L},
                {1L, 9223372036854775806L, 0L},
                {-20L, 4L, -5L},
                {20L, -4L, -5L},
                {-1L, -1L, 1L},
                {0L, 1L, 0L},
                {3L, 3L, 1L}};
    }

    @Test(groups={"divideMultiply"}, dataProvider = "numbersForDivLong")
    public void divLongTest(long a, long b, long res) {
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
        double expected = res;
        double actual = calc.div(a,b);
        Assert.assertEquals(actual, expected);
    }
}
