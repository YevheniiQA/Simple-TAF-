package testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.components.CalculatorOperator;
import pageobject.pages.MainPage;
import utils.FileManagerUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class PositiveTests {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", FileManagerUtils.getFrameworkPath() + "/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void openMainPage() {
        mainPage = new MainPage(driver).get();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test(description = "Test add operation")
    public void testCalculatorAddOperation() {
        final String expectedValue = "4";
        mainPage.insertFirstNumber("2").insertSecontNumber("2")
                .selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.PLUS).clickCalculateResultButton();
        assertThat(mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(mainPage.getTableRowWidget().getResultByIndex(1).getText(), is(equalTo(expectedValue)));
    }

    @Test(description = "Test subtraction operation")
    public void testCalculatorSubtractionOperation() {
        final String expectedValue = "2";
        mainPage.insertFirstNumber("4").insertSecontNumber("2")
                .selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.MINUS)
                .clickCalculateResultButton();
        assertThat(mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(mainPage.getTableRowWidget().getResultByIndex(1).getText(), is(equalTo(expectedValue)));
    }

    @Test(description = "Test multiplication operation")
    public void testCalculatorMultiplicationOperation() {
        final String expectedValue = "8";
        mainPage.insertFirstNumber("4").insertSecontNumber("2")
                .selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.MULTIPLY)
                .clickCalculateResultButton();
        assertThat(mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(mainPage.getTableRowWidget().getResultByIndex(1).getText(), is(equalTo(expectedValue)));
    }

    @Test(description = "Test divide operation")
    public void testCalculatorDivideOperation() {
        final String expectedValue = "4";
        mainPage.insertFirstNumber("16").insertSecontNumber("4")
                .selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.DIVIDE)
                .clickCalculateResultButton();
        assertThat(mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(mainPage.getTableRowWidget().getResultByIndex(1).getText(), is(equalTo(expectedValue)));
    }

    @Test(description = "Test mod operation")
    public void testCalculatorModOperation() {
        final String expectedValue = "0";
        mainPage.insertFirstNumber("4").insertSecontNumber("2")
                .selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.MOD)
                .clickCalculateResultButton();
        assertThat(mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(mainPage.getTableRowWidget().getResultByIndex(1).getText(), is(equalTo(expectedValue)));
    }

    @Test(description = "Test adding of positive and negative value")
    public void testAddingOfPositiveAndNegativeValues() {
        final String expectedValue = "5";
        mainPage.insertFirstNumber("10").insertSecontNumber("-5")
                .selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.PLUS)
                .clickCalculateResultButton();
        assertThat(mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(mainPage.getTableRowWidget().getResultByIndex(1).getText(), is(equalTo(expectedValue)));
    }

    @Test(description = "Test adding of negative values")
    public void testAddingOfNegativeValues() {
        final String expectedValue = "-10";
        mainPage.insertFirstNumber("-5").insertSecontNumber("-5")
                .selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.PLUS)
                .clickCalculateResultButton();
        assertThat(mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(mainPage.getTableRowWidget().getResultByIndex(1).getText(), is(equalTo(expectedValue)));
    }

    @Test(description = "Test subtraction of negative values")
    public void testSubtractionOfNegativeValues(){
        final String expectedValue = "0";
        mainPage.insertFirstNumber("-5").insertSecontNumber("-5")
                .selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.MINUS)
                .clickCalculateResultButton();
        assertThat(mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(mainPage.getTableRowWidget().getResultByIndex(1).getText(), is(equalTo(expectedValue)));
    }

    @Test(description = "Test adding of real numbers")
    public void testAddingOfRealNumbers() {
        final String expectedValue = "2.3";
        mainPage.insertFirstNumber("1.2").insertSecontNumber("1.1")
                .selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.MINUS)
                .clickCalculateResultButton();
        assertThat(mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(mainPage.getTableRowWidget().getResultByIndex(1).getText(), is(equalTo(expectedValue)));
    }

}
