package org.fetch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class DriverSetup {
    @BeforeSuite
    public static WebDriver setupDriver() {
        // Set up Chrome options
        ChromeOptions options = new ChromeOptions();
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}

