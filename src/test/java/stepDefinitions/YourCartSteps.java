package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.YourCartPage;

public class YourCartSteps {
    YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);

    @And("I click on the checkout button")
    public void clickOnCheckoutButton(){
        yourCartPage.clickOnCheckoutButton();
    }

    @And("The title is displayed")
    public void isDisplayed(){Assertions.assertTrue(yourCartPage.yourCartTitleIsDisplayed());}

    @And("The title text equals Your Cart with {string}")
    public void textofTitleEquals(String name){Assertions.assertTrue(yourCartPage.yourCartTitleEquals(name));}


}
