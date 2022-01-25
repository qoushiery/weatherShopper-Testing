package com.weatherShopper.test.tests;

import com.weatherShopper.framework.utilities.ConfigUtil;
import com.weatherShopper.test.pages.*;
import com.weatherShopper.test.strings.HomePageStrings;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestWeatherShopperEndToEnd extends BaseTest {
    @Test
    public void executeWeatherShopperEndToEnd(){
        SoftAssert softAssert = new SoftAssert();
        Homepage homepage = new Homepage();
        MoisturizersPage moisturizersPage = new MoisturizersPage();
        SunscreensPage sunscreensPage = new SunscreensPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        PaymentStatusPage paymentStatusPage = new PaymentStatusPage();
        int currentTemp;

        int firstItemPrice ;
        int secondItemPrice ;
        int totalPrice;

        homepage.navigateToHomePage();

        softAssert.assertEquals(homepage.getPageTitle(), HomePageStrings.currentTempText,"The user not landed on the Homepage");
        softAssert.assertTrue(homepage.checkMoistTitleIsCorrect(),"Moisturizer Title is not displayed Correctly");
        softAssert.assertTrue(homepage.checkMoistDescIsCorrect(),"Moisturizer Description is not displayed Correctly");
        softAssert.assertTrue(homepage.checkMoistButtonTextIsCorrect(),"The Label of Moisturizer Button is not displayed Correctly");
        softAssert.assertTrue(homepage.checkSunscreensTitleIsCorrect(),"Sunscreens Title is not displayed Correctly");
        softAssert.assertTrue(homepage.checkSunscreensDescIsCorrect(),"Sunscreens Description is not displayed Correctly");
        softAssert.assertTrue(homepage.checkSunscreensButtonTextIsCorrect(),"The label of Sunscreens Button is not displayed Correctly");

        //Get the current Temperature
        currentTemp = homepage.getCurrentTemperature();

        //if the Current Temperature is below the 19 degrees click on the Buy Moisturizer Button
        if(currentTemp<19){

            //Click on Buy Moisturizer to navigate to Moisturizers Listing page
            homepage.clickOnBuyMoisturizerButton();

            //Validate the Moisturizers listing page is opened
            softAssert.assertTrue(moisturizersPage.checkMoisturizerPageIsOpened(),"Moisturizer Page is not opened");

            //Validating the cart is empty
            softAssert.assertEquals(moisturizersPage.getTheNumberOfAddedItems(),"Empty","The Cart is not empty!");

            //Select The least Expensive Aloe Moisturizer
            moisturizersPage.selectLeastAloeMoisturizers();

            //Select The least Expensive Almond Moisturizer
            moisturizersPage.selectLeastAlmondMoisturizers();

            //Validate the number of added items to the card is only (2)
            softAssert.assertEquals(moisturizersPage.getTheNumberOfAddedItems(),"2 item(s)","Invalid Number of Items added to the cart");

            //Click to Add to Cart Button
            moisturizersPage.clickOnGoToCartButton();

            //Check the Checkout page is opened
            softAssert.assertTrue(checkoutPage.checkCheckoutPageIsOpened(),"The Checkout page is not opened!");

            //Check the Table headers are displayed
            softAssert.assertTrue(checkoutPage.checkTableHeadersIsDisplayed(),"Table Headers are not displayed");

            //Check the Total Price is displayed
            softAssert.assertTrue(checkoutPage.checkTotalPriceIsDisplayed(),"Total Price is not displayed");

            //Get the price of first Item
            firstItemPrice = checkoutPage.getTheFirstPriceOfListedItem();
            //Get the price of second Item
            secondItemPrice = checkoutPage.getTheSecondPriceOfListedItem();
            //get the total price
            totalPrice = checkoutPage.getTotalPrice();

            //Validating the selected items price equals to the total price
            softAssert.assertEquals(firstItemPrice+secondItemPrice,totalPrice,"Total payment is incorrect");

            //Validating the pay with card button is displayed
            softAssert.assertTrue(checkoutPage.checkPayWithCardLabelIsDisplayed(),"Pay With Card Button is not displayed!");

            //Click on Pay with card button
            checkoutPage.clickOnPayWithCardBtn();

            checkoutPage.switchToRecentlyOpenedPopup();

            //Validate the payment popup is opened
            softAssert.assertTrue(checkoutPage.checkPaymentPopupIsOpened(),"The payment Popup is not opened!");

            //Fill the Email
            checkoutPage.enterEmail(ConfigUtil.EMAIL);

            //Fill the Expiry Date
            checkoutPage.enterCardExpirationDate(ConfigUtil.EXPIRY_DATE);

            //fill the card Number
            checkoutPage.enterCardNumber(ConfigUtil.CARD_NUMBER);

            //Fill the CVC
            checkoutPage.enterCvcNumber(ConfigUtil.CVC_NUMBER);

            //Fill the Zip Code
            checkoutPage.enterZipCode(ConfigUtil.ZIP_CODE);

            //Click on the Pay button
            checkoutPage.clickOnPayButton();

            //Validate the Success Payment page is opened
            softAssert.assertTrue(paymentStatusPage.checkPaymentSuccessPageOpened(),"The Payment Success Page is not Opened!");

            //Validate the Success Message is displayed Correctly
            softAssert.assertTrue(paymentStatusPage.checkSuccessMessageIsDisplayed(),"The Payment Success Message is Incorrect!");

        }

        //if the Current Temperature is above the 34 degrees click on the Buy Sunscreens Button
        else if(currentTemp>34){

            //Click on Buy screen to navigate to Sunscreens Listing page
            homepage.ClickOnBuySunscreensButton();

            //Validate the Sunscreens listing page is opened
            softAssert.assertTrue(sunscreensPage.checkSunscreensPageIsOpened(),"Sunscreens page is not opened");

            //Validating the cart is empty
            softAssert.assertEquals(sunscreensPage.getTheNumberOfAddedItems(),"Empty","The Cart is not empty!");

            //Select the least Expensive SPF-30
            sunscreensPage.selectLeastSpf30();

            //Select the Least Expensive SPF-50
            sunscreensPage.selectLeastSpf50();

            //Validate the number of added items to the card is only (2)
            softAssert.assertEquals(sunscreensPage.getTheNumberOfAddedItems(),"2 item(s)","Invalid Number of Items added to the cart");

            //Click to Add to Cart Button
            sunscreensPage.clickOnGoToCartButton();

            //Check the Checkout page is opened
            softAssert.assertTrue(checkoutPage.checkCheckoutPageIsOpened(),"The Checkout page is not opened!");

            //Check the Table headers are displayed
            softAssert.assertTrue(checkoutPage.checkTableHeadersIsDisplayed(),"Table Headers are not displayed");

            //Check the Total Price is displayed
            softAssert.assertTrue(checkoutPage.checkTotalPriceIsDisplayed(),"Total Price is not displayed");

            //Get the price of first Item
            firstItemPrice = checkoutPage.getTheFirstPriceOfListedItem();
            //Get the price of second Item
            secondItemPrice = checkoutPage.getTheSecondPriceOfListedItem();
            //get the total price
            totalPrice = checkoutPage.getTotalPrice();

            //Validating the selected items price equals to the total price
            softAssert.assertEquals(firstItemPrice+secondItemPrice,totalPrice,"Total payment is incorrect");

            //Validating the pay with card button is displayed
            softAssert.assertTrue(checkoutPage.checkPayWithCardLabelIsDisplayed(),"Pay With Card Button is not displayed!");

            //Click on Pay with card button
            checkoutPage.clickOnPayWithCardBtn();

            checkoutPage.switchToRecentlyOpenedPopup();

            //Validate the payment popup is opened
            softAssert.assertTrue(checkoutPage.checkPaymentPopupIsOpened(),"The payment Popup is not opened!");

            //Fill the Email
            checkoutPage.enterEmail(ConfigUtil.EMAIL);

            //Fill the Expiry Date
            checkoutPage.enterCardExpirationDate(ConfigUtil.EXPIRY_DATE);

            //fill the card Number
            checkoutPage.enterCardNumber(ConfigUtil.CARD_NUMBER);

            //Fill the CVC
            checkoutPage.enterCvcNumber(ConfigUtil.CVC_NUMBER);

            //Fill the Zip Code
            checkoutPage.enterZipCode(ConfigUtil.ZIP_CODE);

            //Click on the Pay button
            checkoutPage.clickOnPayButton();

            //Validate the Success Payment page is opened
            softAssert.assertTrue(paymentStatusPage.checkPaymentSuccessPageOpened(),"The Payment Success Page is not Opened!");

            //Validate the Success Message is displayed Correctly
            softAssert.assertTrue(paymentStatusPage.checkSuccessMessageIsDisplayed(),"The Payment Success Message is Incorrect!");

        }

        //if the Current Temperature is between 19 and 34 degrees do nothing
        else {
            System.out.println("The Temp is normal. no need for Buying Moisturizers of Sunscreens");
        }

        softAssert.assertAll();
    }
}
