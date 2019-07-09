package hw6.steps;

import cucumber.api.java.en.Given;
import hw6.hooks.TestContext;

public class GivenSteps extends BaseSteps {

    @Given("I am on the JDI index page")
    public void iAmOnTheJdiIndexPage() {
        TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
    }
}