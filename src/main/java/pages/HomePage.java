package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage {
    WebDriver driver;
    @FindBy(className = "app_logo")
    WebElement sauceDemoTitle;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productsTitle;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartIcon;

    @FindBy(id = "item_0_title_link")
    WebElement Sauce_labs_bike_light_link;

    @FindBy(id = "item_1_title_link")
    WebElement Sauce_labs_T_shirt_link;

    @FindBy(id = "item_2_title_link")
    WebElement Sauce_labs_onesie_link;

    @FindBy(id = "item_3_title_link")
    WebElement Sauce_labs_Red_Shirt_link;

    @FindBy(id = "item_4_title_link")
    WebElement Sauce_labs_backpack_link;

    @FindBy(id = "item_5_title_link")
    WebElement Sauce_labs_fleece_jacket_link;

    @FindBy(className = "inventory_details_back_button")
    WebElement backButton;

    @FindBy(className = "shopping_cart_link")
    WebElement cart;

    @FindBy(css = "#react-burger-menu-btn")
    WebElement threeStripeButton;

    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppButton;

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    WebElement sauceLabBackButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean sauceDemoTitleIsDisplayed() {
        if(sauceDemoTitle.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isProductInHomePage(String productName){
        for(WebElement element : productsTitle){
            if(element.getText().equalsIgnoreCase(productName)){
                return true;
            }
        }
        return false;
    }

    public void addProductToCart(String productName){
        // add-to-cart-sauce-labs-bolt-t-shirt
        // sauce labs bolt t-shirt
        String productId = "add-to-cart-"+productName.replace(" ", "-").toLowerCase();
        WebElement productAddToCartButton = driver.findElement(By.id(productId));
        productAddToCartButton.click();
    }

    public boolean verifyCartIconNumber(String cartNumber){
        String actualCartNumber = cartIcon.getText();
        if(actualCartNumber.equalsIgnoreCase(cartNumber)){
            return true;
        }
        return false;
    }

    public void removeProductFromCart(String productName){
        // remove-sauce-labs-bolt-t-shirt
        // sauce labs bolt t-shirt
        String productId = "remove-"+productName.replace(" ", "-").toLowerCase();
        WebElement removeProductButton = driver.findElement(By.id(productId));
        removeProductButton.click();
    }

    public void clickOnCartButton(){
        cart.click();
    }

    public WebElement clickOnSortComboBox()
    {
        WebElement sortComboBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("product_sort_container")));
        return sortComboBox;
    }

    public boolean orderingFilterAtoZTest()
    {

        Select selectObject = new Select(clickOnSortComboBox());
        selectObject.selectByVisibleText("Name (A to Z)");

        //verification
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));

        List<String> actualProductOrder = new ArrayList<>();

        for(WebElement element : productNames)
        {
            actualProductOrder.add(element.getText());
        }

        boolean isSorted = Ordering.natural().isOrdered(actualProductOrder);
        return isSorted;
        //Assertions.assertTrue(isSorted);

    }

    public boolean orderingFilterLowtoHighTest()
    {

        Select selectObject = new Select(clickOnSortComboBox());
        selectObject.selectByVisibleText("Price (low to high)");

        List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));

        List<Double> actualProductOrder = new ArrayList<>();

        for (WebElement element : productPrices)
        {
            String priceText = element.getText().replace("$", "");
            actualProductOrder.add(Double.parseDouble(priceText));
        }

        List<Double> expectedProductOrder = new ArrayList<>(actualProductOrder);
        Collections.sort(expectedProductOrder);
        boolean ok = true;
        if(expectedProductOrder==actualProductOrder)
        {
            ok = true;
        }
        return ok;


    }

    public void clickOnProductName(String name)
    {
        if (name.equals("Sauce Labs Backpack"))
        {
            Sauce_labs_backpack_link.click();
        }
        else if (name.equals("Sauce Labs Bike Light"))
        {
            Sauce_labs_bike_light_link.click();
        }
        else if (name.equals("Sauce Labs Bolt T-Shirt"))
        {
            Sauce_labs_T_shirt_link.click();
        }
        else if (name.equals("Sauce Labs Onesie"))
        {
            Sauce_labs_onesie_link.click();
        }
        else if (name.equals("Sauce Labs Fleece Jacket"))
        {
            Sauce_labs_fleece_jacket_link.click();
        }
        else {Sauce_labs_Red_Shirt_link.click();}

    }

    public boolean isBackButtonDisplayed()
    {
        return backButton.isDisplayed();
    }

    public void clickBackButton()
    {
        backButton.click();
    }

    public void clickThreeStripesButton()
    {
        threeStripeButton.click();
    }

    public void clickResetAppButton()
    {
        resetAppButton.click();
    }

    public boolean addToCartTextCheck()
    {
        String text=sauceLabBackButton.getText();
        if (text.equals("Remove"))
        {
            return true;
        }
        return false;
    }





}
