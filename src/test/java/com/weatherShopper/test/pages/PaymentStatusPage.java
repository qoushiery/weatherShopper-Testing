package com.weatherShopper.test.pages;

import com.weatherShopper.framework.actions.ElementActions;
import com.weatherShopper.test.locators.PaymentStatusPageLocators;
import com.weatherShopper.test.strings.PaymentStatusPageStrings;

public class PaymentStatusPage {

    //Check the payment success is opened
    public boolean checkPaymentSuccessPageOpened(){
        return ElementActions.getTextOfElement(PaymentStatusPageLocators.PAYMENT_SUCCESS).equals(PaymentStatusPageStrings.paymentSuccess);
    }

    //Check the success message of the payment is displayed correctly
    public boolean checkSuccessMessageIsDisplayed(){
        return ElementActions.getTextOfElement(PaymentStatusPageLocators.PAYMENT_SUCCESS_MESSAGE).equals(PaymentStatusPageStrings.successMessage);
    }
}
