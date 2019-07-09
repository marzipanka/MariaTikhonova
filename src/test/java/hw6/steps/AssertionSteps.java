package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import enums.HeaderServiceDropdown;
import enums.IndexPageTexts;
import enums.LeftServiceDropdown;
import hw6.hooks.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps extends BaseSteps {

    @Then("URL should be '(.+)'")
    public void urlShouldBe(String url) {
        assertEquals(TestContext.getDriver().getCurrentUrl(), url);
    }

    @Then("Browser title should be equal to '(.+)'")
    public void browserTitleShouldBe(String title) {
        assertEquals(TestContext.getDriver().getTitle(), title);
    }

    @Then("User name in the right-top side of screen should be '(.+)'")
    public void userNameShouldBe(String name) {
        assertEquals(homePage.getUserName(), name);
    }

    @Then("Home Page should contain 4 pictures")
    public void homePageShouldContain4Pictures() {
        List<WebElement> indexPageImages = homePage.getIndexPageImages();
        assertEquals(indexPageImages.size(), 4);

        SoftAssert softAssert = new SoftAssert();
        for (WebElement e : indexPageImages) {
            softAssert.assertTrue(e.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Then("Home Page should contain 4 texts under pictures")
    public void homePageShouldContain4TextsUnderPictures() {
        List<WebElement> webElements = homePage.getIndexPageTexts();
        assertEquals(webElements.size(), IndexPageTexts.values().length);

        List<String> indexPageTexts = new ArrayList<>();
        for (IndexPageTexts element : IndexPageTexts.values()) {
            indexPageTexts.add(element.getName());
        }

        SoftAssert softAssert = new SoftAssert();
        for (WebElement element : webElements) {
            softAssert.assertTrue(indexPageTexts.contains(element.getText()));
        }

        softAssert.assertAll();
    }

    @Then("Home Page should contain headline")
    public void homePageShouldContainHeadline() {
        assertEquals(homePage.getEpamFrameworkWishes().getText(), "EPAM FRAMEWORK WISHES…");
    }

    @Then("Home Page should contain description under headline")
    public void homePageShouldContainDescriptionUnderHeadline() {
        assertTrue(homePage.getLoremIpsum().getText().contains("LOREM IPSUM"));
    }

    @Then("Header Service dropdown should contain options")
    public void headerServiceDropdownShouldContainOptions() {
        List<WebElement> webElements = homePage.getHeaderServiceDropdown();
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

    @Then("Left Service dropdown should contain options")
    public void leftServiceDropdownShouldContainOptions() {
        List<WebElement> webElements = homePage.getLeftServiceDropdown();
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

    @Then("Different Elements Page should contain 4 checkboxes")
    public void differentElementsPageShouldContain4Checkboxes() {
        assertEquals(differentElementsPage.getCheckboxes().size(), 4);
    }

    @Then("Different Elements Page should contain 4 radios")
    public void differentElementsPageShouldContain4Radios() {
        assertEquals(differentElementsPage.getRadios().size(), 4);
    }

    @Then("Different Elements Page should contain 1 dropdown")
    public void differentElementsPageShouldContain1Dropdown() {
        checkElementIsDisplayed(differentElementsPage.getColors());
    }

    @Then("Different Elements Page should contain 2 buttons")
    public void differentElementsPageShouldContain2Buttons() {
        checkElementIsDisplayed(differentElementsPage.getDefaultButton());
        checkElementIsDisplayed(differentElementsPage.getButton());
    }

    @Then("Right section should be displayed")
    public void rightSectionShouldBeDisplayed() {
        checkElementIsDisplayed(differentElementsPage.getRightSection());
    }

    @Then("Left section should be displayed")
    public void leftSectionShouldBeDisplayed() {
        checkElementIsDisplayed(homePage.getLeftSection());
    }

    @Then("Elements should be checked")
    public void elementsShouldBeChecked(List<String> values) {
        for (String value : values) {
            assertEquals(differentElementsPage.checkCheckBoxIsSelected(value), true);
        }
    }

    @Then("Log row should be displayed '(.+)' '(.+)' '(.+)'")
    public void logRowShouldBeDisplayed(String type, String value, String condition) {
        assertTrue(differentElementsPage.checkLogRowIsDisplayed(type, value, condition));
    }

    @Then("'(.+)' element should be checked")
    public void elementShouldBeChecked(String value) {
        assertEquals(differentElementsPage.checkCheckBoxIsSelected(value), true);
    }

    @Then("Elements should be unselected")
    public void elementsShouldBeUnselected(List<String> values) {
        for (String value : values) {
            assertEquals(differentElementsPage.checkCheckBoxIsSelected(value), false);
        }
    }

    @Then("6 NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void sixNumberTypeDropdownsAreDisplayedOnUsersTablePage() {
        assertEquals(userTablePage.getNumberTypeDropdowns().size(), 6);
        for (int i = 0; i < userTablePage.getNumberTypeDropdowns().size(); i++) {
            checkElementIsDisplayed(userTablePage.getNumberTypeDropdowns().get(i));
        }
    }

    @Then("6 User names are displayed on Users Table on User Table Page")
    public void sixUserNamesAreDisplayedOnUserTablePage() {
        assertEquals(userTablePage.getUserTableUserNames().size(), 6);
        for (int i = 0; i < userTablePage.getUserTableUserNames().size(); i++) {
            checkElementIsDisplayed(userTablePage.getUserTableUserNames().get(i));
        }
    }

    @Then("6 Description images are displayed on Users Table on User Table Page")
    public void sixDescriptionImagesAreDisplayedOnUserTablePage() {
        assertEquals(userTablePage.getUserTableImages().size(), 6);
        for (int i = 0; i < userTablePage.getUserTableImages().size(); i++) {
            checkElementIsDisplayed(userTablePage.getUserTableImages().get(i));
        }
    }

    @Then("6 Description texts under images are displayed on Users Table on User Table Page")
    public void sixDescriptionTextsUnderImagesAreDisplayed() {
        assertEquals(userTablePage.getTextsUnderUserTableImages().size(), 6);
        for (int i = 0; i < userTablePage.getTextsUnderUserTableImages().size(); i++) {
            checkElementIsDisplayed(userTablePage.getTextsUnderUserTableImages().get(i));
        }
    }

    @Then("6 checkboxes are displayed on Users Table on User Table Page")
    public void sixCheckboxesAreDisplayedOnUserTablePage() {
        assertEquals(userTablePage.getUserTableCheckboxes().size(), 6);
        for (int i = 0; i < userTablePage.getUserTableCheckboxes().size(); i++) {
            checkElementIsDisplayed(userTablePage.getUserTableCheckboxes().get(i));
        }
    }

    @Then("User table contains following values:")
    public void userTableContainsFollowingValues(DataTable dt) {
        List<Map<String, String>> expectedValues = dt.asMaps(String.class, String.class);
        for (int i = 0; i < 6; i++) {
            assertEquals(userTablePage.getUserTableUserNames().get(i).getText(), expectedValues.get(i).get("User"));
            assertTrue(userTablePage.getTextsUnderUserTableImages().get(i).getText().contains(expectedValues.get(i).get("Description")));
        }
    }

    @Then("Droplist contains values")
    public void droplistContainsValues(List<String> values) {
        List<WebElement> actualValues = TestContext.getDriver().findElements(By.tagName("option"));
        List<String> actualValuesTexts = new ArrayList<>();
        for (WebElement actualValue : actualValues) {
            actualValuesTexts.add(actualValue.getText());
        }
        for (String actualValuesText : actualValuesTexts) {
            values.contains(actualValuesText);
        }
    }
}
