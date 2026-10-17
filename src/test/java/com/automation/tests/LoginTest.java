
package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {

        LoginPage loginPage = new LoginPage(driver);
        WaitUtils waits = new WaitUtils(driver);

        // Open the application and log in with demo credentials.
        loginPage.openLoginPage();
        loginPage.login("standard_user", "secret_sauce");

        // Wait for navigation to the inventory page.
        Assert.assertTrue(
                waits.waitForUrlContains("inventory.html"),
                "User should be redirected to the inventory page"
        );

        // Verify the application title.
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
}
