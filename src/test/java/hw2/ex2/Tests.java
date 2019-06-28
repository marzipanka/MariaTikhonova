package hw2.ex2;

import hw2.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class Tests extends BaseClass {

    @Test
    public void secondTest() {

        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.className("dropdown-toggle")).click();
        List<WebElement> serviceOptionsTop = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
        checkServiceDropDownContainsOptions(serviceOptionsTop, true);

        // 6. Click on Service subcategory in the left section and check that drop down contains options
        driver.findElement(By.cssSelector("a[ui='label']")).click();
        List<WebElement> serviceOptionsLeft = driver.findElements(By.xpath("//ul[@class='sub']/li"));
        checkServiceDropDownContainsOptions(serviceOptionsLeft, false);

        // 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.linkText("DIFFERENT ELEMENTS")).click();
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/different-elements.html");

        // 8. Check interface on Different elements page, it contains all needed elements
        List<WebElement> checkboxes = driver.findElements(By.className("label-checkbox"));
        assertEquals(checkboxes.size(), 4);
        List<WebElement> radios = driver.findElements(By.className("label-radio"));
        assertEquals(radios.size(), 4);
        checkElementIsDisplayed(driver.findElement(By.className("colors")));
        checkElementIsDisplayed(driver.findElement(By.name("Default Button")));
        checkElementIsDisplayed(driver.findElement(By.cssSelector("input[value='Button']")));

        // 9. Assert that there is Right Section
        checkElementIsDisplayed(driver.findElement(By.name("log-sidebar")));

        // 10. Assert that there is Left Section
        checkElementIsDisplayed(driver.findElement(By.name("navigation-sidebar")));

        // 11. Select checkboxes
        clickCheckBox("Water");
        assertTrue(checkCheckBoxIsSelected("Water"));
        clickCheckBox("Wind");
        assertTrue(checkCheckBoxIsSelected("Wind"));

        // 12. Assert that for each checkbox there is an individual log row and value
        //     is corresponded to the status of checkbox.
        assertEquals(checkCheckBoxIsSelected("Water"), checkLogRowOfCheckbox("Water", "condition", "true"));
        assertEquals(checkCheckBoxIsSelected("Wind"), checkLogRowOfCheckbox("Wind", "condition", "true"));

        // 13. Select radio
        clickCheckBox("Selen");
        assertTrue(checkCheckBoxIsSelected("Selen"));

        // 14. Assert that for radiobutton there is a log row and value is
        //     corresponded to the status of radiobutton.
        assertEquals(checkCheckBoxIsSelected("Selen"), checkLogRowOfCheckbox("metal", "value", " Selen"));

        // 15. Select in dropdown
        selectDropdownOption("Yellow");

        // 16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        assertTrue(checkLogRowOfCheckbox("Colors", "value", "Yellow"));

        // 17. Unselect and assert checkboxes
        clickCheckBox("Water");
        assertFalse(checkCheckBoxIsSelected("Water"));
        clickCheckBox("Wind");
        assertFalse(checkCheckBoxIsSelected("Wind"));

        // 18. Assert that for each checkbox there is an individual log row
        //     and value is corresponded to the status of checkbox.
        assertEquals(!checkCheckBoxIsSelected("Water"), checkLogRowOfCheckbox("Water", "condition", "false"));
        assertEquals(!checkCheckBoxIsSelected("Wind"), checkLogRowOfCheckbox("Wind", "condition", "false"));
    }

    private void checkServiceDropDownContainsOptions(List<WebElement> webElements, boolean uppercase) {
        List<String> serviceOptions = Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Tables With Pages", "Different Elements");
        if (uppercase) {
            serviceOptions.replaceAll(String::toUpperCase);
        }
        List<String> actualServiceOptions = new ArrayList<>();
        for (WebElement e : webElements) {
            actualServiceOptions.add(e.getText());
        }
        assertFalse(Collections.disjoint(actualServiceOptions, serviceOptions));
    }

    private void clickCheckBox(String value) {
        driver.findElement(By.xpath(String.format("//label[text()[contains(.,'%s')]]/input", value))).click();
    }

    private boolean checkCheckBoxIsSelected(String value) {
        return driver.findElement(By.xpath(String.format("//label[text()[contains(.,'%s')]]/input", value))).isSelected();
    }

    private boolean checkLogRowOfCheckbox(String type, String value, String condition) {
        return driver.findElement(By.xpath(String.format("//li[text()[contains(.,'%s: %s changed to %s')]]", type, value, condition))).isDisplayed();
    }

    private void selectDropdownOption(String option) {
        WebElement dropdown = driver.findElement(By.cssSelector("select[class='uui-form-element']"));
        Select select = new Select(dropdown);
        dropdown.click();
        select.selectByVisibleText(option);
    }
}
