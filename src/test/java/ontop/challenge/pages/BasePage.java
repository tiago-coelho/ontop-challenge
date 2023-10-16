package ontop.challenge.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}