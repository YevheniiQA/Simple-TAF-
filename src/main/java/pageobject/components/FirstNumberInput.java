package pageobject.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstNumberInput {

    private static final By FIRST_INPUT_NUMBER = By.xpath(".//input[@ng-model='first']");
    private WebDriver driver;

    public FirstNumberInput(final WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstInputNumber() {
        return driver.findElement(FIRST_INPUT_NUMBER);
    }

}
