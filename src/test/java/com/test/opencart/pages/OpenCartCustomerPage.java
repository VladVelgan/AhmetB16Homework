package com.test.opencart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenCartCustomerPage {

    public OpenCartCustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement plusSign;

    @FindBy(css = "#input-firstname")
    WebElement firstNameInput;

    @FindBy(css = "#input-lastname")
    WebElement lastNameInput;

    @FindBy(css = "#input-email")
    WebElement emailInput;

    @FindBy(css = "#input-telephone")
    WebElement phoneInput;

    @FindBy(css = "#input-password")
    WebElement passwordInput;

    @FindBy(css = "#input-confirm")
    WebElement confirmPasswordInput;

    @FindBy(css = "#input-newsletter")
    WebElement newsCheckbox;

    @FindBy(css = "#input-status")
    WebElement statusCheckbox;

    @FindBy(css = "#input-safe")
    WebElement safeCheckbox;

    @FindBy(xpath = "//button[@form='form-customer']")
    WebElement safeButton;

    @FindBy(xpath = "//div[contains(text(),'Warning:')]")
    WebElement warningMessage;

    public void addCustomerFunctionality(WebDriver driver, String firstName, String lastName, String email,
                                         String phone, String password) throws InterruptedException {
        plusSign.click();
        Thread.sleep(500);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phone);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        BrowserUtils.scrollWithJS(driver, newsCheckbox);
        Thread.sleep(500);
        if(!newsCheckbox.isSelected() && newsCheckbox.isDisplayed() &&
                newsCheckbox.isEnabled()) newsCheckbox.click();
        BrowserUtils.scrollWithJS(driver, statusCheckbox);
        Thread.sleep(500);
        if(!statusCheckbox.isSelected() && statusCheckbox.isDisplayed() &&
                statusCheckbox.isEnabled()) statusCheckbox.click();
        BrowserUtils.scrollWithJS(driver, safeCheckbox);
        Thread.sleep(500);
        if(!safeCheckbox.isSelected() && safeCheckbox.isDisplayed() &&
                safeCheckbox.isEnabled()) safeCheckbox.click();
        BrowserUtils.scrollWithJS(driver, safeButton);
        Thread.sleep(500);
        safeButton.click();
    }

    public void warningMessageValidation(String expectedMessage){
        String actualMessage = BrowserUtils.getText(warningMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }













}