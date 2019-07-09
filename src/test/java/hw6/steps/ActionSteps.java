package hw6.steps;

import cucumber.api.java.en.When;
import hw6.entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ActionSteps extends BaseSteps {

    @When("I log in as")
    public void iLogInAsEntity(List<User> users) {
        User user = users.get(0);
        homePage.login(user.getUserName(), user.getPassword());
    }

    @When("I click on 'Service' subcategory in the header")
    public void iClickOnServiceHeaderSubcategory() {
        homePage.getHeaderService().click();
    }

    @When("I click on 'Service' subcategory in the left section")
    public void iClickOnServiceLeftSubcategory() {
        homePage.getLeftService().click();
    }

    @When("I open through the header menu Service -> Different Elements Page")
    public void iOpenThroughTheHeaderMenuServiceDifferentElementsPage() {
        homePage.getHeaderService().click();
        homePage.getDifferentElementsButton().click();
    }

    @When("I select checkboxes")
    public void iSelectCheckboxes(List<String> values) {
        for (String value : values) {
            differentElementsPage.clickCheckBox(value);
        }
    }

    @When("I select radio '(.+)'")
    public void iSelectRadio(String value) {
        differentElementsPage.clickCheckBox(value);
    }

    @When("I select '(.+)' in dropdown")
    public void iSelectColorInDropdown(String color) {
        Select select = new Select(differentElementsPage.getColorsDropdown());
        differentElementsPage.getColorsDropdown().click();
        select.selectByVisibleText(color);
    }

    @When("I unselect checkboxes")
    public void iUnselectCheckboxes(List<String> values) {
        for (String value : values) {
            differentElementsPage.clickCheckBox(value);
        }
    }

    @When("I click on 'User Table' button in Service dropdown")
    public void iClickOnUserTable() {
        homePage.getUserTableButton().click();
    }

    @When("I select '(.+)' checkbox for '(.+)'")
    public void iSelectCheckboxValueForUser(String value, String user) {
        List<String> userTableUsers = new ArrayList<>();
        for (WebElement userName : userTablePage.getUserTableUserNames()) {
            userTableUsers.add(userName.getText());
        }
        userTablePage.getUserTableCheckboxes().get(userTableUsers.indexOf(user)).click();
    }

    @When("I click on dropdown in column Type for user '(.+)'")
    public void iClickOnDropdownInColumnType(String user) {
        List<String> userTableUsers = new ArrayList<>();
        for (WebElement userName : userTablePage.getUserTableUserNames()) {
            userTableUsers.add(userName.getText());
        }
        userTablePage.getNumberTypeDropdowns().get(userTableUsers.indexOf(user)).click();
    }
}
