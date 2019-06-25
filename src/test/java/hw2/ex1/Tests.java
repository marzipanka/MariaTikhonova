package hw2.ex1;

import hw2.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Tests extends BaseClass {

    @Test
    public void firstTest() {

        // 5. Assert Browser title
        assertBrowserTitle("Home Page");

        // 6. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerElements = driver.findElements(By.xpath("//ul[contains(@class, 'm-l8')]/li"));
        checkElementsHaveProperTexts(headerElements, Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));


        // 7. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> indexPageImages = driver.findElements(By.className("benefit-icon"));
        checkElementsAreDisplayed(indexPageImages);
        assertEquals(indexPageImages.size(), 4);

        // 8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> indexPageTexts = driver.findElements(By.className("benefit-txt"));
        checkElementsHaveProperTexts(indexPageTexts, Arrays.asList("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project", "To be flexible and\n" +
                        "customizable", "To be multiplatform",
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"));

        // 9. Assert a text of the main headers
        assertEquals(driver.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(driver.findElement(By.name("jdi-text")).getText().contains("LOREM IPSUM"));

        // 10. Assert that there is the iframe in the center of page
        checkElementIsDisplayed(driver.findElement(By.id("iframe")));

        // 11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        checkElementIsDisplayed(driver.findElement(By.id("epam_logo")));

        // 12. Switch to original window back
        driver.switchTo().defaultContent();

        // 13. Assert a text of the sub header
        checkElementIsDisplayed(driver.findElement(By.linkText("JDI GITHUB")));

        // 14. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver.findElement(By.xpath("//a[@href = 'https://github.com/epam/JDI']")).getText(), "JDI GITHUB");

        // 15. Assert that there is Left Section
        checkElementIsDisplayed(driver.findElement(By.id("mCSB_1_container")));

        // 16. Assert that there is Footer
        checkElementIsDisplayed(driver.findElement(By.tagName("footer")));

    }
}

