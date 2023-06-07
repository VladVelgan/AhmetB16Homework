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

    @FindBy(xpath = "//div[@class='center']//strong[.='200']")
    WebElement customerBalance;

    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionButton;

    @FindBy(xpath = "//td[.='500']")
    WebElement depositAmount;

    @FindBy(xpath = "//td[.='300']")
    WebElement withdrawlAmount;

    String depositMessage = "Deposit Successful";
    String withdrawlMessage = "Transaction successful";

    public void customerLoginFunctionality(String name) throws InterruptedException {
        BrowserUtils.selectBy(yourNameSelect, name, "text");
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(welcomeMessage), "Welcome " + name + " !!");
    }

    public void depositFunctionality(String amount) throws InterruptedException {
        depositButton.click();
        Thread.sleep(500);
        amountInput.sendKeys(amount);
        amountInput.submit();
        Assert.assertEquals(BrowserUtils.getText(confirmMessage), this.depositMessage);
    }

    public void withdrawlFunctionality(String amount) throws InterruptedException {
        withdrawlButton.click();
        Thread.sleep(500);
        amountInput.sendKeys(amount);
        amountInput.submit();
        Assert.assertEquals(BrowserUtils.getText(confirmMessage), this.withdrawlMessage);
    }

    public void transactionFunctionality() throws InterruptedException {
        int balance = Integer.parseInt(BrowserUtils.getText(customerBalance));
        transactionButton.click();
        Thread.sleep(1000);
        int deposit = Integer.parseInt(BrowserUtils.getText(depositAmount));
        int withdrawl = Integer.parseInt(BrowserUtils.getText(withdrawlAmount));
        Assert.assertTrue(balance == (deposit - withdrawl));
    }


}
