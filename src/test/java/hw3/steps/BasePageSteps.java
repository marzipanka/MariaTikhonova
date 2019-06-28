package hw3.steps;

import enums.HeaderMenu;
import enums.HeaderServiceDropdown;
import enums.LeftServiceDropdown;
import hw3.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BasePageSteps {

    private BasePage basePage;

    public BasePageSteps(WebDriver driver) {
        basePage = new BasePage(driver);
        PageFactory.initElements(driver, this);
    }

    public void assertBrowserTitle(String title) {
        assertEquals(basePage.getBrowserTitle(), title);
    }

    public void login(String username, String password) {
        basePage.login(username, password);
    }

    public void assertUserName(String name) {
        assertEquals(basePage.getUserName(), name);
    }

    public void checkHeaderElementsHaveProperTexts() {

        List<WebElement> webElements = basePage.getHeaderElements();
        assertEquals(webElements.size(), HeaderMenu.values().length);

        SoftAssert softAssert = new SoftAssert();
        int i = 0;
        for (HeaderMenu element : HeaderMenu.values()) {
            softAssert.assertEquals(webElements.get(i).getText(), element.getName());
            i++;
        }

        softAssert.assertAll();
    }

    public void checkHeaderServiceDropdownContainsOptions() {

        List<WebElement> webElements = basePage.getHeaderServiceDropdown();
        assertEquals(webElements.size(), HeaderServiceDropdown.values().length);

        SoftAssert softAssert = new SoftAssert();
        int i = 0;
        for (HeaderServiceDropdown element : HeaderServiceDropdown.values()) {
            softAssert.assertEquals(webElements.get(i).getText(), element.getName());
            i++;
        }

        softAssert.assertAll();
    }

    public void checkLeftServiceDropdownContainsOptions() {

        List<WebElement> webElements = basePage.getLeftServiceDropdown();
        assertEquals(webElements.size(), LeftServiceDropdown.values().length);

        SoftAssert softAssert = new SoftAssert();
        int i = 0;
        for (LeftServiceDropdown element : LeftServiceDropdown.values()) {
            softAssert.assertEquals(webElements.get(i).getText(), element.getName());
            i++;
        }

        softAssert.assertAll();
    }

    public void checkElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    public void checkElementHasProperText(WebElement element, String text) {
        assertEquals(element.getText(), text);
    }

    public void checkLeftSectionIsDisplayed() {
        checkElementIsDisplayed(basePage.getLeftSection());
    }

    public void checkFooterIsDisplayed() {
        checkElementIsDisplayed(basePage.getFooter());
    }

    public void clickHeaderService() {
        basePage.getHeaderService().click();
    }

    public void clickLeftService() {
        basePage.getLeftService().click();
    }

    public void clickDifferentElementsButton() {
        basePage.getDifferentElementsButton().click();
    }

    public void assertCurrentUrl(String url) {
        assertEquals(basePage.getCurrentUrl(), url);
    }
}
