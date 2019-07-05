package hw5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    protected WebDriver driver;

    @FindBy(className = "benefit-icon")
    private List<WebElement> indexPageImages;

    @FindBy(className = "benefit-txt")
    private List<WebElement> indexPageTexts;

    @FindBy(name = "main-title")
    private WebElement epamFrameworkWishes;

    @FindBy(name = "jdi-text")
    private WebElement loremIpsum;

    @FindBy(id = "iframe")
    private WebElement iframe;

    @FindBy(id = "epam_logo")
    private WebElement epamLogo;

    @FindBy(linkText = "JDI GITHUB")
    private WebElement subHeader;

    @FindBy(xpath = "//a[@href = 'https://github.com/epam/JDI']")
    private WebElement jdiGithub;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public List<WebElement> getIndexPageImages() {
        return indexPageImages;
    }

    public List<WebElement> getIndexPageTexts() {
        return indexPageTexts;
    }

    public WebElement getEpamFrameworkWishes() {
        return epamFrameworkWishes;
    }

    public WebElement getLoremIpsum() {
        return loremIpsum;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getEpamLogo() {
        return epamLogo;
    }

    public WebElement getSubHeader() {
        return subHeader;
    }

    public WebElement getJdiGithub() {
        return jdiGithub;
    }

    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }


}