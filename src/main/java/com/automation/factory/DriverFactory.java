
package com.automation.factory;

import com.automation.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Creates WebDriver instances based on framework configuration.
 *
 * Browser selection is controlled through config.properties,
 * avoiding browser-specific setup in individual test classes.
 *
 * @author sdet-ritusolanki
 */
public class DriverFactory {

    /**
     * Creates and configures the selected browser.
     *
     * @return configured WebDriver instance
     * @throws IllegalArgumentException if the browser is unsupported
     */
    public static WebDriver createDriver() {

        // Read the browser name from the configuration file.
        String browser = ConfigReader.getProperty("browser");

        // Create the requested browser driver.
        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                                + ". Supported browsers: chrome, firefox"
                );
        }

        // Use a consistent starting window size for UI tests.
        driver.manage().window().maximize();

        return driver;
    }
}
