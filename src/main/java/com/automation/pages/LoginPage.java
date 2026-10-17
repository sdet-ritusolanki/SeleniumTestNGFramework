
package com.automation.pages;

import com.automation.config.ConfigReader;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents the SauceDemo login page.
 *
 * Encapsulates login-page locators, actions and synchronization.
 *
 * @author sdet-ritusolanki
 */
public class LoginPage {

    private final WebDriver driver;
    private final WaitUtils waits;

    private static final Logger logger =
            LogManager.getLogger(LoginPage.class);

    // Locators for the login form elements.
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    /**
     * Initializes the page object and its wait utility.
     *
     * @param driver active Selenium WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new WaitUtils(driver);
    }

    /**
     * Opens the application using its configured URL.
     */
    public void openLoginPage() {
        String baseUrl = ConfigReader.getProperty("baseUrl");

        logger.info("Opening application login page: {}", baseUrl);
        driver.get(baseUrl);
    }

    /**
     * Enters a username after the field becomes visible.
     *
     * @param username username used for login
     */
    public void enterUsername(String username) {
        logger.info("Entering username.");
        waits.waitForVisibility(usernameField).sendKeys(username);
    }

    /**
     * Enters a password after the field becomes visible.
     *
     * @param password password used for login
     */
    public void enterPassword(String password) {
        logger.info("Entering password.");
        waits.waitForVisibility(passwordField).sendKeys(password);
    }

    /**
     * Clicks the login button when it becomes clickable.
     */
    public void clickLoginButton() {
        logger.info("Clicking login button.");
        waits.waitForClickable(loginButton).click();
    }

    /**
     * Performs the complete login sequence.
     *
     * @param username username used for login
     * @param password password used for login
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
