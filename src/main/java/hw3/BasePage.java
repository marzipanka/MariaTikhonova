package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    protected WebDriver driver;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    private WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li")
    private List<WebElement> headerElements;

    @FindBy(id = "mCSB_1_container")
    private WebElement leftSection;

    @FindBy(tagName = "footer")
    private WebElement footer;

    @FindBy(className = "dropdown-toggle")
    private WebElement headerService;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li")
    private List<WebElement> headerServiceDropdown;

    @FindBy(css = "a[ui='label']")
    private WebElement leftService;

    @FindBy(xpath = "//ul[@class='sub']/li")
    private List<WebElement> leftServiceDropdown;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementsButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public void login(String username, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }

    public List<WebElement> getHeaderElements() {
        return headerElements;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getHeaderService() {
        return headerService;
    }

    public List<WebElement> getHeaderServiceDropdown() {
        return headerServiceDropdown;
    }

    public WebElement getLeftService() {
        return leftService;
    }

    public List<WebElement> getLeftServiceDropdown() {
        return leftServiceDropdown;
    }

    public WebElement getDifferentElementsButton() {
        return differentElementsButton;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
