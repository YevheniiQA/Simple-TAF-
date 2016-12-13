package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculateResutButton<T> {

    private static final By BUTTON_GO = By.id("gobutton");
    private WebDriver driver;
    private T currentPage;

    public CalculateResutButton(final WebDriver driver, final T currentPage) {
        this.driver = driver;
        this.currentPage = currentPage;
    }

    public T click() {
        driver.findElement(BUTTON_GO).click();
        return currentPage;
    }
}
