package ontop.challenge.pages.item;

import ontop.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage extends BasePage {
    private final WebDriver driver;

    public ItemPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement getProductTitle() {
        return driver.findElement(By.id("productTitle"));
    }
}
