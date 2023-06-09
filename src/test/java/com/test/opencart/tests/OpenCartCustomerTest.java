package com.test.opencart.tests;

import com.test.opencart.pages.OpenCartCustomerPage;
import com.test.opencart.pages.OpenCartHomePage;
import com.test.opencart.pages.OpenCartLoginPage;
import org.testng.annotations.Test;

public class OpenCartCustomerTest extends OpenCartTestBase {

    @Test
    public void addNewCustomerValidation() throws InterruptedException {
        OpenCartLoginPage loginPage = new OpenCartLoginPage(driver);
        OpenCartHomePage homePage = new OpenCartHomePage(driver);
        OpenCartCustomerPage customerPage = new OpenCartCustomerPage(driver);
        loginPage.loginFunctionality("demo", "demo");
        homePage.customerProfileEntry();
        customerPage.addCustomerFunctionality(driver, "Vlad", "Velgan",
                "vlad@gmail.com", "773-814-9800", "password123");
        customerPage.warningMessageValidation("Warning:You do not have permission to modify customers!");
    }

}
