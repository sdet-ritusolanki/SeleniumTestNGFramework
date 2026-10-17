
package com.automation.tests;

import com.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserTest extends BaseTest {

    @Test
    public void verifyBrowserLaunch() {

        driver.get("https://example.com");

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, "Example Domain");
    }
}
