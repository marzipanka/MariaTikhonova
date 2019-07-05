package hw5.steps;

import enums.IndexPageTexts;
import hw5.HomePage;
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

    public void checkAllImagesAreDisplayed() {
        List<WebElement> indexPageImages = homePage.getIndexPageImages();
        assertEquals(indexPageImages.size(), 4);

        SoftAssert softAssert = new SoftAssert();
        for (WebElement e : indexPageImages) {
            softAssert.assertTrue(e.isDisplayed());
        }
        softAssert.assertAll();
    }

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

    public void checkEpamFrameworkWishesText() {
        assertEquals(homePage.getEpamFrameworkWishes().getText(), "EPAM FRAMEWORK WISHES…");
    }

    public void checkLoremIpsumText() {
        assertTrue(homePage.getLoremIpsum().getText().contains("LOREM IPSUM"));
    }

    public void checkIframeIsDisplayed() {
        assertTrue(homePage.getIframe().isDisplayed());
    }

    public void checkEpamLogoIsDisplayed() {
        homePage.switchToIframe();
        checkElementIsDisplayed(homePage.getEpamLogo());
    }

    public void switchToDefaultContent() {
        homePage.switchToDefaultContent();
    }

    public void checkSubHeaderIsDisplayed() {
        checkElementIsDisplayed(homePage.getSubHeader());
    }

    public void checkJdiGithubHasProperText() {
        checkElementHasProperText(homePage.getJdiGithub(), "JDI GITHUB");
    }

}
