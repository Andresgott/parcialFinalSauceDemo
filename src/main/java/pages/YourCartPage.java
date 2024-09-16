package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
    WebDriver driver;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(className = "title")
    WebElement title;

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean yourCartTitleIsDisplayed()
    {
        return title.isDisplayed();
    }

    public boolean yourCartTitleEquals(String name)
    {
        return title.getText().equals(name);
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }
}
