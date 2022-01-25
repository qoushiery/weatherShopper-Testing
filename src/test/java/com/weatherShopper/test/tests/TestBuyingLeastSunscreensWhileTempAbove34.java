package com.weatherShopper.test.tests;

import com.weatherShopper.framework.utilities.ConfigUtil;
import com.weatherShopper.test.pages.CheckoutPage;
import com.weatherShopper.test.pages.Homepage;
import com.weatherShopper.test.pages.PaymentStatusPage;
import com.weatherShopper.test.pages.SunscreensPage;
import com.weatherShopper.test.strings.HomePageStrings;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestBuyingLeastSunscreensWhileTempAbove34 extends BaseTest {
    @Test
    public void executingBuyingLeastSunscreens(){
        SoftAssert softAssert = new SoftAssert();
        Homepage homepage = new Homepage();
        SunscreensPage sunscreensPage = new SunscreensPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        PaymentStatusPage paymentStatusPage = new PaymentStatusPage();
        int currentTemp;

        int firstItemPrice ;
        int secondItemPrice ;
        int totalPrice;

        //Navigating to the Weather shopper Homepage
        homepage.navigateToHomePage();

        //Validating the weather shopper home page is opened
        softAssert.assertEquals(homepage.getPageTitle(), HomePageStrings.currentTempText,"The user not landed on the Homepage");

        //Validating the Sunscreen title exists
        softAssert.assertTrue(homepage.checkSunscreensTitleIsCorrect(),"Sunscreens Title is not displayed Correctly");

        //Validating the Existence of the Buy Sunscreens button
        softAssert.assertTrue(homepage.checkSunscreensButtonTextIsCorrect(),"The label of Sunscreens Button is not displayed Correctly");

        //Get the current Temperature
        currentTemp = homepage.getCurrentTemperature();

        //Make sure the Temperature will be greater than 34 to buy sunscreens
        while(currentTemp<34){
            homepage.refreshHomepage();
            currentTemp = homepage.getCurrentTemperature();
        }

        //Click on Buy screen to navigate to Sunscreens Listing page
        homepage.ClickOnBuySunscreensButton();

        //Validate the Sunscreens listing page is opened
        softAssert.assertTrue(sunscreensPage.checkSunscreensPageIsOpened(),"Sunscreens page is not opened");

        //Validating the cart is empty
        softAssert.assertEquals(sunscreensPage.getTheNumberOfAddedItems(),"Empty","The Cart is not empty!");

        //Select the least SPF-30
        sunscreensPage.selectLeastSpf30();

        //Select the Least SPF-50
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

        softAssert.assertAll();

    }
}
