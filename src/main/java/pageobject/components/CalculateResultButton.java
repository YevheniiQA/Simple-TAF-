package pageobject.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculateResultButton {

    private static final By BUTTON_GO = By.id("gobutton");
    private WebDriver driver;

    public CalculateResultButton(final WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonGo() {
        return driver.findElement(BUTTON_GO);
    }

}
