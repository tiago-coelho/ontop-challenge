package ontop.challenge.pages.products;

import ontop.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private final WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // The result list index starts at 3, meaning that to select the first option, use 3; for the second, use 4, and so on.
    public WebElement getItemByIndex(int index) {
        return driver.findElement(By.cssSelector(String.format(".s-result-list [data-index='%s'] span a.a-link-normal.s-no-outline", index)));
    }
}