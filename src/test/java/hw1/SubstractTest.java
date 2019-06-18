package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class SubstractTest {

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
    public static Object[][] numbersForSubLong() {
        return new Object[][]{{9223372036854775806L, 1L, 9223372036854775805L},
                {1L, 9223372036854775806L, -9223372036854775805L},
                {14L, 9L, 5L},
                {-10L, -9L, -1L},
                {-9L, -10L, 1L},
                {-2L, 20L, -22L},
                {2L, -20L, 22L},
                {0L, 1L, -1L},
                {-1L, 0L, -1L},
                {0L, 0L, 0L},
                {2L, 2L, 0L}};
    }

    @Test(groups={"addSubstract"}, dataProvider = "numbersForSubLong")
    public void subLongTest(long a, long b, long res) {
        long expected = res;
        long actual = calc.sub(a,b);
        Assert.assertEquals(actual, expected);
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
        double expected = res;
        double actual = calc.sub(a,b);
        Assert.assertEquals(actual, expected);
    }
}
