package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepOnePage {
    public WebElement getTheFristName(WebDriver driver ){
        By firstNameId= By.id("first-name");
        WebElement firstNameBox=driver.findElement(firstNameId);
        return firstNameBox ;

    }
    public WebElement getTheLastName(WebDriver driver ){
        By lastNameID= By.id("last-name");
        WebElement lastNameBox=driver.findElement(lastNameID);
        return lastNameBox ;

    }
    public WebElement getThePostalCode(WebDriver driver ){
        By postalCodeID= By.id("postal-code");
        WebElement postalCodeBox=driver.findElement(postalCodeID);
        return postalCodeBox ;

    }
    public WebElement getTheContinueButton(WebDriver driver ){
        By continueID= By.id("continue");
        WebElement continueButton=driver.findElement(continueID);
        return continueButton ;

    }
}
