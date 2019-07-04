package hw4.ex1;

import hw4.BaseTest;
import hw4.steps.TableWithPagesPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    private TableWithPagesPageSteps tableWithPagesPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        tableWithPagesPage = new TableWithPagesPageSteps();
    }

    @Test
    public void firstTest() {

        // 2. Assert Browser title
        tableWithPagesPage.assertBrowserTitle("Home Page");

        // 3. Perform login
        tableWithPagesPage.login(login, password);

        // 4. Assert User name in the right-top side of screen that user is logged in
        tableWithPagesPage.assertUserName(userName);

        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        tableWithPagesPage.clickHeaderService();
        tableWithPagesPage.checkHeaderServiceDropdownContainsOptions();

        // 6. Click on Service subcategory in the left section and check that drop down contains options
        tableWithPagesPage.clickLeftService();
        tableWithPagesPage.checkLeftServiceDropdownContainsOptions();

        // 7. Open through the header menu Service -> Table with pages
        tableWithPagesPage.clickHeaderService();
        tableWithPagesPage.clickTableWithPagesButton();
        tableWithPagesPage.assertCurrentUrl("https://epam.github.io/JDI/table-pages.html");

        // 8. Check that default value for “Show entries” dropdown is 5
        tableWithPagesPage.checkValueOfShowEntries("5");

        // 9. Assert that there is Right Section
        tableWithPagesPage.checkRightSectionIsDisplayed();

        // 10. Assert that there is Left Section
        tableWithPagesPage.checkLeftSectionIsDisplayed();

        // 11. Select new value for the entries in the dropdown list
        tableWithPagesPage.clickShowEntries();
        tableWithPagesPage.selectShowEntriesOption("10");
        tableWithPagesPage.checkValueOfShowEntries("10");

        // 12. Assert that for the dropdown there is an individual log row
        //     and value is corresponded to the value of dropdown
        tableWithPagesPage.checkLogRowOfEntries("10");

        // 13. Assert that in the table displayed corrected amount of entries
        tableWithPagesPage.checkNumberOfRowsInEntriesTable(10);

        // 14. Type in “Search” text field
        tableWithPagesPage.search("Custom");

        // 15. Assert the table contains only records with Search field value
        tableWithPagesPage.checkTableRowsContainOnlyProperRecords("Custom");

        tableWithPagesPage.logout();

    }
}

