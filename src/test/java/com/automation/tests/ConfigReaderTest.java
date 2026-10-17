
package com.automation.tests;

import com.automation.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigReaderTest {

    @Test
    public void verifyBaseUrlConfiguration() {
        String baseUrl = ConfigReader.getProperty("baseUrl");

        Assert.assertEquals(
                baseUrl,
                "https://www.saucedemo.com/"
        );
    }

    @Test
    public void verifyBrowserConfiguration() {
        String browser = ConfigReader.getProperty("browser");

        Assert.assertEquals(browser, "chrome");
    }
}
