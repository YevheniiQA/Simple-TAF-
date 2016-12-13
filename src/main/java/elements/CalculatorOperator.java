package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculatorOperator<T> {

    private static final By CALCULATOR_OPERATOR_SELECT = By.tagName("select");
    private WebDriver driver;
    private T currentPage;

    public CalculatorOperator(final WebDriver driver, final T currentPage) {
        this.driver = driver;
        this.currentPage = currentPage;
    }

    public T selectCalculatorOperator(final CalculatorOperatorType calculatorOperatorType) {
        new Select(driver.findElement(CALCULATOR_OPERATOR_SELECT))
                .selectByVisibleText(calculatorOperatorType.getType());
        return currentPage;
    }

    public enum CalculatorOperatorType {
        PLUS("+"),
        MINUS("-"),
        DIVIDE("/"),
        MULTIPLY("*"),
        MOD("%");

        CalculatorOperatorType(final String type) {
            this.type = type;
        }

        private String type;

        public String getType() {
            return type;
        }
    }

}
