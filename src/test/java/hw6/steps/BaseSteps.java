package hw6.steps;

import hw6.DifferentElementsPage;
import hw6.HomePage;
import hw6.UserTablePage;
import hw6.hooks.TestContext;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public abstract class BaseSteps {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public BaseSteps() {
        homePage = HomePage.getInstance(TestContext.getDriver());
        differentElementsPage = DifferentElementsPage.getInstance(TestContext.getDriver());
        userTablePage = UserTablePage.getInstance(TestContext.getDriver());
    }

    public void checkElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }
}
