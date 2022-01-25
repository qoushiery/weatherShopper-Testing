package com.weatherShopper.framework.actions;

import com.weatherShopper.framework.base.DriverHandler;
import com.weatherShopper.framework.utilities.ConfigUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
/*
* This Class contains all actions we need to interact with any web element existed in the dom and all methods
* are implemented using selenium library with its methods and all contained methods are implemented to be directly
* used by the user to create his own test case without any need to know info about selenium before
* Just call the ElmentActions class in your test and use their methods
* */

public class ElementActions {
    //Create the wait element
    public static Wait<WebDriver> wait = new WebDriverWait(DriverHandler.getInstance().getDriver(), Duration.ofSeconds(Long.parseLong(ConfigUtil.WAIT_TIME)));
    

    //Check the visibility of a web element by its locator
     static boolean checkVisibilityOf(By locator){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (Exception e){
            System.out.println("Element "+locator.toString()+" is not visible on the current DOM");
            return false;
        }
        return true;
    }

    //Retrieve any web element by its locator
    public static WebElement retrieveElement(By locator){
        checkVisibilityOf(locator);
        return DriverHandler.getInstance().getDriver().findElement(locator);
    }

    //Retrieve Web Elements
    public static List<WebElement> retrieveElements(By locator){
         checkVisibilityOf(locator);
         return DriverHandler.getInstance().getDriver().findElements(locator);
    }

    //check the click-ability of any web element by its locator
    public static WebElement checkClickAbilityOf(By locator){
         WebElement element = retrieveElement(locator);
         try {
             wait.until(ExpectedConditions.elementToBeClickable(locator));
         }
         catch (Exception e){
             System.out.println("Element "+locator.getClass().getName()+" is not intractable");
         }
         return element;
    }

    //Click on a Web element by passing its locator

    public static void clickOnElement(By locator){
         try {
             WebElement element = checkClickAbilityOf(locator);
             element.click();
         }
         catch (Exception e){
             e.printStackTrace();
         }
    }

    //Type in a text field
    public static void typeInTextField(By locator, String str){
         try {
             WebElement element = checkClickAbilityOf(locator);
             //element.clear();
             element.sendKeys(str);
         }
         catch (Exception e){
             e.printStackTrace();
         }
    }

    //get a text of a certain web element by its locator
    public static String getTextOfElement(By locator){
         return retrieveElement(locator).getText();
    }

    public static boolean isElementDisplayed(By locator)
    {
        WebElement element=null;
        try {
            element = ElementActions.retrieveElement(locator);
        }
        catch (NoSuchElementException exception)
        {
            return false;
        }
        catch (StaleElementReferenceException e){

        }
        return element.isDisplayed();
    }
    public static void forceClickOnElementByLocator(By locator) {
        checkClickAbilityOf(locator);
        WebElement element = DriverHandler.getInstance().getDriver().findElement(locator);
        ((JavascriptExecutor) DriverHandler.getInstance().getDriver()).executeScript("arguments[0].click()", element);
    }
    public static void pressKeyOnElement(By locator, Keys keys)
    {
        ElementActions.retrieveElement(locator).sendKeys(keys);
    }


}
