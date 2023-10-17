package ontop.challenge.test;

import ontop.challenge.pages.home.HomePage;
import ontop.challenge.pages.item.ItemPage;
import ontop.challenge.pages.products.ProductsPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProduct {

    private WebDriver driver;
    private static final String PRODUCT = "iPhone 12";
    private static final String AMAZON_HOME_PAGE = "https://www.amazon.com";
    private static final String CHROME_DRIVER_PATH = "src\\driver\\chromedriver.exe";

    @Before
    public void setUp() {
        System.out.println("Starting ChromeDriver");
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        System.out.println("Opening Amazon Home Page");
        driver.get(AMAZON_HOME_PAGE);
    }

    @Test
    public void searchIphoneAndValidateResults() {
        HomePage homePage = new HomePage(driver);

        //Enter a specific product name in the search bar (e.g., "Iphone 12")
        System.out.println("Searching for " + PRODUCT);
        homePage.searchElementByName(PRODUCT);

        ProductsPage productsPage = new ProductsPage(driver);
        //Verify that the search results page is displayed with relevant products.
        // The result list index starts at 3, meaning that to select the first option, use 3; for the second, use 4, and so on.
        System.out.println("Verify if relevant products is displayed");
        productsPage.getItemByIndex(3).isDisplayed();
        productsPage.getItemByIndex(4).isDisplayed();
        productsPage.getItemByIndex(5).isDisplayed();

        //Select a specific product from the search results page (e.g., the first product listed).
        System.out.println("Opening first product listed");
        productsPage.getItemByIndex(3).click();

        //Verify that the product details page is displayed with accurate information.
        System.out.println("Verify if Title reflects item opened");
        ItemPage itemPage = new ItemPage(driver);
        Assert.assertTrue(itemPage.getProductTitle().getText().contains(PRODUCT));
        //Extract and validate the following details:

        //a. Product title
        String firstProductTitle = itemPage.getProductTitle().getText();
        System.out.println("First Product Title: " + firstProductTitle);
        //b. Product price
        String firstProductPrice = itemPage.getProductPrice().getText();
        System.out.println("First Produce Price: " + firstProductPrice);
        //c. Product rating
        String firstProductRating = itemPage.getProductRating().getText();
        System.out.println("First Product Rating: " + firstProductRating);

        //Take a Screenshot of the product details page.
        itemPage.takeScreenshot();

        //Capture the URL of the product details page.
        System.out.println("Current Product URL: " + driver.getCurrentUrl());
        //Navigate back to the search results page.
        System.out.println("Navigate back to Amazon Home Page");
        homePage.open(AMAZON_HOME_PAGE);

        //Repeat steps 5-10 for a different product (search another product from the search results page.
        System.out.println("Repeating steps for the second product in the list");

        homePage.searchElementByName(PRODUCT);
        productsPage.getItemByIndex(4).click();
        Assert.assertTrue(itemPage.getProductTitle().getText().contains(PRODUCT));

        String secondProductTitle = itemPage.getProductTitle().getText();
        System.out.println("First Product Title: " + secondProductTitle);

        String secondProductPrice = itemPage.getProductPrice().getText();
        System.out.println("First Produce Price: " + secondProductPrice);

        String secondProductRating = itemPage.getProductRating().getText();
        System.out.println("First Product Rating: " + secondProductRating);
        //Compare the details of the two products and validate if they are different.
        System.out.println("Comparing product title:");
        if (!firstProductTitle.equals(secondProductTitle)) {
            System.out.println("The product titles are different.");
        }

        System.out.println("Comparing product price:");
        if (!firstProductPrice.equals(secondProductPrice)) {
        System.out.println("The product prices are different.");
        }

        System.out.println("Comparing product rating:");
        if (!firstProductRating.equals(secondProductRating)) {
            System.out.println("The product ratings are different.");
        }

        //Capture a screenshot of the second product details page.
        itemPage.takeScreenshot();
        //Provide a test report summarizing the execution status, any issues encountered, and a summary of the extracted product details.
        System.out.println("Title: " + firstProductTitle + ", Price: " + firstProductPrice + ", Rating: " + firstProductRating);
        System.out.println("Title: " + secondProductTitle + ", Price: " + secondProductPrice + ", Rating: " + secondProductRating);

    }
}
