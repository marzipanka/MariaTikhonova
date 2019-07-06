package hw5.steps;

import hw5.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps extends BasePageSteps {

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        super(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step("Assert number of checkboxes")
    public void assertNumberOfCheckboxes() {
        assertEquals(differentElementsPage.getCheckboxes().size(), 4);
    }

    @Step("Assert number of radios")
    public void assertNumberOfRadios() {
        assertEquals(differentElementsPage.getRadios().size(), 4);
    }

    @Step("Check colors are displayed")
    public void checkColorsAreDisplayed() {
        checkElementIsDisplayed(differentElementsPage.getColors());
    }

    @Step("Check default button is displayed")
    public void checkDefaultButtonIsDisplayed() {
        checkElementIsDisplayed(differentElementsPage.getDefaultButton());
    }

    @Step("Check button is displayed")
    public void checkButtonIsDisplayed() {
        checkElementIsDisplayed(differentElementsPage.getButton());
    }

    @Step("Check right section is displayed")
    public void checkRightSectionIsDisplayed() {
        checkElementIsDisplayed(differentElementsPage.getRightSection());
    }

    @Step("Click checkbox: '{0}'")
    public void clickCheckbox(String value) {
        differentElementsPage.clickCheckBox(value);
    }

    @Step("Check selection of '{0}' checkbox is '{1}'")
    public void checkCheckboxIsSelected(String value, boolean expected) {
        assertEquals(differentElementsPage.checkCheckBoxIsSelected(value), expected);
    }

    @Step("Check log row of '{0}' changes to '{2}'")
    public void checkLogRowOfCheckbox(String type, String value, String condition) {
        assertTrue(differentElementsPage.checkLogRowIsDisplayed(type, value, condition));
    }

    @Step("Select dropdown option '{0}'")
    public void selectDropdownOption(String option) {
        Select select = new Select(differentElementsPage.getColorsDropdown());
        differentElementsPage.getColorsDropdown().click();
        select.selectByVisibleText(option);
    }
}



