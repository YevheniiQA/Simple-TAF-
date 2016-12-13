package pageobject.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultLabel {

    private static final By CALCULATOR_RESULT_LABEL = By.tagName("h2");
    private WebDriver driver;

    public ResultLabel(final WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCalculatorResultLabel() {
        return driver.findElement(CALCULATOR_RESULT_LABEL);
    }
}
