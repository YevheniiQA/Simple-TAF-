package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MainPage extends LoadableComponent<MainPage> {

    private final WebDriver driver;

    public MainPage(final WebDriver driver) {
        this.driver = driver;
    }

    protected void load() {

    }

    protected void isLoaded() throws Error {

    }
}
