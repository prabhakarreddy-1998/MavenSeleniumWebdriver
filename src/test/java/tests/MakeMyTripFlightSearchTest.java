package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class MakeMyTripFlightSearchTest extends BaseTest {

    @Test
    public void verifyFlightSearch() {
        // Open the website
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        try {
            // Close the popup if it appears
            clickElement(By.xpath("//span[@data-cy='closeModal']"));

            // Click on "Flights" tab
            clickElement(By.xpath("//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Flights']"));

            // Select the "OneWay" option
            clickElement(By.xpath("//li[@class='selected']"));

            // Define dynamic input text for the "From" location
            String fromLocation = "Tirupati";

            // Click on the "From" field and enter the location
            clickElement(By.xpath("//input[@id='fromCity']"));
            enterText(By.xpath("//input[@placeholder='From']"), fromLocation);

            // Select the "From" location from the dynamic list
            selectFromDynamicText(By.xpath("//span[contains(text(),'"+fromLocation+"')]"), fromLocation);

            // Define dynamic input text for the "To" location
            String toLocation = "New Delhi";

            // Click on the "To" field and enter the location
            clickElement(By.xpath("//input[@id='toCity']"));
            enterText(By.xpath("//input[@placeholder='To']"), toLocation);

            // Select the "To" location from the dynamic list
            selectFromDynamicText(By.xpath("//span[contains(text(),'"+toLocation+"')]"), toLocation);

        } catch (Exception e) {
            // Print the exception stack trace in case of any errors
            e.printStackTrace();
        }
    }
}
