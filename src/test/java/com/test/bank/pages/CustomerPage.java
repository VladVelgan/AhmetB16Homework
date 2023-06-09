package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerPage {

    public CustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userSelect")
    WebElement yourNameSelect;

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeMessage;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;

    @FindBy(tagName = "input")
    WebElement amountInput;

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement confirmMessage;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawlButton;

    @FindBy(xpath = "//div[@ng-hide='noAccount']//strong[2]")
    WebElement customerBalance;

    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionButton;

    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement depositAmount;

    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement withdrawlAmount;

    public void customerLoginFunctionality(String name) throws InterruptedException {
        BrowserUtils.selectBy(yourNameSelect, name, "text");
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(welcomeMessage), "Welcome " + name + " !!");
    }

    public void depositFunctionality(String amount, String expectedMessage) throws InterruptedException {
        depositButton.click();
        Thread.sleep(500);
        amountInput.sendKeys(amount);
        amountInput.submit();
        Assert.assertEquals(BrowserUtils.getText(confirmMessage), expectedMessage);
    }

    public void withdrawlFunctionality(String amount, String expectedMessage) throws InterruptedException {
        withdrawlButton.click();
        Thread.sleep(500);
        amountInput.sendKeys(amount);
        amountInput.submit();
        Assert.assertEquals(BrowserUtils.getText(confirmMessage), expectedMessage);
    }

    public void transactionFunctionality() throws InterruptedException {
        int balance = Integer.parseInt(BrowserUtils.getText(customerBalance)); // 200
        Thread.sleep(1000);
        transactionButton.click();
        Thread.sleep(1000);
        int deposit = Integer.parseInt(BrowserUtils.getText(depositAmount));
        int withdrawl = Integer.parseInt(BrowserUtils.getText(withdrawlAmount));
        Assert.assertTrue(balance == (deposit - withdrawl));
    }
}
