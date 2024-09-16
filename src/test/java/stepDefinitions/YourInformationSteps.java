package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pages.YourInformationPage;

import java.util.List;

public class YourInformationSteps {
    YourInformationPage yourInformationPage = new YourInformationPage(DriverManager.getDriver().driver);

    @And("I fill the checkout information with")
    public void fillCheckoutInformation(DataTable checkoutInformation) throws InterruptedException {
        List<String> data = checkoutInformation.transpose().asList(String.class);
        // data = ["Mauricio", "Viscarra", "00000"]
        yourInformationPage.setFirstNameTextBox(data.get(0));
        yourInformationPage.setLastNameTextBox(data.get(1));
        yourInformationPage.setZipCodeTextBox(data.get(2));
    }

    @And("I fill the checkout information without zipcode")
    public void fillCheckoutInformationWithoutZipCode(DataTable checkoutInformation) throws InterruptedException {
        List<String> data = checkoutInformation.transpose().asList(String.class);
        yourInformationPage.setLastNameTextBox(data.get(0));
        yourInformationPage.setZipCodeTextBox(data.get(1));
    }

    @And("I click on continue button")
    public void clickOnContinueButton() throws InterruptedException {
        yourInformationPage.clickOnContinueButton();
    }

    @And("A error message saying {string}")
    public void errorMessageInfo(String name)
    {
        yourInformationPage.errorMessageEqualsText(name);
    }
}
