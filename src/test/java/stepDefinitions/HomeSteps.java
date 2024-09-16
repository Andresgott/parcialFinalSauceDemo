package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

import java.util.List;

public class HomeSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver().driver);

    @And("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assertions.assertTrue(homePage.sauceDemoTitleIsDisplayed());
    }

    @And("The product {string} should be displayed in the home page")
    public void verifyProductIsDisplayed(String productName){
        Assertions.assertTrue(homePage.isProductInHomePage(productName));
    }

    @And("I add to the cart the product {string}")
    public void addProductToCart(String productName) throws InterruptedException {
        homePage.addProductToCart(productName);
    }

    @And("The cart icon should display {string}")
    public void verifyCartIconNumber(String iconNumber){
        Assertions.assertTrue(homePage.verifyCartIconNumber(iconNumber));
    }

    @And("I remove the product {string} from the cart")
    public void removeProductFromCart(String productName){
        homePage.removeProductFromCart(productName);
    }

    @And("I click on the cart button")
    public void clickOnCartIcon(){
        homePage.clickOnCartButton();
    }
     //Parcial
    @And("I click on the sort combo box") public void chooseSortComboBox() {homePage.clickOnSortComboBox();}

    @And("I verify that the order of the products is correct")
    public void verifyRemoves(){Assertions.assertTrue(homePage.orderingFilterAtoZTest());}

    @And("I verify that the products are ordered from the lowest to the highest price")
    public void verifylistOrder(){Assertions.assertTrue(homePage.orderingFilterLowtoHighTest());}

    @Given("I click on the name of the product {string}")
    public void clickOnTheNameofTheProduct(String name){homePage.clickOnProductName(name);}

    @Then("The button back to products should be displayed")
    public void verifyButtonBackDisplayed(){Assertions.assertTrue(homePage.isBackButtonDisplayed());}

    @And("I click on the back to products button")
    public void clickOnTheBackButton(){homePage.clickBackButton();}

    @And("I click on three stripes button")
    public void clickOnThreeStripes(){homePage.clickThreeStripesButton();}

    @And("I click on the Reset App button")
    public void clickOnReset(){homePage.clickResetAppButton();}

    @And("I verify if the text from the button changed back")
    public void verifyChangeInButtonText(){Assertions.assertTrue(homePage.addToCartTextCheck());}



}
