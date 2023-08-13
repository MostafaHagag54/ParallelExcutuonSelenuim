package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebElement usernameEle(WebDriver driver){
        By username= By.id("user-name");
        WebElement userNameElenment=driver.findElement(username);
        return userNameElenment;
    }

    public WebElement getPasswordBox(WebDriver driver){
        By password= By.id("password");
        WebElement passwordBox=  driver.findElement(password);
        return passwordBox;
    }
    public WebElement getLoginButton(WebDriver driver){
        By LoginButtonId= By.id("login-button");
        WebElement loginButton= driver.findElement(LoginButtonId);
        return loginButton;
    }




}
