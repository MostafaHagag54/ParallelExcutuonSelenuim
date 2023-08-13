package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {


    // get the header title to check that user inside inventory page
    public WebElement getHeaderTitle(WebDriver driver){
        By headerTitle=By.cssSelector("span[class=\"title\"]"); //product
        WebElement CheckHomePage = driver.findElement(headerTitle);
        return CheckHomePage;
    }

    public WebElement getCartOfBick(WebDriver driver){
        By addBickbutton= By.id("add-to-cart-sauce-labs-bike-light");
        WebElement addBikelight=driver.findElement(addBickbutton);
        return addBikelight;
    }
public WebElement getCartIconCounter(WebDriver driver){
    By counterCart=By.cssSelector("span[class=\"shopping_cart_badge\"]");
    WebElement Carticon = driver.findElement(counterCart);
    return  Carticon;
}
public  WebElement getShoppingCart(WebDriver driver){
    By shoppingCart= By.cssSelector("a[class=\"shopping_cart_link\"]");
    WebElement checkCartIcon = driver.findElement(shoppingCart);
    return checkCartIcon ;
    //test
}

}
