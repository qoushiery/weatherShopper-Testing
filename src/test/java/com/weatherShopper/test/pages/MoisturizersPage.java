package com.weatherShopper.test.pages;

import com.weatherShopper.framework.actions.ElementActions;
import com.weatherShopper.test.locators.MoisturizersLocators;
import common.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MoisturizersPage {

    //Check the Moisturizers listing page is opened by checking the page title equals to Moisturizers
    public boolean checkMoisturizerPageIsOpened(){
        return ElementActions.getTextOfElement(MoisturizersLocators.MOISTURIZER_PAGE_TITLE).equals(Strings.moisturizerPageTitle);
    }

    //Select the least Aloe Moisturizer
    public void selectLeastAloeMoisturizers(){
        List<WebElement> allMoist = ElementActions.retrieveElements(MoisturizersLocators.PAGE_ELEMENTS);
        String leastAloe = null;
        int leastAloePrice = Integer.MAX_VALUE;
        for (WebElement moist:allMoist){

            if(moist.getText().toLowerCase().contains("aloe"))
            {
                String currentAloe = moist.getText();
                int currentAloePrice = Integer.parseInt(ElementActions.getTextOfElement(By.xpath("//p[text()='"+currentAloe+"']/following-sibling::p")).replaceAll("[^0-9]",""));
                if(leastAloePrice>currentAloePrice)
                {
                    leastAloePrice = currentAloePrice;
                    leastAloe = currentAloe;
                }
            }
        }
        System.out.println("Least Aloe: "+leastAloe);
        System.out.println("Least Aloe Price: "+leastAloePrice);

        ElementActions.clickOnElement(By.xpath("//p[text()='"+leastAloe+"']/following-sibling::button"));
    }

    //Selecting the least Almond Moisturizer
    public void selectLeastAlmondMoisturizers(){
        List<WebElement> allMoist = ElementActions.retrieveElements(MoisturizersLocators.PAGE_ELEMENTS);
        String leastAlmond = null;
        int leastAlmondPrice = Integer.MAX_VALUE;
        for (WebElement moist:allMoist){

        if(moist.getText().toLowerCase().contains("almond")){
                String currentAlmond = moist.getText();
                int currentAlmondPrice = Integer.parseInt(ElementActions.getTextOfElement(By.xpath("//p[text()='"+currentAlmond+"']/following-sibling::p")).replaceAll("[^0-9]",""));
                if(leastAlmondPrice>currentAlmondPrice){
                    leastAlmondPrice = currentAlmondPrice;
                    leastAlmond = currentAlmond;
                }
            }
        }

        System.out.println("Least Almond: "+leastAlmond);
        System.out.println("Least Almond Price: "+leastAlmondPrice);

        ElementActions.clickOnElement(By.xpath("//p[text()='"+leastAlmond+"']/following-sibling::button"));
    }

    //Get the number of items which are added to the cart
    public String getTheNumberOfAddedItems(){
        return ElementActions.getTextOfElement(MoisturizersLocators.ADDED_ITEMS_TO_CARD);
    }
    //Click on the Go to cart Button
    public void clickOnGoToCartButton(){
        ElementActions.clickOnElement(MoisturizersLocators.GO_TO_CART_BTN);
    }
}
