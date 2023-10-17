package ontop.challenge.test;

import ontop.challenge.pages.home.HomePage;
import ontop.challenge.pages.item.ItemPage;
import ontop.challenge.pages.products.ProductsPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class SearchProduct {

    private WebDriver driver;
    private String product = "iPhone 12";
    public String zip = "84043";
    public String amazonHomePage = "https://www.amazon.com";

    @Before
    public void setUp() {
        HomePage homePage = new HomePage(driver);
        System.setProperty("webdriver.chrome.driver", "src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        //open the Amazon homepage
        homePage.open(amazonHomePage);
    }

    @Test
    public void searchIphoneAndValidateResults() {


        //Change location to US (Utah)
        //homePage.changeLocationDeliver(zip);

        //Enter a specific product name in the search bar (e.g., "Iphone 12")
        homePage.searchElementByName(product);

        ProductsPage productsPage = new ProductsPage(driver);
        //Verify that the search results page is displayed with relevant products.
        productsPage.getItemByIndex(3).isDisplayed();
        productsPage.getItemByIndex(4).isDisplayed();
        productsPage.getItemByIndex(5).isDisplayed();

        //Select a specific product from the search results page (e.g., the first product listed).
        productsPage.getItemByIndex(3).click();

        //Verify that the product details page is displayed with accurate information.
        ItemPage itemPage = new ItemPage(driver);
        Assert.assertTrue(itemPage.getProductTitle().getText().contains(product));
        //Extract and validate the following details:

        //a. Product title
        String firstProductTitle = itemPage.getProductTitle().getText();
        System.out.println("First Product Title: " + firstProductTitle);
        //b. Product price
//        String firstProductPrice = itemPage.getProductPrice().getText();
//        System.out.println("First Produce Price: " + firstProductPrice);
        //c. Product rating
        String firstProductRating = itemPage.getProductRating().getText();
        System.out.println("First Product Rating: " + firstProductRating);

        //Take a Screenshot of the product details page.
        itemPage.takeScreenshot();

        //Capture the URL of the product details page.
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        //Navigate back to the search results page.

        //Repeat steps 5-10 for a different product (search another product from the search results page.

        //Compare the details of the two products and validate if they are different.

        //Capture a screenshot of the second product details page.

        //Provide a test report summarizing the execution status, any issues encountered, and a summary of the extracted product details.
    }
}
