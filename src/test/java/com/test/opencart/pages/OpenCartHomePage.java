package com.test.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCartHomePage {

    public OpenCartHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn-close']")
    WebElement closeButton;

    @FindBy(xpath = "//a[.=' Customers']")
    WebElement customerButton;

    @FindBy(xpath = "//a[.='Customers']")
    WebElement subCustomerButton;

    public void customerProfileEntry() throws InterruptedException {
        closeButton.click();
        Thread.sleep(500);
        customerButton.click();
        subCustomerButton.click();
    }


    






}
