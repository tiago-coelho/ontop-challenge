package ontop.challenge.pages.home;

import ontop.challenge.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public WebElement getSearchInput() {
        return driver.findElement(By.id("twotabsearchtextbox"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.id("nav-search-submit-button"));
    }

    public void searchElementByName(String name) {
        getSearchInput().sendKeys(name);
        getSearchButton().click();
    }
}