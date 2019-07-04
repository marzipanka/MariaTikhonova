package hw4.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.TableWithPagesPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;

public class TableWithPagesPageSteps extends BasePageSteps {

    private TableWithPagesPage tableWithPagesPage;

    public TableWithPagesPageSteps() {
        super();
        tableWithPagesPage = new TableWithPagesPage();
    }

    public void checkValueOfShowEntries(String value) {
        tableWithPagesPage.getShowEntries().shouldHave(text(value));
    }

    public void checkRightSectionIsDisplayed() {
        checkElementIsDisplayed(tableWithPagesPage.getRightSection());
    }

    public void clickShowEntries() {
        tableWithPagesPage.getShowEntries().click();
    }

    public void selectShowEntriesOption(String option) {
        tableWithPagesPage.getShowEntries().selectOption(option);
    }

    public void checkLogRowOfEntries(String value) {
        tableWithPagesPage.checkLogRowOfEntriesIsDisplayed(value);
    }

    public void checkNumberOfRowsInEntriesTable(int number) {
        tableWithPagesPage.getEntriesTable().shouldHave(size(number));
    }

    public void search(String text) {
        tableWithPagesPage.getSearchField().sendKeys(text);
    }

    public void checkTableRowsContainOnlyProperRecords(String text) {
        ElementsCollection tableRows = tableWithPagesPage.getEntriesTable();
        for (SelenideElement row : tableRows) {
            row.shouldHave(text(text));
        }
    }
}
