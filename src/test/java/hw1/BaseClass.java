package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseClass {
    protected Calculator calc;

    @BeforeMethod
    public void creatingInstanceOfCalculator() {
        calc = new Calculator();
        System.out.println("created instance");
    }

    @AfterMethod
    public void deletingInstanceOfCalculator() {
        calc = null;
        System.out.println("deleted instance");
    }
}
