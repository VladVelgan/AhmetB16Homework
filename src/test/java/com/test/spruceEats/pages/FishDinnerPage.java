package com.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FishDinnerPage {

    public FishDinnerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='starRating_score_4Star']")
    WebElement fourStarRating;

    @FindBy(css = "#pop_search_editor")
    WebElement editorsChoice;

    @FindBy(xpath = "//span[contains(text(),'Salmon Fillets')]")
    WebElement salmonFilletsRecipe;

    public void validateRecipeTitle(WebDriver driver, String expectedRecipeTitle) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.click(fourStarRating).perform();
        Thread.sleep(500);
        actions.click(editorsChoice).perform();
        Thread.sleep(500);
        Assert.assertEquals(BrowserUtils.getText(salmonFilletsRecipe), expectedRecipeTitle);
    }

}
