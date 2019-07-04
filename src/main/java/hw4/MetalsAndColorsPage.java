package hw4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class MetalsAndColorsPage extends BasePage {

    @FindBy(id = "calculate-button")
    private SelenideElement calculateButton;

    @FindBy(id = "submit-button")
    private SelenideElement submitButton;

    @FindBy(css = "div[id='colors']")
    private SelenideElement colorsDropdown;

    @FindBy(xpath = "//div[@id='metals']/div/button/span[@class='caret']")
    private SelenideElement metalsDropdown;

    @FindBy(xpath = "//div[@id='salad-dropdown']/button")
    private SelenideElement vegetablesDropdown;

    @FindBy(className = "summ-res")
    private SelenideElement summaryLogRow;

    @FindBy(className = "elem-res")
    private SelenideElement elementsLogRow;

    @FindBy(className = "col-res")
    private SelenideElement colorsLogRow;

    @FindBy(className = "met-res")
    private SelenideElement metalsLogRow;

    @FindBy(className = "sal-res")
    private SelenideElement vegetablesLogRow;

    public MetalsAndColorsPage() {
        page(this);
    }

    public SelenideElement getCalculateButton() {
        return calculateButton;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    public SelenideElement getColorsDropdown() {
        return colorsDropdown;
    }

    public SelenideElement getMetalsDropdown() {
        return metalsDropdown;
    }

    public SelenideElement getVegetablesDropdown() {
        return vegetablesDropdown;
    }

    public SelenideElement getSummaryLogRow() {
        return summaryLogRow;
    }

    public SelenideElement getElementsLogRow() {
        return elementsLogRow;
    }

    public SelenideElement getColorsLogRow() {
        return colorsLogRow;
    }

    public SelenideElement getMetalsLogRow() {
        return metalsLogRow;
    }

    public SelenideElement getVegetablesLogRow() {
        return vegetablesLogRow;
    }
}
