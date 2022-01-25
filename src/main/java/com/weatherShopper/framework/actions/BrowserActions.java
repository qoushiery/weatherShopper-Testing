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

    public static void switchToFrame(String frameName){
        DriverHandler.getInstance().getDriver().switchTo().frame(frameName);
    }

}
