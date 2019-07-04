package hw4.ex2;

import enums.Colors;
import enums.Conditions;
import enums.Metals;
import enums.Vegetables;
import hw4.BaseTest;
import hw4.steps.MetalsAndColorsPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Tests extends BaseTest {

    private MetalsAndColorsPageSteps metalsAndColorsPage;

    @DataProvider
    public static Object[][] dataForMetalsAndColorsPageTest() {
        return new Object[][]{

                {null, null, Arrays.asList(Conditions.EARTH), Colors.YELLOW, Metals.GOLD, null},
                {3, 8, null, null, null, Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO)},
                {3, 2, Arrays.asList(Conditions.WATER, Conditions.WIND, Conditions.FIRE),
                        null, Metals.BRONZE, Arrays.asList(Vegetables.ONION)},
                {6, 5, Arrays.asList(Conditions.WATER), Colors.GREEN, Metals.SELEN,
                        Arrays.asList(Vegetables.values())},
                {null, null, Arrays.asList(Conditions.FIRE), Colors.BLUE, null,
                        Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO, Vegetables.VEGETABLES)}
        };
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        metalsAndColorsPage = new MetalsAndColorsPageSteps();
    }

    @Test(dataProvider = "dataForMetalsAndColorsPageTest")
    public void secondTest(Integer summaryNumber1, Integer summaryNumber2, List<Conditions> elements, Colors color, Metals metal, List<Vegetables> vegetables) {

        // 2. Assert Browser title
        metalsAndColorsPage.assertBrowserTitle("Home Page");

        // 3. Perform login
        metalsAndColorsPage.login(login, password);

        // 4. Click on the link on the Header section
        metalsAndColorsPage.clickMetalsAndColorsButton();

        // 5. Fill form on the page
        if (summaryNumber1 != null) {
            metalsAndColorsPage.chooseSummaryNumber(summaryNumber1);
        }
        if (summaryNumber2 != null) {
            metalsAndColorsPage.chooseSummaryNumber(summaryNumber2);
        }
        metalsAndColorsPage.clickCalculateButton();

        if (elements != null) {
            for (Conditions element : elements) {
                metalsAndColorsPage.chooseElement(element);
            }
        }

        if (color != null) {
            metalsAndColorsPage.selectColorsDropdownOption(color.getName());
        }

        if (metal != null) {
            metalsAndColorsPage.selectMetalsDropdownOption(metal.getName());
        }

        metalsAndColorsPage.unselectVegetablesOption();
        if (vegetables != null) {
            for (Vegetables vegetable : vegetables) {


                metalsAndColorsPage.selectVegetable(vegetable);
            }
        }

        // 6. Click “Submit” button
        metalsAndColorsPage.clickSubmitButton();

        // 7. Check Results block output on the right-side
        metalsAndColorsPage.checkResult(summaryNumber1, summaryNumber2, elements, color, metal, vegetables);

        metalsAndColorsPage.logout();

    }

}
