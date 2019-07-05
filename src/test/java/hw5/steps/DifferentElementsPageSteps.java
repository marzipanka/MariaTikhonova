package hw5.steps;

import hw5.DifferentElementsPage;
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

    public void assertNumberOfCheckboxes() {
        assertEquals(differentElementsPage.getCheckboxes().size(), 4);
    }

    public void assertNumberOfRadios() {
        assertEquals(differentElementsPage.getRadios().size(), 4);
    }

    public void checkColorsAreDisplayed() {
        checkElementIsDisplayed(differentElementsPage.getColors());
    }

    public void checkDefaultButtonIsDisplayed() {
        checkElementIsDisplayed(differentElementsPage.getDefaultButton());
    }

    public void checkButtonIsDisplayed() {
        checkElementIsDisplayed(differentElementsPage.getButton());
    }

    public void checkRightSectionIsDisplayed() {
        checkElementIsDisplayed(differentElementsPage.getRightSection());
    }

    public void clickCheckbox(String value) {
        differentElementsPage.clickCheckBox(value);
    }

    public void checkCheckboxIsSelected(String value, boolean expected) {
        assertEquals(differentElementsPage.checkCheckBoxIsSelected(value), expected);
    }

    public void checkLogRowOfCheckbox(String type, String value, String condition) {
        assertTrue(differentElementsPage.checkLogRowIsDisplayed(type, value, condition));
    }

    public void selectDropdownOption(String option) {
        Select select = new Select(differentElementsPage.getColorsDropdown());
        differentElementsPage.getColorsDropdown().click();
        select.selectByVisibleText(option);
    }
}



