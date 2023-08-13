package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    public WebElement getTheItemCart(WebDriver driver ){
        By getItemCartID= By.id("item_0_title_link");
        WebElement getItemCart=driver.findElement(getItemCartID);
        return getItemCart ;

    }
    //checkout
    public WebElement getTheCheckout(WebDriver driver ){
        By checkoutID= By.id("checkout");
        WebElement checkoutButton=driver.findElement(checkoutID);
        return checkoutButton ;

    }
}
