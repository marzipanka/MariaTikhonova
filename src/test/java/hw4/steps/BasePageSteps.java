package hw4.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.HeaderServiceDropdown;
import enums.LeftServiceDropdown;
import hw4.BasePage;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BasePageSteps {

    private BasePage basePage;

    public BasePageSteps() {
        basePage = Selenide.open("https://epam.github.io/JDI/index.html", BasePage.class);
    }

    public void assertBrowserTitle(String title) {
        assertEquals(basePage.getBrowserTitle(), title);
    }

    public void login(String username, String password) {
        basePage.login(username, password);
    }

    public void assertUserName(String name) {
        basePage.getUserName().shouldBe(text(name));
    }

    public void checkHeaderServiceDropdownContainsOptions() {

        List<SelenideElement> webElements = basePage.getHeaderServiceDropdown();
        assertEquals(webElements.size(), HeaderServiceDropdown.values().length);

        List<String> headerServiceDropdown = new ArrayList<>();
        for (HeaderServiceDropdown element : HeaderServiceDropdown.values()) {
            headerServiceDropdown.add(element.getName());
        }

        SoftAssert softAssert = new SoftAssert();
        for (SelenideElement element : webElements) {
            softAssert.assertTrue(headerServiceDropdown.contains(element.getText()));
        }

        softAssert.assertAll();
    }

    public void checkLeftServiceDropdownContainsOptions() {

        List<SelenideElement> webElements = basePage.getLeftServiceDropdown();
        assertEquals(webElements.size(), LeftServiceDropdown.values().length);

        List<String> leftServiceDropdown = new ArrayList<>();
        for (LeftServiceDropdown element : LeftServiceDropdown.values()) {
            leftServiceDropdown.add(element.getName());
        }

        SoftAssert softAssert = new SoftAssert();
        for (SelenideElement element : webElements) {
            softAssert.assertTrue(leftServiceDropdown.contains(element.text()));
        }

        softAssert.assertAll();
    }

    public void checkElementIsDisplayed(SelenideElement element) {
        assertTrue(element.isDisplayed());
    }

    public void checkLeftSectionIsDisplayed() {
        checkElementIsDisplayed(basePage.getLeftSection());
    }

    public void clickHeaderService() {
        basePage.getHeaderService().click();
    }

    public void clickTableWithPagesButton() {
        basePage.getTableWithPagesButton().click();

    }

    public void clickLeftService() {
        basePage.getLeftService().click();
    }

    public void clickMetalsAndColorsButton() {
        basePage.getMetalsAndColorsButton().click();
    }

    public void assertCurrentUrl(String url) {
        assertEquals(basePage.getCurrentUrl(), url);
    }

    public void logout() {
        basePage.getUserIcon().click();
        $(byText("Logout")).click();
    }
}
