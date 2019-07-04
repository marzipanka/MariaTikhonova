package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class BasePage {

    @FindBy(id = "user-icon")
    private SelenideElement userIcon;

    @FindBy(id = "name")
    private SelenideElement loginNameTextField;

    private SelenideElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    private SelenideElement loginButton;

    @FindBy(id = "user-name")
    private SelenideElement userName;

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li")
    private ElementsCollection headerElements;

    @FindBy(id = "mCSB_1_container")
    private SelenideElement leftSection;

    @FindBy(tagName = "footer")
    private SelenideElement footer;

    @FindBy(className = "dropdown-toggle")
    private SelenideElement headerService;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li")
    private ElementsCollection headerServiceDropdown;

    @FindBy(css = "a[ui='label']")
    private SelenideElement leftService;

    @FindBy(xpath = "//ul[@class='sub']/li")
    private ElementsCollection leftServiceDropdown;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private SelenideElement differentElementsButton;

    @FindBy(linkText = "TABLE WITH PAGES")
    private SelenideElement tableWithPagesButton;

    @FindBy(linkText = "METALS & COLORS")
    private SelenideElement metalsAndColorsButton;

    public BasePage() {
        page(this);
    }

    public String getBrowserTitle() {
        return Selenide.title();
    }

    public void login(String username, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public SelenideElement getUserIcon() {
        return userIcon;
    }

    public SelenideElement getUserName() {
        return userName;
    }

    public SelenideElement getLeftSection() {
        return leftSection;
    }

    public SelenideElement getHeaderService() {
        return headerService;
    }

    public ElementsCollection getHeaderServiceDropdown() {
        return headerServiceDropdown;
    }

    public SelenideElement getLeftService() {
        return leftService;
    }

    public ElementsCollection getLeftServiceDropdown() {
        return leftServiceDropdown;
    }

    public SelenideElement getTableWithPagesButton() {
        return tableWithPagesButton;
    }

    public SelenideElement getMetalsAndColorsButton() {
        return metalsAndColorsButton;
    }

    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }
}
