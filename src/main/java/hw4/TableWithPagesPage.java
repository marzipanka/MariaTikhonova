package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TableWithPagesPage extends BasePage {

    @FindBy(css = "select[name='table-with-pages_length']")
    private SelenideElement showEntries;
    @FindBy(name = "log-sidebar")
    private SelenideElement rightSection;
    @FindBy(xpath = "//tbody/tr[@role='row']")
    private ElementsCollection entriesTable;
    @FindBy(css = "input[type='search']")
    private SelenideElement searchField;

    public TableWithPagesPage() {
        page(this);
    }

    public SelenideElement getShowEntries() {
        return showEntries;
    }

    public SelenideElement getRightSection() {
        return rightSection;
    }

    public void checkLogRowOfEntriesIsDisplayed(String value) {
        $(By.xpath("//li[contains(text(),'draw')]")).isDisplayed();
        $(By.xpath(String.format("//li[contains(text(),'length, new value=%s')]", value))).isDisplayed();
    }

    public ElementsCollection getEntriesTable() {
        return entriesTable;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }
}
