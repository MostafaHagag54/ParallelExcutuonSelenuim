import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewCheckParallelExc {

    public ThreadLocal<WebDriver>driver=  new ThreadLocal<>();
    InventoryPage inventoryPage;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutStepTwoPage checkoutStepTwoPage;
    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    public WebDriver getDriver(){
            return  this.driver.get();
    }


@BeforeMethod
public void login(){

    setDriver( new ChromeDriver());
    getDriver().get("https://www.saucedemo.com/");
   // getDriver().manage().window().maximize();

// Create object from login page
     loginPage= new LoginPage();
    inventoryPage= new InventoryPage();
    cartPage= new CartPage();
    checkoutStepOnePage = new CheckoutStepOnePage();
    checkoutStepTwoPage= new CheckoutStepTwoPage();

    //insert user name
    loginPage.usernameEle(getDriver()).clear();
    loginPage.usernameEle(getDriver()).sendKeys("standard_user");

    //insert password
    loginPage.getPasswordBox(getDriver()).clear();
    loginPage.getPasswordBox(getDriver()).sendKeys("secret_sauce");

    //click on login
    loginPage.getLoginButton(getDriver()).click();

   WebElement CheckHomePage= inventoryPage.getHeaderTitle(getDriver());//title
    Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(14));
    wait.until(d -> CheckHomePage.isDisplayed());
}
/*
@AfterMethod
public void tearDown(){
        getDriver().quit();
}
*/
    @Test()
    public void Buy_SauceLabsBikeLight(){

        // buy the bike light
        inventoryPage.getCartOfBick(getDriver()).click();

        //wait till the counter changed
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(14));
        wait.until(d -> inventoryPage.getCartIconCounter(getDriver()).isDisplayed());

        // click on cart icon
        inventoryPage.getShoppingCart(getDriver()).click();

        // Move to cart page to click check out
        String cartPageUrl= getDriver().getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/cart.html",cartPageUrl);

        // confirm the order
        String  ActualResult=   cartPage.getTheItemCart(getDriver()).getText();
        Assert.assertEquals(ActualResult,"Sauce Labs Bike Light");

        cartPage.getTheCheckout(getDriver()).click(); // After Click

        //Wait to move the Check out pag
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Move to checkout-step-one page
        String CheckOutStepOneURL= getDriver().getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html",CheckOutStepOneURL);

        // Fill data in check out page
        //insert Frist name
        checkoutStepOnePage.getTheFristName(getDriver()).sendKeys("Mostafa");
        //insert last name
        checkoutStepOnePage.getTheLastName(getDriver()).sendKeys("Hagag");

        // insert postal code
        checkoutStepOnePage.getThePostalCode(getDriver()).sendKeys("Postal");
        checkoutStepOnePage.getTheContinueButton(getDriver()).click();

      // Wait until moving to checkout-step-two

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Confirm that user inside checkout-step-two

        String summaryInfo =checkoutStepTwoPage.getSummaryInfoEle(getDriver()).getText();
        Assert.assertEquals("Payment Information",summaryInfo);

// click on finish
        checkoutStepTwoPage.getFinishButton(getDriver()).click();
        //https://www.saucedemo.com/checkout-complete.html
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Class name  complete-text

        String theFinalResult= checkoutStepTwoPage.getSuccessfulMessageEle(getDriver()).getText();
        Assert.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",theFinalResult);

    }
    @Test()
    public void Buy_SauceLabsBackpack() throws InterruptedException {

        Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(14));
        WebElement addBikelight=getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addBikelight.click();

        WebElement checkCart = getDriver().findElement(By.cssSelector("span[class=\"shopping_cart_badge\"]"));
        wait.until(d -> checkCart.isDisplayed());

        WebElement checkCartIcon = getDriver().findElement(By.cssSelector("a[class=\"shopping_cart_link\"]"));
        checkCartIcon.click();

        WebElement checkoutButton = getDriver().findElement(By.id("checkout"));
        wait.until(d -> checkoutButton.isDisplayed());

        String  ActualResult= getDriver().findElement(By.id("item_4_title_link")).getText();
        //System.out.println(itemName);
        Assert.assertEquals(ActualResult,"Sauce Labs Backpack");

    }


}
