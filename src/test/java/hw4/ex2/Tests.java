package hw4.ex2;

import enums.Colors;
import enums.Conditions;
import enums.Metals;
import enums.Vegetables;
import hw4.BaseTest;
import hw4.builder.DataForMetalsAndColorsPageTest;
import hw4.steps.MetalsAndColorsPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Tests extends BaseTest {

    private MetalsAndColorsPageSteps metalsAndColorsPage;

    // fixed TODO Why do you decide use Object[][] instead of design pattern?
    @DataProvider(name = "dataForMetalsAndColorsPageTest")
    public static Object[][] dataForMetalsAndColorsPageTest() {
        return new Object[][]{

                {DataForMetalsAndColorsPageTest.builder()
                        .summaryNumber1(null)
                        .summaryNumber2(null)
                        .elements(Arrays.asList(Conditions.EARTH))
                        .color(Colors.YELLOW)
                        .metal(Metals.GOLD)
                        .vegetables(null)
                        .build()},

                {DataForMetalsAndColorsPageTest.builder()
                        .summaryNumber1(3)
                        .summaryNumber2(8)
                        .elements(null)
                        .color(null)
                        .metal(null)
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO))
                        .build()},

                {DataForMetalsAndColorsPageTest.builder()
                        .summaryNumber1(3)
                        .summaryNumber2(2)
                        .elements(Arrays.asList(Conditions.WATER, Conditions.WIND, Conditions.FIRE))
                        .color(null)
                        .metal(Metals.BRONZE)
                        .vegetables(Arrays.asList(Vegetables.ONION))
                        .build()},

                {DataForMetalsAndColorsPageTest.builder()
                        .summaryNumber1(6)
                        .summaryNumber2(5)
                        .elements(Arrays.asList(Conditions.WATER))
                        .color(Colors.GREEN)
                        .metal(Metals.SELEN)
                        .vegetables(Arrays.asList(Vegetables.values()))
                        .build()},

                {DataForMetalsAndColorsPageTest.builder()
                        .summaryNumber1(null)
                        .summaryNumber2(null)
                        .elements(Arrays.asList(Conditions.FIRE))
                        .color(Colors.BLUE)
                        .metal(null)
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO, Vegetables.VEGETABLES))
                        .build()}
        };
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        metalsAndColorsPage = new MetalsAndColorsPageSteps();
    }

    @Test(dataProvider = "dataForMetalsAndColorsPageTest")
    public void secondTest(DataForMetalsAndColorsPageTest testData) {

        // 2. Assert Browser title
        metalsAndColorsPage.assertBrowserTitle("Home Page");

        // 3. Perform login
        metalsAndColorsPage.login(login, password);

        // 4. Click on the link on the Header section
        metalsAndColorsPage.clickMetalsAndColorsButton();

        // 5. Fill form on the page
        if (testData.getSummaryNumber1() != null) {
            metalsAndColorsPage.chooseSummaryNumber(testData.getSummaryNumber1());
        }
        if (testData.getSummaryNumber2() != null) {
            metalsAndColorsPage.chooseSummaryNumber(testData.getSummaryNumber2());
        }
        metalsAndColorsPage.clickCalculateButton();

        if (testData.getElements() != null) {
            for (Conditions element : testData.getElements()) {
                metalsAndColorsPage.chooseElement(element);
            }
        }

        if (testData.getColor() != null) {
            metalsAndColorsPage.selectColorsDropdownOption(testData.getColor().getName());
        }

        if (testData.getMetal() != null) {
            metalsAndColorsPage.selectMetalsDropdownOption(testData.getMetal().getName());
        }

        metalsAndColorsPage.unselectVegetablesOption();
        if (testData.getVegetables() != null) {
            for (Vegetables vegetable : testData.getVegetables()) {


                metalsAndColorsPage.selectVegetable(vegetable);
            }
        }

        // 6. Click “Submit” button
        metalsAndColorsPage.clickSubmitButton();

        // 7. Check Results block output on the right-side
        metalsAndColorsPage.checkResult(testData);

        metalsAndColorsPage.logout();

    }

}
