package pageobject.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculatorOperator {

    private static final By CALCULATOR_OPERATOR_SELECT = By.tagName("select");
    private WebDriver driver;

    public CalculatorOperator(final WebDriver driver) {
        this.driver = driver;
    }

    public Select getCalculatorOperatorSelect() {
        return new Select(driver.findElement(CALCULATOR_OPERATOR_SELECT));
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
