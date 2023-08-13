import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class CheckParallelExc {
    public WebDriver driver=null;




    @Test()
    public void Buy_SauceLabsBikeLight(){


        driver= new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement userNameBox= driver.findElement(By.id("user-name"));
        WebElement passwordBox=  driver.findElement(By.id("password"));
        userNameBox.clear();
        userNameBox.sendKeys("standard_user");
        passwordBox.clear();
        passwordBox.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();



        WebElement CheckHomePage = driver.findElement(By.cssSelector("span[class=\"title\"]"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(14));
        wait.until(d -> CheckHomePage.isDisplayed());



        WebElement addBikelight=driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addBikelight.click();

        WebElement checkCart = driver.findElement(By.cssSelector("span[class=\"shopping_cart_badge\"]"));
        wait.until(d -> checkCart.isDisplayed());

        WebElement checkCartIcon = driver.findElement(By.cssSelector("a[class=\"shopping_cart_link\"]"));
        checkCartIcon.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        wait.until(d -> checkoutButton.isDisplayed());

        String  ActualResult= driver.findElement(By.id("item_0_title_link")).getText();
        //System.out.println(itemName);
        Assert.assertEquals(ActualResult,"Sauce Labs Bike Light");
    }
    @Test()
    public void Buy_SauceLabsBackpack() throws InterruptedException {


        driver= new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement userNameBox= driver.findElement(By.id("user-name"));
        WebElement passwordBox=  driver.findElement(By.id("password"));
        userNameBox.clear();
        userNameBox.sendKeys("standard_user");
        passwordBox.clear();
        passwordBox.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();



        WebElement CheckHomePage = driver.findElement(By.cssSelector("span[class=\"title\"]"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(14));
        wait.until(d -> CheckHomePage.isDisplayed());




        WebElement addBikelight=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addBikelight.click();

        WebElement checkCart = driver.findElement(By.cssSelector("span[class=\"shopping_cart_badge\"]"));
        wait.until(d -> checkCart.isDisplayed());

        WebElement checkCartIcon = driver.findElement(By.cssSelector("a[class=\"shopping_cart_link\"]"));
        checkCartIcon.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        wait.until(d -> checkoutButton.isDisplayed());

        String  ActualResult= driver.findElement(By.id("item_4_title_link")).getText();
        //System.out.println(itemName);
        Assert.assertEquals(ActualResult,"Sauce Labs Backpack");

    }



}