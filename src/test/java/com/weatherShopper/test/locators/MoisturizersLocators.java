package com.weatherShopper.test.locators;

import org.openqa.selenium.By;

public class MoisturizersLocators {
    public final static By MOISTURIZER_PAGE_TITLE = By.xpath("//div[@class='row justify-content-center']");
    public final static By PAGE_ELEMENTS = By.tagName("p");
    public final static By GO_TO_CART_BTN = By.xpath("//button[@onclick='goToCart()']");
    public final static By ADDED_ITEMS_TO_CARD = By.id("cart");

}
