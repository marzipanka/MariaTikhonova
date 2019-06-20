package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class MultiplyTest {

    // TODO This field could be extracted to the base class
    private Calculator calc;

    // TODO These two method could be extracted to base class
    @BeforeMethod
    public void creatingInstanceOfCalculator() {
        calc = new Calculator();
    }

    @AfterMethod
    public void deletingInstanceOfCalculator() {
        calc = null;
    }


    // TODO Why do you decide use this set of data?
    @DataProvider
    public static Object[][] numbersForMultiplyLong() {
        return new Object[][]{{9223372036854775806L, 1L, 9223372036854775806L},
                {1L, 9223372036854775806L, 9223372036854775806L},
                {0L, 0L, 0L},
                {3L, 2L, 6L},
                {-5L, 3L, -15L},
                {5L, -3L, -15L},
                {-8L, -5L, 40L}};
    }

    @Test(groups={"divideMultiply"}, dataProvider = "numbersForMultiplyLong")
    public void multiplyLongTest(long a, long b, long res) {
        long expected = res;
        long actual = calc.mult(a,b);
        Assert.assertEquals(actual, expected);
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
        double expected = res;
        double actual = calc.mult(a,b);
        Assert.assertEquals(actual, expected);
    }
}
