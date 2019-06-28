package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends BasePage {

    protected WebDriver driver;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(className = "colors")
    private WebElement colors;

    @FindBy(name = "Default Button")
    private WebElement defaultButton;

    @FindBy(css = "input[value='Button']")
    private WebElement button;

    @FindBy(name = "log-sidebar")
    private WebElement rightSection;

    @FindBy(css = "select[class='uui-form-element']")
    private WebElement colorsDropdown;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public WebElement getColors() {
        return colors;
    }

    public WebElement getDefaultButton() {
        return defaultButton;
    }

    public WebElement getButton() {
        return button;
    }

    public WebElement getRightSection() {
        return rightSection;
    }

    public WebElement getColorsDropdown() {
        return colorsDropdown;
    }

    public void clickCheckBox(String value) {
        driver.findElement(By.xpath(String.format("//label[text()[contains(.,'%s')]]/input", value))).click();
    }

    public boolean checkCheckBoxIsSelected(String value) {
        return driver.findElement(By.xpath(String.format("//label[text()[contains(.,'%s')]]/input", value))).isSelected();
    }

    public boolean checkLogRowIsDisplayed(String type, String value, String condition) {
        return driver.findElement(By.xpath(String.format("//li[text()[contains(.,'%s: %s changed to %s')]]", type, value, condition))).isDisplayed();
    }
}
