package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseClass {
    protected WebDriver driver;

    @BeforeSuite
    public void setUpDriverPath() {
        // TODO Where is chromedriver.exe in the resource folder?
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                        .toAbsolutePath().toString());
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Open test site by URL
        driver.get("https://epam.github.io/JDI/index.html");

        // 2. Assert Browser title
        assertBrowserTitle("Home Page");

        // 3. Perform login
        login("epam", "1234");

        // 4. Assert User name in the right-top side of screen that user is logged in
        assertEquals(driver.findElement(By.id("user-name")).getText(), "PITER CHAILOVSKII");
    }

    //Close Browser
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    protected void assertBrowserTitle(String title) {
        assertEquals(driver.getTitle(), title);
    }

    protected void login(String username, String password) {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    protected void checkElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

}
