
package com.automation.base;

import com.automation.factory.DriverFactory;
import com.automation.utils.ScreenshotUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Provides shared browser lifecycle management and failure handling.
 *
 * @author sdet-ritusolanki
 */
public class BaseTest {

    // Logger records important framework events.
    protected final Logger logger =
            LogManager.getLogger(getClass());

    // Browser instance shared with subclasses.
    protected WebDriver driver;

    /**
     * Starts a browser session before each test method.
     */
    @BeforeMethod
    public void setUp() {
        logger.info("Starting browser for test execution.");

        driver = DriverFactory.createDriver();

        logger.info("Browser started successfully.");
    }

    /**
     * Captures failure evidence and always attempts browser cleanup.
     *
     * @param result TestNG result for the completed test method
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                logger.error(
                        "Test failed: {}",
                        result.getName(),
                        result.getThrowable()
                );

                if (driver != null) {
                    try {
                        String screenshotPath =
                                ScreenshotUtils.captureScreenshot(
                                        driver, result.getName()
                                );

                        logger.info(
                                "Failure screenshot saved: {}",
                                screenshotPath
                        );

                    } catch (Exception e) {
                        logger.error(
                                "Unable to capture failure screenshot.",
                                e
                        );
                    }
                }

            } else if (result.getStatus() == ITestResult.SUCCESS) {
                logger.info("Test passed: {}", result.getName());

            } else if (result.getStatus() == ITestResult.SKIP) {
                logger.warn("Test skipped: {}", result.getName());
            }

        } finally {
            // Attempt cleanup regardless of the test outcome.
            if (driver != null) {
                try {
                    driver.quit();
                    logger.info("Browser closed successfully.");
                } catch (Exception e) {
                    logger.error("Unable to close browser cleanly.", e);
                } finally {
                    driver = null;
                }
            }
        }
    }
}
