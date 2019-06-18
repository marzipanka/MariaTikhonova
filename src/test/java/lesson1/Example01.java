package lesson1;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class Example01 {
    @BeforeSuite
    public void beforeSuite() {
    System.out.println("before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before Method");
    }

    @Test
    public void sumTest() {
        System.out.println("test1");
        assertEquals(2+2, 4);
    }

    @Test
    public void subTest() {
        System.out.println("test2");
        assertEquals(2-2, 0);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after Suite");
    }
}
