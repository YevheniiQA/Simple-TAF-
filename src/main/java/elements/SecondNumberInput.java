package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondNumberInput<T> {

    private static final By SECOND_INPUT_NUMBER = By.xpath(".//input[@ng-model='second']");
    private WebDriver driver;
    private T currentPage;

    public SecondNumberInput(final WebDriver driver) {
        this.driver = driver;
    }

    public T type(final String value) {
        driver.findElement(SECOND_INPUT_NUMBER).sendKeys(value);
        return currentPage;
    }
}
