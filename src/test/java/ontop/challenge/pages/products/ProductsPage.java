package ontop.challenge.pages.products;

import ontop.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement getFirstIphoneSearchItem() {
        return driver.findElement(By.cssSelector(".s-result-list [data-index='4'] span a.a-link-normal.s-no-outline"));
    }
    public WebElement getSecondIphoneSearchItem() {
        return driver.findElement(By.cssSelector(".s-result-list [data-index='5'] span a.a-link-normal.s-no-outline"));
    }
}