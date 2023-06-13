package com.test.spruceEats.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredientsTab;

    @FindBy(xpath = "//a[.='Fish & Seafood']")
    WebElement fishAndSeafoodOption;

    public void pickFishAndSeafoodRecipes(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(ingredientsTab).perform();
        actions.click(fishAndSeafoodOption).perform();
        Thread.sleep(500);
    }


}
