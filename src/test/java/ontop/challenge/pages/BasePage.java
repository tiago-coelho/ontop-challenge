package ontop.challenge.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

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

    public void takeScreenshot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            ImageIO.write(ImageIO.read(screenshot), "png", new File("screenshot.png"));
            System.out.println("Screenshot saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving the screenshot.");
        }
    }
}