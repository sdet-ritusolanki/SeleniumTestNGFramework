
package com.automation.utils;

import com.automation.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Provides reusable explicit-wait methods for Selenium operations.
 *
 * This utility centralizes waiting logic and reads the timeout
 * from config.properties.
 *
 * @author sdet-ritusolanki
 */
public class WaitUtils {

    // WebDriverWait checks conditions until they succeed or time out.
    private final WebDriverWait wait;

    /**
     * Initializes the explicit wait for the supplied browser.
     *
     * @param driver active Selenium WebDriver instance
     */
    public WaitUtils(WebDriver driver) {

        // Read the maximum wait duration from the configuration file.
        int timeout = Integer.parseInt(
                ConfigReader.getProperty("timeout")
        );

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(timeout)
        );
    }

    /**
     * Waits until an element is visible on the page.
     *
     * @param locator locator used to find the element
     * @return the visible web element
     */
    public WebElement waitForVisibility(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    /**
     * Waits until an element is clickable.
     *
     * @param locator locator used to find the element
     * @return the clickable web element
     */
    public WebElement waitForClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    /**
     * Waits until the browser URL contains the expected text.
     *
     * @param urlPart expected portion of the URL
     * @return true when the URL condition is satisfied
     */
    public boolean waitForUrlContains(String urlPart) {
        return wait.until(
                ExpectedConditions.urlContains(urlPart)
        );
    }
}
