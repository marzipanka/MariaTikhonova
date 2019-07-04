package hw4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    protected String userName;
    protected String login;
    protected String password;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.pollingInterval = 500;
        Configuration.reportsFolder = "target/selenide/reports/test";

        // 1. Open test site by URL
        open("https://epam.github.io/JDI/index.html");

        readUserFromFile(".\\src\\test\\resources\\properties\\user.properties");
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







