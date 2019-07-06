package hw5.steps;

import enums.HeaderMenu;
import enums.HeaderServiceDropdown;
import enums.LeftServiceDropdown;
import hw5.BasePage;
import hw5.TestProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BasePageSteps {

    private BasePage basePage;

    public BasePageSteps(WebDriver driver) {
        basePage = new BasePage(driver);
        PageFactory.initElements(driver, this);
        TestProvider.getInstance().setDriver(driver);

    }

    @Step("Assert browser title: '{0}'")
    public void assertBrowserTitle(String title) {
        assertEquals(basePage.getBrowserTitle(), title);
    }

    @Step("Log in as user: '{0}'")
    public void login(String username, String password) {
        basePage.login(username, password);
    }

    @Step("Assert user name: '{0}'")
    public void assertUserName(String name) {
        assertEquals(basePage.getUserName(), name);
    }

    @Step("Check header elements have proper texts")
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

    @Step("Check header service dropdown contains options")
    public void checkHeaderServiceDropdownContainsOptions() {

        List<WebElement> webElements = basePage.getHeaderServiceDropdown();
        assertEquals(webElements.size(), HeaderServiceDropdown.values().length);

        List<String> headerServiceDropdown = new ArrayList<>();
        for (HeaderServiceDropdown element : HeaderServiceDropdown.values()) {
            headerServiceDropdown.add(element.getName());
        }

        SoftAssert softAssert = new SoftAssert();
        for (WebElement element : webElements) {
            softAssert.assertTrue(headerServiceDropdown.contains(element.getText()));
        }

        softAssert.assertAll();
    }

    @Step("Check left service dropdown contains options")
    public void checkLeftServiceDropdownContainsOptions() {

        List<WebElement> webElements = basePage.getLeftServiceDropdown();
        assertEquals(webElements.size(), LeftServiceDropdown.values().length);

        List<String> leftServiceDropdown = new ArrayList<>();
        for (LeftServiceDropdown element : LeftServiceDropdown.values()) {
            leftServiceDropdown.add(element.getName());
        }

        SoftAssert softAssert = new SoftAssert();
        for (WebElement element : webElements) {
            softAssert.assertTrue(leftServiceDropdown.contains(element.getText()));
        }

        softAssert.assertAll();
    }

    public void checkElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    public void checkElementHasProperText(WebElement element, String text) {
        assertEquals(element.getText(), text);
    }

    @Step("Check left section is displayed")
    public void checkLeftSectionIsDisplayed() {
        checkElementIsDisplayed(basePage.getLeftSection());
    }

    @Step("Check footer is displayed")
    public void checkFooterIsDisplayed() {
        checkElementIsDisplayed(basePage.getFooter());
    }

    public void clickHeaderService() {
        basePage.getHeaderService().click();
    }

    public void clickLeftService() {
        basePage.getLeftService().click();
    }

    @Step("Go to different elements page")
    public void clickDifferentElementsButton() {
        basePage.getDifferentElementsButton().click();
    }

    @Step("Assert current URL: '{0}'")
    public void assertCurrentUrl(String url) {
        assertEquals(basePage.getCurrentUrl(), url);
    }
}
