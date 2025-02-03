package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Initialize WebDriver and WebDriverWait before each test
    @BeforeMethod
    public void setUp() {
        // Initialize WebDriverManager to set up the browser driver automatically
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();  // Initialize the ChromeDriver instance
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set up WebDriverWait
    }

    // Generic function to click on an element
    public void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // Generic function to send keys to an input field
    public void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }

    // Generic function to wait for visibility of an element
    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Generic function to select a dynamic element based on its text
    public void selectFromDynamicText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + text + "')]")));
        element.click();
    }

    // Close the driver after each test
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Quit the WebDriver after the test is complete
        }
    }
}
