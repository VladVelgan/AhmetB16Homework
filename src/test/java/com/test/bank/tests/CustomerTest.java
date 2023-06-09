package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerTest extends BankTestBase{

    @Test
    public void validateCustomerPageFunctionality() throws InterruptedException {
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Vlad", "Velgan",
                "60004", "Customer added successfully with customer id");
        bankManagerPage.openAccountFunctionality(driver, "Vlad Velgan", "Dollar",
                "Account created successfully");
        bankManagerPage.customersFunctionality("Vlad", "Velgan", "60004");
        bankManagerPage.loginPageReturn();
        bankLoginPage.clickCustomerButton();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.customerLoginFunctionality("Vlad Velgan");
        customerPage.depositFunctionality("500", "Deposit Successful");
        customerPage.withdrawlFunctionality("300", "Transaction successful");
        customerPage.transactionFunctionality();
    }
}
