package com.weatherShopper.test.locators;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;

public class CheckoutPageLocators {
    public final static By CHECKOUT_PAGE_TITLE = By.xpath("//div[@class='row justify-content-center']");
    public final static By TOTAL_PRICES = By.id("total");
    public final static By ITEM_HEADER = By.xpath("//th[1]");
    public final static By PRICE_HEADER = By.xpath("//th[2]");

    public final static By FIRST_LISTED_ITEM = By.xpath("(//td[1])[1]");
    public final static By FIRST_LISTED_PRICE = By.xpath("(//td[2])[1]");
    public final static By SECOND_LISTED_ITEM = By.xpath("(//td[1])[2]");
    public final static By SECOND_LISTED_PRICE = By.xpath("(//td[2])[2]");

    public final static By PAY_WITH_CARD_BUTTON = By.xpath("//button[@class='stripe-button-el']");
    public final static By PAY_WITH_CARD_LABEL = By.xpath("//button[@class='stripe-button-el']/span");

    public final static By POPUP_TITLE = By.xpath("//div[@class='title']/h1");
    public final static By EMAIL_FIELD = By.id("email");
    public final static By CARD_NUMBER_FIELD = By.id("card_number");
    public final static By EXPIRATION_DATE_FIELD = By.id("cc-exp");
    public final static By CVC_FIELD = By.id("cc-csc");
    public final static By ZIP_CODE_FIELD = By.id("billing-zip");
    public final static By PAY_BUTTON =By.id("submitButton");




}
