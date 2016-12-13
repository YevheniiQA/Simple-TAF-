package pageobject.pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.components.CalculateResutButton;
import pageobject.components.CalculatorOperator;
import pageobject.components.FirstNumberInput;
import pageobject.components.ResultLabel;
import pageobject.components.SecondNumberInput;
import pageobject.components.TableRowWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class MainPage extends LoadableComponent<MainPage> {

    private CalculateResutButton calculateResutButton;
    private CalculatorOperator calculatorOperator;
    private FirstNumberInput firstNumberInput;
    private SecondNumberInput secondNumberInput;
    private ResultLabel resultLabel;
    private TableRowWidget tableRowWidget;
    private final WebDriver driver;

    public MainPage(final WebDriver driver) {
        this.driver = driver;
        this.calculateResutButton = new CalculateResutButton(driver);
        this.calculatorOperator = new CalculatorOperator(driver);
        this.firstNumberInput = new FirstNumberInput(driver);
        this.secondNumberInput = new SecondNumberInput(driver);
        this.resultLabel = new ResultLabel(driver);
        this.tableRowWidget = new TableRowWidget(driver);
    }

    protected void load() {
        driver.get("http://juliemr.github.io/protractor-demo/");
    }

    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertTrue("Not on the protractor-demo page " + url, url.endsWith("/"));
    }

    public MainPage clickCalculateResultButton() {
        calculateResutButton.getButtonGo().click();
        return this;
    }

    public MainPage selectCalculationOperator(final CalculatorOperator.CalculatorOperatorType calculatorOperatorType) {
        calculatorOperator.getCalculatorOperatorSelect().selectByVisibleText(calculatorOperatorType.getType());
        return this;
    }

    public MainPage insertFirstNumber(final String value){
        firstNumberInput.getFirstInpunNumber().sendKeys(value);
        return this;
    }

    public MainPage insertSecontNumber(final String value) {
        secondNumberInput.getSecondNumberInput().sendKeys(value);
        return this;
    }

    public String getCalculationResult() {
       final WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until((WebDriver input) -> !resultLabel.getCalculatorResultLabel().getText().contains("."));
       return resultLabel.getCalculatorResultLabel().getText();
    }

    public TableRowWidget getTableRowWidget() {
        return tableRowWidget;
    }
}
