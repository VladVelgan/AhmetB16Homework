package com.test.spruceEats.tests;

import com.test.spruceEats.pages.FishDinnerPage;
import com.test.spruceEats.pages.FishSeafoodPage;
import com.test.spruceEats.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FishDinnerTest extends SpruceEatsBaseTest{

    @Test
    public void confirmRecipeTitle() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        FishSeafoodPage fishSeafoodPage = new FishSeafoodPage(driver);
        FishDinnerPage fishDinnerPage = new FishDinnerPage(driver);
        homePage.pickFishAndSeafoodRecipes(driver);
        fishSeafoodPage.findARecipeFunctionality(driver, "Fish for dinner");
        fishDinnerPage.validateRecipeTitle(driver, "6-Ingredient Roasted Salmon Fillets");
    }
}
