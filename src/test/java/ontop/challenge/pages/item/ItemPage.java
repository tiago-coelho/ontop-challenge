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
    public WebElement getProductBrandName() {
        return driver.findElement(By.cssSelector("tr.po-brand span.po-break-word"));
    }
    public WebElement getProductModelName() {
        return driver.findElement(By.cssSelector("tr.po-model_name span.po-break-word"));
    }
    public WebElement getProductMemoryStorageCapacity() {
        return driver.findElement(By.cssSelector("tr.po-memory_storage_capacity span.po-break-word"));
    }
    public WebElement getProductScreenSize() {
        return driver.findElement(By.cssSelector("tr.po-display.size span.po-break-word"));
    }
    public WebElement getProductDescription() {
        return driver.findElement(By.id("productDescription_feature_div"));
    }
    public WebElement getProductPrice() {
        return driver.findElement(By.cssSelector("div#corePrice_feature_div span.a-offscreen"));
    }
    public WebElement getProductRating() {
        return driver.findElement(By.cssSelector("#centerCol #averageCustomerReviews #acrPopover span.a-color-base"));
    }
}
