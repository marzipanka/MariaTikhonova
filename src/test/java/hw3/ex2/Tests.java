package hw3.ex2;

import hw3.BaseClass;
import hw3.steps.DifferentElementsPageSteps;
import hw3.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BaseClass {

    private HomePageSteps homePageSteps;
    private DifferentElementsPageSteps differentElementsPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
        differentElementsPageSteps = new DifferentElementsPageSteps(driver);
    }

    @Test
    public void secondTest() {

        // 2. Assert Browser title
        homePageSteps.assertBrowserTitle("Home Page");

        // 3. Perform login
        homePageSteps.login(login, password);

        // 4. Assert User name in the right-top side of screen that user is logged in
        homePageSteps.assertUserName(userName);

        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        homePageSteps.clickHeaderService();
        homePageSteps.checkHeaderServiceDropdownContainsOptions();

        // 6. Click on Service subcategory in the left section and check that drop down contains options
        homePageSteps.clickLeftService();
        homePageSteps.checkLeftServiceDropdownContainsOptions();

        // 7. Open through the header menu Service -> Different Elements Page
        homePageSteps.clickHeaderService();
        homePageSteps.clickDifferentElementsButton();
        homePageSteps.assertCurrentUrl("https://epam.github.io/JDI/different-elements.html");

        // 8. Check interface on Different elements page, it contains all needed elements
        differentElementsPageSteps.assertNumberOfCheckboxes();
        differentElementsPageSteps.assertNumberOfRadios();
        differentElementsPageSteps.checkColorsAreDisplayed();
        differentElementsPageSteps.checkDefaultButtonIsDisplayed();
        differentElementsPageSteps.checkButtonIsDisplayed();

        // 9. Assert that there is Right Section
        differentElementsPageSteps.checkRightSectionIsDisplayed();

        // 10. Assert that there is Left Section
        differentElementsPageSteps.checkLeftSectionIsDisplayed();

        // 11. Select checkboxes
        differentElementsPageSteps.clickCheckbox("Water");
        differentElementsPageSteps.checkCheckboxIsSelected("Water", true);
        differentElementsPageSteps.clickCheckbox("Wind");
        differentElementsPageSteps.checkCheckboxIsSelected("Wind", true);

        // 12. Assert that for each checkbox there is an individual log row and value
        //     is corresponded to the status of checkbox.
        differentElementsPageSteps.checkLogRowOfCheckbox("Water", "condition", "true");
        differentElementsPageSteps.checkLogRowOfCheckbox("Wind", "condition", "true");

        // 13. Select radio
        differentElementsPageSteps.clickCheckbox("Selen");
        differentElementsPageSteps.checkCheckboxIsSelected("Selen", true);

        // 14. Assert that for radiobutton there is a log row and value is
        //     corresponded to the status of radiobutton.
        differentElementsPageSteps.checkCheckboxIsSelected("Selen", true);
        differentElementsPageSteps.checkLogRowOfCheckbox("metal", "value", " Selen");

        // 15. Select in dropdown
        differentElementsPageSteps.selectDropdownOption("Yellow");

        // 16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPageSteps.checkLogRowOfCheckbox("Colors", "value", "Yellow");

        // 17. Unselect and assert checkboxes
        differentElementsPageSteps.clickCheckbox("Water");
        differentElementsPageSteps.checkCheckboxIsSelected("Water", false);
        differentElementsPageSteps.clickCheckbox("Wind");
        differentElementsPageSteps.checkCheckboxIsSelected("Wind", false);

        // 18. Assert that for each checkbox there is an individual log row
        //     and value is corresponded to the status of checkbox.
        differentElementsPageSteps.checkLogRowOfCheckbox("Water", "condition", "false");
        differentElementsPageSteps.checkLogRowOfCheckbox("Wind", "condition", "false");
    }

}
