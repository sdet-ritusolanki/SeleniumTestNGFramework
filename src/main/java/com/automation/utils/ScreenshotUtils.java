
package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Captures browser screenshots for test failure investigation.
 *
 * Screenshots are stored in the test-output/screenshots directory.
 *
 * @author sdet-ritusolanki
 */
public class ScreenshotUtils {

    // Private constructor prevents unnecessary utility-class instances.
    private ScreenshotUtils() {
    }

    /**
     * Captures a screenshot and saves it as a PNG file.
     *
     * @param driver active WebDriver instance
     * @param testName name of the test being executed
     * @return path of the saved screenshot
     * @throws IOException if the screenshot cannot be saved
     */
    public static String captureScreenshot(
            WebDriver driver, String testName) throws IOException {

        // Create a timestamp so repeated failures don't overwrite images.
        String timestamp = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS")
        );

        // Remove characters that are unsuitable for a filename.
        String safeTestName = testName.replaceAll(
                "[^a-zA-Z0-9._-]", "_"
        );

        // Define the screenshot output directory.
        Path screenshotDirectory = Paths.get(
                "test-output", "screenshots"
        );

        // Create the directory if it doesn't already exist.
        Files.createDirectories(screenshotDirectory);

        // Capture the current browser screen as PNG bytes.
        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        // Build a unique filename for this test execution.
        Path screenshotPath = screenshotDirectory.resolve(
                safeTestName + "_" + timestamp + ".png"
        );

        // Write the screenshot bytes to the file.
        Files.write(screenshotPath, screenshot);

        // Return the path for logging and future reporting.
        return screenshotPath.toAbsolutePath().toString();
    }
}
