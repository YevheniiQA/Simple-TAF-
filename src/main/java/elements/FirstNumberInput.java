package elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstNumberInput<T> {

    private static final By FIRST_INPUT_NUMBER = By.xpath(".//input[@ng-model='first']");
    private WebDriver driver;
    private T currentPage;

    public FirstNumberInput(final WebDriver driver, final T currentPage) {
        this.driver = driver;
        this.currentPage = currentPage;
    }

    public T type(final String value) {
        driver.findElement(FIRST_INPUT_NUMBER).sendKeys(value);
        return currentPage;
    }

}
