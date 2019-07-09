package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage extends BasePage {

    private static UserTablePage instance;

    @FindBy(tagName = "select")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(xpath = "//td/a")
    private List<WebElement> userTableUserNames;

    @FindBy(xpath = "//td/img")
    private List<WebElement> userTableImages;

    @FindBy(xpath = "//div[@class='user-descr']/span")
    private List<WebElement> textsUnderUserTableImages;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> userTableCheckboxes;

    private UserTablePage(WebDriver driver) {
        super(driver);
    }

    public static UserTablePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new UserTablePage(driver);
        }
        return instance;
    }

    public static void makeInstanceNull() {
        instance = null;
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getUserTableUserNames() {
        return userTableUserNames;
    }

    public List<WebElement> getUserTableImages() {
        return userTableImages;
    }

    public List<WebElement> getTextsUnderUserTableImages() {
        return textsUnderUserTableImages;
    }

    public List<WebElement> getUserTableCheckboxes() {
        return userTableCheckboxes;
    }
}
