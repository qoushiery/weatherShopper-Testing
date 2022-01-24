package com.weatherShopper.framework.actions;

import com.weatherShopper.framework.base.DriverHandler;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;

import java.util.ArrayList;
import java.util.List;

/*
* this class is created to manipulate with all actions we need to perform on the browser window
* */
public class BrowserActions {
    public static boolean isScreenMaximized = false;

    //Navigate ti a web page using URL
    public static void navigateToPage(String url){
        DriverHandler.getInstance().getDriver().navigate().to(url);
    }

    //Get the current URL
    public static String getCurrentUrl(){
        return DriverHandler.getInstance().getDriver().getCurrentUrl();
    }

    //Get the Window Title
    public static String getWindowTitle(){
        return DriverHandler.getInstance().getDriver().getTitle();
    }
    //Maximizing the Browser Window
    public static void maximizeWindow(){
        DriverHandler.getInstance().getDriver().manage().window().maximize();
    }

    //Refresh the page
    public static void refreshPage(){
        DriverHandler.getInstance().getDriver().navigate().refresh();
    }

    //Close the browser
    public static void closeBrowser(){
        DriverHandler.getInstance().getDriver().quit();
    }

    //Zoom Out PAGE
    public static void zoomOutPage(int percentageIndex){
        ((JavascriptExecutor) DriverHandler.getInstance().getDriver()).executeScript("document.body.style.zoom='arguments[0]'",percentageIndex);
    }
    //Restoring the view of the web page
    public static void restoreView(){
        if(!isScreenMaximized){
            maximizeWindow();
            zoomOutPage(1);
            refreshPage();
            isScreenMaximized=true;
        }
        else {
            //Do Nothing!
        }
    }
    //check if the Alert is displayed
    public static boolean checkIfAlertIsPresent(){
        try {
            DriverHandler.getInstance().getDriver().switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e){
            return false;
        }
    }

    //Approving an Alert
    public static void approveAlert(){
        try {
            DriverHandler.getInstance().getDriver().switchTo().alert().accept();
        }
        catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public static void switchToFrame(String frameName){
        DriverHandler.getInstance().getDriver().switchTo().frame(frameName);
    }

}
