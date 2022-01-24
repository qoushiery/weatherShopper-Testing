package com.weatherShopper.test.pages;

import com.weatherShopper.framework.actions.BrowserActions;
import com.weatherShopper.framework.actions.ElementActions;
import com.weatherShopper.framework.base.DriverHandler;
import com.weatherShopper.framework.utilities.ConfigUtil;
import com.weatherShopper.test.locators.CheckoutPageLocators;
import com.weatherShopper.test.strings.CheckoutPageStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CheckoutPage {

    //Check The Checkout Page is opened
    public boolean checkCheckoutPageIsOpened(){
        return ElementActions.getTextOfElement(CheckoutPageLocators.CHECKOUT_PAGE_TITLE).equals(CheckoutPageStrings.checkoutPageTitle);
    }

    //Check the table header is displayed correctly
    public boolean checkTableHeadersIsDisplayed(){
        boolean itemHeader = ElementActions.getTextOfElement(CheckoutPageLocators.ITEM_HEADER).equals(CheckoutPageStrings.itemHeader);
        boolean priceHeader = ElementActions.getTextOfElement(CheckoutPageLocators.PRICE_HEADER).equals(CheckoutPageStrings.priceHeader);
        return (itemHeader&&priceHeader);

    }

    //Check the Total Price is displayed
    public boolean checkTotalPriceIsDisplayed(){
        return ElementActions.getTextOfElement(CheckoutPageLocators.TOTAL_PRICES).contains(CheckoutPageStrings.total);
    }

    //Get the first item
    public String getTheFirstListedItem(){
        return ElementActions.getTextOfElement(CheckoutPageLocators.FIRST_LISTED_ITEM);
    }

    //Get the second Listed Item
    public String getTheSecondListedItem(){
        return ElementActions.getTextOfElement(CheckoutPageLocators.SECOND_LISTED_ITEM);
    }

    //Get the Price of the first listed item
    public int getTheFirstPriceOfListedItem(){
        return Integer.parseInt(ElementActions.getTextOfElement(CheckoutPageLocators.FIRST_LISTED_PRICE));
    }

    //Get the Price of the second listed Item
    public int getTheSecondPriceOfListedItem(){
        return Integer.parseInt(ElementActions.getTextOfElement(CheckoutPageLocators.SECOND_LISTED_PRICE));
    }

    //get the Total Price
    public int getTotalPrice(){
        return Integer.parseInt(ElementActions.getTextOfElement(CheckoutPageLocators.TOTAL_PRICES).replaceAll("[^0-9]",""));
    }

    //Check the pay with card button is displayed
    public boolean checkPayWithCardLabelIsDisplayed(){
        return ElementActions.getTextOfElement(CheckoutPageLocators.PAY_WITH_CARD_LABEL).equals(CheckoutPageStrings.payWithCardLabel);
    }
    //Click on Pay with Card Button
    public void clickOnPayWithCardBtn(){
        ElementActions.clickOnElement(CheckoutPageLocators.PAY_WITH_CARD_BUTTON);
    }
    //Check the popup is displayed
    public boolean checkPaymentPopupIsOpened(){

        return ElementActions.getTextOfElement(CheckoutPageLocators.POPUP_TITLE).equals(CheckoutPageStrings.paymentPopupHeader);
    }
    //Fill the Email field
    public void enterEmail(String email){
        ElementActions.isElementDisplayed(CheckoutPageLocators.EMAIL_FIELD);
        ElementActions.typeInTextField(CheckoutPageLocators.EMAIL_FIELD,email);
    }

    //Fill the Card Number
    public void enterCardNumber(String cardNumber){
        ElementActions.isElementDisplayed(CheckoutPageLocators.CARD_NUMBER_FIELD);
        for (char ch : cardNumber.toCharArray()) {

            switch (Integer.parseInt(String.valueOf(ch))) {
                case 0:
                    DriverHandler.getInstance().getDriver().findElement(CheckoutPageLocators.CARD_NUMBER_FIELD).sendKeys(Keys.NUMPAD0);
                    break;
                case 1:
                    DriverHandler.getInstance().getDriver().findElement(CheckoutPageLocators.CARD_NUMBER_FIELD).sendKeys(Keys.NUMPAD1);
                    break;
                case 2:
                    DriverHandler.getInstance().getDriver().findElement(CheckoutPageLocators.CARD_NUMBER_FIELD).sendKeys(Keys.NUMPAD2);
                    break;
                case 3:
                    DriverHandler.getInstance().getDriver().findElement(CheckoutPageLocators.CARD_NUMBER_FIELD).sendKeys(Keys.NUMPAD3);
                    break;
                case 4:
                    DriverHandler.getInstance().getDriver().findElement(CheckoutPageLocators.CARD_NUMBER_FIELD).sendKeys(Keys.NUMPAD4);
                    break;
                case 5:
                    DriverHandler.getInstance().getDriver().findElement(CheckoutPageLocators.CARD_NUMBER_FIELD).sendKeys(Keys.NUMPAD5);
                    break;
                case 6:
                    DriverHandler.getInstance().getDriver().findElement(CheckoutPageLocators.CARD_NUMBER_FIELD).sendKeys(Keys.NUMPAD6);
                    break;
                case 7:
                    DriverHandler.getInstance().getDriver().findElement(CheckoutPageLocators.CARD_NUMBER_FIELD).sendKeys(Keys.NUMPAD7);
                    break;
                case 8:
                    DriverHandler.getInstance().getDriver().findElement(CheckoutPageLocators.CARD_NUMBER_FIELD).sendKeys(Keys.NUMPAD8);
                    break;
                case 9:
                    DriverHandler.getInstance().getDriver().findElement(CheckoutPageLocators.CARD_NUMBER_FIELD).sendKeys(Keys.NUMPAD9);
                    break;
            }

        }
    }

    //Fill the card expiration date
    public void enterCardExpirationDate(String expiryDate){
        ElementActions.isElementDisplayed(CheckoutPageLocators.EXPIRATION_DATE_FIELD);
        ElementActions.typeInTextField(CheckoutPageLocators.EXPIRATION_DATE_FIELD,expiryDate);
    }

    //Fill the CVC number
    public void enterCvcNumber(String cvc){
        ElementActions.isElementDisplayed(CheckoutPageLocators.CVC_FIELD);
        ElementActions.typeInTextField(CheckoutPageLocators.CVC_FIELD,cvc);
    }

    //Fill the Zip Code
    public void enterZipCode(String zipCode){
        ElementActions.isElementDisplayed(CheckoutPageLocators.ZIP_CODE_FIELD);
        ElementActions.typeInTextField(CheckoutPageLocators.ZIP_CODE_FIELD,zipCode);
    }

    //Click on Pay Button
    public void clickOnPayButton(){
        ElementActions.isElementDisplayed(CheckoutPageLocators.PAY_BUTTON);
        ElementActions.clickOnElement(CheckoutPageLocators.PAY_BUTTON);
    }

    //Switch to the newly recent opened popup
    public void switchToRecentlyOpenedPopup(){
        BrowserActions.switchToFrame("stripe_checkout_app");
    }

}
