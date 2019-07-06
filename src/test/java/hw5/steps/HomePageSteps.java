package hw5.steps;

import enums.IndexPageTexts;
import hw5.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps extends BasePageSteps {

    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    @Step("Check all 4 images are displayed")
    public void checkAllImagesAreDisplayed() {
        List<WebElement> indexPageImages = homePage.getIndexPageImages();
        assertEquals(indexPageImages.size(), 4);

        SoftAssert softAssert = new SoftAssert();
        for (WebElement e : indexPageImages) {
            softAssert.assertTrue(e.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check all 4 texts are displayed")
    public void checkAllTextsAreDisplayed() {
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

    @Step("Check 'EPAM FRAMEWORK WISHES...' text")
    public void checkEpamFrameworkWishesText() {
        assertEquals(homePage.getEpamFrameworkWishes().getText(), "EPAM FRAMEWORK WISHES…");
    }

    @Step("Check 'LOREM IPSUM' text")
    public void checkLoremIpsumText() {
        assertTrue(homePage.getLoremIpsum().getText().contains("LOREM IPSUM"));
    }

    @Step("Check iframe is displayed")
    public void checkIframeIsDisplayed() {
        assertTrue(homePage.getIframe().isDisplayed());
    }

    @Step("Check EPAM logo in the iframe is displayed")
    public void checkEpamLogoIsDisplayed() {
        homePage.switchToIframe();
        checkElementIsDisplayed(homePage.getEpamLogo());
    }

    @Step("Switch to original content")
    public void switchToDefaultContent() {
        homePage.switchToDefaultContent();
    }

    @Step("Check subheader is displayed")
    public void checkSubHeaderIsDisplayed() {
        checkElementIsDisplayed(homePage.getSubHeader());
    }

    @Step("Check 'JDI GITHUB' had proper text")
    public void checkJdiGithubHasProperText() {
        checkElementHasProperText(homePage.getJdiGithub(), "JDI GITHUB");
    }

}
