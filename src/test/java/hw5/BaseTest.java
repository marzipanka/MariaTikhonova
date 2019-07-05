package hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class BaseTest {

    protected WebDriver driver;

    protected String userName;
    protected String login;
    protected String password;

    @BeforeSuite
    public void setUpDriverPath() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Open test site by URL
        driver.get("https://epam.github.io/JDI/index.html");

        readUserFromFile(".\\src\\test\\resources\\properties\\user.properties");
    }

    //Close Browser
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void readUserFromFile(String filePath) {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(filePath)) {
            if (input == null) {
                System.out.println("Сonfig.properties not found");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userName = properties.getProperty("user.user.name");
        login = properties.getProperty("user.name");
        password = properties.getProperty("user.password");
    }

}







