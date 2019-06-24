package hw2.ex2;

import hw2.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

// TODO Please format class as descrtibed in the Java Code convention (tabulation)
public class Tests extends BaseClass {

    @Test
    public void secondTest() {

        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.className("dropdown-toggle")).click();
        List<WebElement> serviceOptionsTop = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
        // TODO Where is assertions of the text from menu?
        assertEquals(serviceOptionsTop.size(), 9);

        // 6. Click on Service subcategory in the left section and check that drop down contains options
        driver.findElement(By.cssSelector("a[ui='label']")).click();
        List<WebElement> serviceOptionsLeft = driver.findElements(By.xpath("//ul[@class='sub']/li"));
        // TODO Where is assertions of the text from menu?
        assertEquals(serviceOptionsLeft.size(), 9);

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
        // TODO Why do you do not use Select element ?
        driver.findElement(By.cssSelector("select[class='uui-form-element']")).click();
        driver.findElement(By.xpath("//option[text()[contains(.,'Yellow')]]")).click();

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
        assertEquals(!checkCheckBoxIsSelected("Wind"), checkLogRowOfCheckbox("Wind", "condition","false"));
}

private void clickCheckBox(String value) {
    // TODO I recommend replace string in xpath to the constant in format //label[text()[contains(.,'%s')]]/input
    // TODO In this case you could use String.format
    driver.findElement(By.xpath("//label[text()[contains(.,'" + value + "')]]/input")).click();
}

private boolean checkCheckBoxIsSelected(String value) {
    // TODO I recommend replace string in xpath to the constant in format //label[text()[contains(.,'%s')]]/input
    // TODO In this case you could use String.format
    return driver.findElement(By.xpath("//label[text()[contains(.,'" + value + "')]]/input")).isSelected();
}

private boolean checkLogRowOfCheckbox(String type, String value, String condition) {
        // TODO I recommend replace string in xpath to the constant in format //li[text()[contains(.,'%s: %s changed to %s')]]
    // TODO In this case you could use String.format
    return driver.findElement(By.xpath("//li[text()[contains(.,'" + type + ": " + value +" changed to " + condition + "')]]")).isDisplayed();
}
}
