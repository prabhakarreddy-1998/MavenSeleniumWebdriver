package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class MakeMyTripLogoTest extends BaseTest {

    @Test
    public void verifyLogoOnPage() {
        // Open the URL
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        try {
            // Close popup if present
            WebElement closePopup = waitForElementVisible(By.xpath("//span[@data-cy='closeModal']"));
            closePopup.click();

            // Validate if MakeMyTrip logo is visible
            WebElement logo = waitForElementVisible(By.xpath("//img[contains(@alt,'MakeMyTrip')]"));
            
            // Assert if logo is displayed
            Assert.assertTrue(logo.isDisplayed(), "MakeMyTrip logo is not visible on the page.");
            System.out.println("MakeMyTrip logo is visible.");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An exception occurred during the test execution: " + e.getMessage());
        }
    }
}
