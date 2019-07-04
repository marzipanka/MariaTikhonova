package hw4.steps;

import com.codeborne.selenide.Condition;
import enums.Colors;
import enums.Conditions;
import enums.Metals;
import enums.Vegetables;
import hw4.MetalsAndColorsPage;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MetalsAndColorsPageSteps extends BasePageSteps {

    private MetalsAndColorsPage metalsAndColorsPage;

    public MetalsAndColorsPageSteps() {
        super();
        metalsAndColorsPage = new MetalsAndColorsPage();
    }

    public void chooseSummaryNumber(int num) {
        String numStr = num + "";
        $(byText(numStr)).click();
    }

    public void clickCalculateButton() {
        metalsAndColorsPage.getCalculateButton().click();
    }

    public void clickSubmitButton() {
        metalsAndColorsPage.getSubmitButton().click();
    }

    public void chooseElement(Conditions element) {
        List<Conditions> elements = Arrays.asList(Conditions.values());
        $(By.cssSelector("label[for='g" + (elements.indexOf(element) + 1) + "']")).click();
    }

    public void selectColorsDropdownOption(String option) {
        metalsAndColorsPage.getColorsDropdown().click();
        $(By.xpath("//span[contains(text(),'" + option + "')]")).click();
    }

    public void selectMetalsDropdownOption(String option) {
        metalsAndColorsPage.getMetalsDropdown().click();
        $(By.xpath("//span[contains(text(),'" + option + "')]")).click();
    }

    public void unselectVegetablesOption() {
        metalsAndColorsPage.getVegetablesDropdown().click();
        $(By.cssSelector("label[for='g" + 7 + "']")).click();
    }

    public void selectVegetable(Vegetables vegetable) {
        List<Vegetables> vegetables = Arrays.asList(Vegetables.values());

        metalsAndColorsPage.getVegetablesDropdown().click();
        $(By.cssSelector("label[for='g" + (vegetables.indexOf(vegetable) + 5) + "']")).click();
    }

    public void checkResult(Integer summaryNumber1, Integer summaryNumber2, List<Conditions> elements, Colors color, Metals metal, List<Vegetables> vegetables) {
        if ((summaryNumber1 != null) && (summaryNumber2 != null)) {
            checkSummaryLogRow(summaryNumber1, summaryNumber2);
        }
        if (elements != null) {
            checkElementsLogRow(elements);
        }
        if (color != null) {
            checkColorsLogRow(color);
        }
        if (metal != null) {
            checkMetalsLogRow(metal);
        }
        if (vegetables != null) {
            checkVegetablesLogRow(vegetables);
        }
    }

    public void checkSummaryLogRow(Integer summaryNumber1, Integer summaryNumber2) {
        String sum = summaryNumber1 + summaryNumber2 + "";
        metalsAndColorsPage.getSummaryLogRow().shouldHave(Condition.exactText(String.format("Summary: %s", sum)));
    }

    private void checkElementsLogRow(List<Conditions> elements) {
        String elementsRow = elements.get(0).getName();
        if (elements.size() > 1) {
            for (int i = 1; i < elements.size(); i++) {
                elementsRow += ", " + elements.get(i).getName();
            }
        }
        metalsAndColorsPage.getElementsLogRow().shouldHave(Condition.text(String.format("Elements: %s", elementsRow)));
    }

    private void checkColorsLogRow(Colors color) {
        metalsAndColorsPage.getColorsLogRow().shouldHave(Condition.exactText(String.format("Color: %s", color)));
    }

    private void checkMetalsLogRow(Metals metal) {
        metalsAndColorsPage.getMetalsLogRow().shouldHave(Condition.exactText(String.format("Metal: %s", metal)));
    }

    private void checkVegetablesLogRow(List<Vegetables> vegetables) {
        String vegetablesRow = vegetables.get(0).getName();
        if (vegetables.size() > 1) {
            for (int i = 1; i < vegetables.size(); i++) {
                vegetablesRow += ", " + vegetables.get(i).getName();
            }
        }
        metalsAndColorsPage.getVegetablesLogRow().shouldHave(Condition.text(String.format("Vegetables: %s", vegetablesRow)));
    }

}
