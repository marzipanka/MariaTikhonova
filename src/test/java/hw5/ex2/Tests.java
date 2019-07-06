package hw5.ex2;

import enums.Colors;
import enums.Conditions;
import enums.Metals;
import hw5.AllureAttachmentListener;
import hw5.BaseTest;
import hw5.steps.DifferentElementsPageSteps;
import hw5.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureAttachmentListener.class)
@Feature("Testing JDI site")
@Story("Testing Different Elements Page")
public class Tests extends BaseTest {

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
        differentElementsPageSteps.clickCheckbox(Conditions.WATER.getName());
        differentElementsPageSteps.checkCheckboxIsSelected(Conditions.WATER.getName(), true);
        differentElementsPageSteps.clickCheckbox(Conditions.WIND.getName());
        differentElementsPageSteps.checkCheckboxIsSelected(Conditions.WIND.getName(), true);

        // 12. Assert that for each checkbox there is an individual log row and value
        //     is corresponded to the status of checkbox.
        differentElementsPageSteps.checkLogRowOfCheckbox(Conditions.WATER.getName(), "condition", "true");
        differentElementsPageSteps.checkLogRowOfCheckbox(Conditions.WIND.getName(), "condition", "true");

        // 13. Select radio
        differentElementsPageSteps.clickCheckbox(Metals.SELEN.getName());
        differentElementsPageSteps.checkCheckboxIsSelected(Metals.SELEN.getName(), true);

        // 14. Assert that for radiobutton there is a log row and value is
        //     corresponded to the status of radiobutton.
        differentElementsPageSteps.checkCheckboxIsSelected(Metals.SELEN.getName(), true);
        differentElementsPageSteps.checkLogRowOfCheckbox("metal", "value", " Selen");

        // 15. Select in dropdown
        differentElementsPageSteps.selectDropdownOption(Colors.YELLOW.getName());

        // 16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPageSteps.checkLogRowOfCheckbox("Colors", "value", Colors.YELLOW.getName());

        // 17. Unselect and assert checkboxes
        differentElementsPageSteps.clickCheckbox(Conditions.WATER.getName());
        differentElementsPageSteps.checkCheckboxIsSelected(Conditions.WATER.getName(), false);
        differentElementsPageSteps.clickCheckbox(Conditions.WIND.getName());
        differentElementsPageSteps.checkCheckboxIsSelected(Conditions.WIND.getName(), false);

        // 18. Assert that for each checkbox there is an individual log row
        //     and value is corresponded to the status of checkbox.
        differentElementsPageSteps.checkLogRowOfCheckbox(Conditions.WATER.getName(), "condition", "false");
        differentElementsPageSteps.checkLogRowOfCheckbox(Conditions.WIND.getName(), "condition", "false");
    }

}
