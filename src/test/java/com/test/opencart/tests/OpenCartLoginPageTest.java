package com.test.opencart.tests;

import com.test.opencart.pages.OpenCartLoginPage;
import org.testng.annotations.Test;

public class OpenCartLoginPageTest extends OpenCartTestBase {

    @Test
    public void happyPathLogin() throws InterruptedException {
        OpenCartLoginPage loginPage = new OpenCartLoginPage(driver);
        loginPage.loginFunctionality("demo", "demo");
        loginPage.validatePageTitle(driver, "Dashboard");
    }

    @Test
    public void validateNegativeLogin() throws InterruptedException {
        OpenCartLoginPage loginPage = new OpenCartLoginPage(driver);
        loginPage.validateMessage("user", "password",
                "No match for Username and/or Password.");
    }


}