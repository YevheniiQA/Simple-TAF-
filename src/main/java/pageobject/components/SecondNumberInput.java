package pageobject.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecondNumberInput {

    private static final By SECOND_INPUT_NUMBER = By.xpath(".//input[@ng-model='second']");
    private WebDriver driver;

    public SecondNumberInput(final WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSecondNumberInput() {
       return driver.findElement(SECOND_INPUT_NUMBER);
    }
}
