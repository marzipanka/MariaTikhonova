package hw5;

import hw5.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureAttachmentListener.class)
@Feature("Testing JDI site")
@Story("Testing Home Page (but it's going to fail)")
public class FailTest extends BaseTest {

    private HomePageSteps homePageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
    }

    @Test
    public void failTest() {

        // 2. Assert Browser title
        homePageSteps.assertBrowserTitle("Hello");

        // 3. Perform login
        homePageSteps.login(login, password);

        // 4. Assert User name in the right-top side of screen that user is logged in
        homePageSteps.assertUserName(userName);

        // 5. Assert Browser title
        homePageSteps.assertBrowserTitle("Home Page");

        // 6. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePageSteps.checkHeaderElementsHaveProperTexts();

        // 7. Assert that there are 4 images on the Index Page and they are displayed
        homePageSteps.checkAllImagesAreDisplayed();

        // 8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageSteps.checkAllTextsAreDisplayed();

        // 9. Assert a text of the main headers
        homePageSteps.checkEpamFrameworkWishesText();
        homePageSteps.checkLoremIpsumText();

        // 10. Assert that there is the iframe in the center of page
        homePageSteps.checkIframeIsDisplayed();

        // 11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePageSteps.checkEpamLogoIsDisplayed();

        // 12. Switch to original window back
        homePageSteps.switchToDefaultContent();

        // 13. Assert a text of the sub header
        homePageSteps.checkSubHeaderIsDisplayed();

        // 14. Assert that JDI GITHUB is a link and has a proper URL
        homePageSteps.checkJdiGithubHasProperText();

        // 15. Assert that there is Left Section
        homePageSteps.checkLeftSectionIsDisplayed();

        // 16. Assert that there is Footer
        homePageSteps.checkFooterIsDisplayed();

    }
}

