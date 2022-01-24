package com.weatherShopper.test.pages;

import com.weatherShopper.framework.actions.ElementActions;
import com.weatherShopper.test.locators.SunscreensLocators;
import common.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SunscreensPage {

    //Check the Sunscreens listing page is opened by checking the page title equals to Sunscreens
    public boolean checkSunscreensPageIsOpened(){
        return ElementActions.getTextOfElement(SunscreensLocators.SUNSCREEN_PAGE_TITLE).equals(Strings.sunscreensPgeTitle);
    }
    public void selectLeastSpf50(){
        List<WebElement> allSunscreens = ElementActions.retrieveElements(SunscreensLocators.PAGE_ELEMENTS);
        String leastSpf50 = null;
        int leastPrice50 = Integer.MAX_VALUE;
        for (WebElement sunscreen:allSunscreens){

            if(sunscreen.getText().toLowerCase().contains("spf-50"))
            {
                String currentSunScreen = sunscreen.getText();
                int currentPrice = Integer.parseInt(ElementActions.getTextOfElement(By.xpath("//p[text()='"+currentSunScreen+"']/following-sibling::p")).replaceAll("[^0-9]",""));
                if(leastPrice50>currentPrice)
                {
                    leastSpf50 = currentSunScreen;
                    leastPrice50 = currentPrice;
                }
            }
        }
        System.out.println("Least SPF-50: "+leastSpf50);
        System.out.println("Least SPF-50 Price: "+leastPrice50);

        ElementActions.clickOnElement(By.xpath("//p[text()='"+leastSpf50+"']/following-sibling::button"));
    }
    public void selectLeastSpf30(){
        List<WebElement> allSunscreens = ElementActions.retrieveElements(SunscreensLocators.PAGE_ELEMENTS);
        String leastSpf30 = null;
        int leastPrice30 = Integer.MAX_VALUE;
        for (WebElement sunscreen:allSunscreens){

            if(sunscreen.getText().toLowerCase().contains("spf-30")){
                String currentSunscreen = sunscreen.getText();
                int currentPrice = Integer.parseInt(ElementActions.getTextOfElement(By.xpath("//p[text()='"+currentSunscreen+"']/following-sibling::p")).replaceAll("[^0-9]",""));
                if(leastPrice30>currentPrice){
                    leastSpf30 = currentSunscreen;
                    leastPrice30 = currentPrice;
                }
            }
        }

        System.out.println("Least SPF-30: "+leastSpf30);
        System.out.println("Least SPF-30 Price: "+leastPrice30);

        ElementActions.clickOnElement(By.xpath("//p[text()='"+leastSpf30+"']/following-sibling::button"));
    }

    //Get the number of items which are added to the cart
    public String getTheNumberOfAddedItems(){
        return ElementActions.getTextOfElement(SunscreensLocators.ADDED_ITEMS_TO_CARD);
    }
    public void clickOnGoToCartButton(){
        ElementActions.clickOnElement(SunscreensLocators.GO_TO_CART_BTN);
    }
}
