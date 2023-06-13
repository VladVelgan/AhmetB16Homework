package com.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishSeafoodPage {

    public FishSeafoodPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#search-form-input")
    WebElement findARecipeInput;

    @FindBy(xpath = "//span[.='Pan-Seared Salmon']")
    WebElement recipeFinder;

    public void findARecipeFunctionality(WebDriver driver, String searchBoxInput) throws InterruptedException {
        BrowserUtils.scrollWithJS(driver, recipeFinder);
        Thread.sleep(500);
        findARecipeInput.sendKeys(searchBoxInput);
        Thread.sleep(500);
        findARecipeInput.submit();
        Thread.sleep(500);
    }
}
