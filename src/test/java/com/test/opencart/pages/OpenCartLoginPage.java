package com.test.opencart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenCartLoginPage {

    public OpenCartLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-username")
    WebElement username;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(tagName = "button")
    WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'No match')]")
    WebElement errorMessage;

    public void loginFunctionality(String usernameInput, String passwordInput) throws InterruptedException {
        username.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
        loginButton.click();
        Thread.sleep(1000);
    }

    public void validatePageTitle(WebDriver driver, String expectedTitle){
       //  String actualTitle = driver.getTitle().trim();
        Assert.assertEquals(driver.getTitle().trim(), expectedTitle);
    }

    public void validateMessage(String usernameInput, String passwordInput, String expectedMessage) throws InterruptedException {
        username.sendKeys(usernameInput);
        Thread.sleep(500);
        password.sendKeys(passwordInput);
        Thread.sleep(500);
        loginButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(errorMessage), expectedMessage);
    }


    /*
        1-Click "X" button. (HomePage)
        2-CLick Customers from left side and click sub Customers button (still HomePage)
        3-Click + sign on the top right (CustomerPage)
        4-Fill all the blanks and enable NewsLetter,Status,Safe and CLick save button top left(CustomerPage)
        5-Validate message "Warning:You do not have permission to modify customers!" (Customer Test) -->call the method in here
    */




}
