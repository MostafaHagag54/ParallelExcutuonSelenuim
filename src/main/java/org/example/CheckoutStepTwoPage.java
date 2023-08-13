package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepTwoPage {

    public WebElement getSummaryInfoEle(WebDriver driver){
        By sumId=By.className("summary_info_label");
        WebElement summaryInfoEle = driver.findElement(sumId);
        return summaryInfoEle;

    }
    //finish
    public WebElement getFinishButton(WebDriver driver){
        By finishId= By.id("finish");
        WebElement finishButton=driver.findElement(finishId);
        return finishButton;
    }

    public WebElement getSuccessfulMessageEle(WebDriver driver){
        By SuccessfulMessageClass=By.className("complete-text");
        WebElement SuccessfulMessageEle = driver.findElement(SuccessfulMessageClass);
        return SuccessfulMessageEle;

    }
}
