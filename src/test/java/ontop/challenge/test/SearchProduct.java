package ontop.challenge.test;

import ontop.challenge.pages.home.HomePage;
import ontop.challenge.pages.products.ProductsPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProduct {

    private WebDriver driver;
    private String product = "Iphone 12";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        //open the Amazon homepage
        driver.get("https://www.amazon.com");
    }

    @Test
    public void searchIphoneAndValidateResults() {
        HomePage homePage = new HomePage(driver);

        //Change location to US (Utah)
        homePage.changeLocationDeliver("84043");

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


        //Extract and validate the following details:

        //a. Product title
        //b. Product price
        //c. Product rating
        //d. Product description (if available)

        //Take a Screenshot of the product details page.

        //Capture the URL of the product details page.

        //Navigate back to the search results page.

        //Repeat steps 5-10 for a different product (search another product from the search results page.

        //Compare the details of the two products and validate if they are different.

        //Capture a screenshot of the second product details page.

        //Provide a test report summarizing the execution status, any issues encountered, and a summary of the extracted product details.
    }
}
