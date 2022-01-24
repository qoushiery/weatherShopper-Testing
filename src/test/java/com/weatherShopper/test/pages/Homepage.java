package com.weatherShopper.test.pages;

import com.weatherShopper.framework.actions.BrowserActions;
import com.weatherShopper.framework.actions.ElementActions;
import com.weatherShopper.framework.utilities.ConfigUtil;
import com.weatherShopper.test.locators.HomepageLocators;
import com.weatherShopper.test.strings.HomePageStrings;

public class Homepage {

    //Navigate to Homepage of WeatherShopper.com
    public void navigateToHomePage(){
        BrowserActions.navigateToPage(ConfigUtil.BASE_URL);
    }

    //get the page title
    public String getPageTitle(){
        return ElementActions.getTextOfElement(HomepageLocators.CURRENT_TEMP_TEXT);
    }

    //Get the current Temperature
    public int getCurrentTemperature(){
        String currentTemp = ElementActions.getTextOfElement(HomepageLocators.CURRENT_TEMP_NUMBER).replaceAll("[^0-9]","");
        return Integer.parseInt(currentTemp);
    }

    //Refresh the page
    public void refreshHomepage(){
        BrowserActions.refreshPage();
    }
    //Check the correctness of the Moisturizer title
    public boolean checkMoistTitleIsCorrect(){
        return ElementActions.getTextOfElement(HomepageLocators.MOIST_HEADER).equals(HomePageStrings.moistHeader);
    }

    //Check the Correctness of the Moisturizer description
    public boolean checkMoistDescIsCorrect(){
        return ElementActions.getTextOfElement(HomepageLocators.MOIST_DESCRIPTION).equals(HomePageStrings.moistDescription);
    }
    //Check the correctness of text of the Buy Moisturizer button
    public boolean checkMoistButtonTextIsCorrect(){
        return ElementActions.getTextOfElement(HomepageLocators.BUY_MOIST_BTN).equals(HomePageStrings.buyMoistBtn);
    }
    //Check the Correctness of the sunscreens title
    public boolean checkSunscreensTitleIsCorrect(){
        return ElementActions.getTextOfElement(HomepageLocators.SUNSCREENS_HEADER).equals(HomePageStrings.sunscreensHeader);
    }

    //Check the correctness of the sunscreens description
    public boolean checkSunscreensDescIsCorrect(){
        return ElementActions.getTextOfElement(HomepageLocators.SUNSCREENS_DESCRIPTION).equals(HomePageStrings.sunscreensDescription);
    }

    //Check the correctness of text of the Buy Sunscreens button
    public boolean checkSunscreensButtonTextIsCorrect(){
        return ElementActions.getTextOfElement(HomepageLocators.BUY_SUNSCREENS_BTN).equals(HomePageStrings.buySunscreensBtn);
    }

    //Click on Buy Moisturizer Button
    public void clickOnBuyMoisturizerButton(){
        ElementActions.clickOnElement(HomepageLocators.BUY_MOIST_BTN);
    }

    //Click on Buy Sunscreens Button
    public void ClickOnBuySunscreensButton(){
        ElementActions.clickOnElement(HomepageLocators.BUY_SUNSCREENS_BTN);
    }
}
