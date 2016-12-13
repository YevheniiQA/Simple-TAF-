package pageobject.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableRowWidget {

    private static final String TIME_LOCATOR_BY_INDEX = "(.//table/tbody/tr/td[1])[%s]";
    private static final String EXPRESSION_LOCATOR_BY_INDEX = "(.//table/tbody/tr/td/span[2])[%s]";
    private static final String RESULT_LOCATOR_BY_INDEX = "(.//table/tbody/tr/td[3])[%s]";
    private WebDriver driver;

    public TableRowWidget(final WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTimeByIndex(final int index) {
        return driver.findElement(By.xpath(String.format(TIME_LOCATOR_BY_INDEX, index)));
    }

    public WebElement getExpressionByIndex(final int index) {
        return driver.findElement(By.xpath(String.format(EXPRESSION_LOCATOR_BY_INDEX, index)));
    }

    public WebElement getResultByIndex(final int index) {
        return driver.findElement(By.xpath(String.format(RESULT_LOCATOR_BY_INDEX, index)));
    }
}
