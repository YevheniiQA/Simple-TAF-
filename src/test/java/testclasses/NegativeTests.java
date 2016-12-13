package testclasses;

import java.util.concurrent.TimeUnit;

import common.ErrorMessages;
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

public class NegativeTests implements ErrorMessages {

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

    @Test(description = "Test symbols adding")
    public void testSymbolsAdding() {
        final String expectedValue = "NaN";
        mainPage.insertFirstNumber("a").insertSecontNumber("b")
                .selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.PLUS).clickCalculateResultButton();
        assertThat(forWrong(expectedValue), mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(forWrong(expectedValue), mainPage.getTableRowWidget().getResultByIndex(1).getText(),
                is(equalTo(expectedValue)));
    }

    @Test(description = "Test multiplication of empty values")
    public void testMultiplicationOfEmptyValues() {
        final String expectedValue = "NaN";
        mainPage.selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.MULTIPLY)
                .clickCalculateResultButton();
        assertThat(forWrong(expectedValue), mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(forWrong(expectedValue), mainPage.getTableRowWidget().getResultByIndex(1).getText(),
                is(equalTo(expectedValue)));
    }

    @Test(description = "Test division by zero")
    public void testDivisionByZero() {
        final String expectedValue = "Infinity";
        mainPage.insertFirstNumber("1").insertSecontNumber("0")
                .selectCalculationOperator(CalculatorOperator.CalculatorOperatorType.DIVIDE)
                .clickCalculateResultButton();
        assertThat(forWrong(expectedValue), mainPage.getCalculationResult(), is(equalTo(expectedValue)));
        assertThat(forWrong(expectedValue), mainPage.getTableRowWidget().getResultByIndex(1).getText(),
                is(equalTo(expectedValue)));
    }

}
