package com.weatherShopper.test.locators;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;

public class HomepageLocators {
    public final static By CURRENT_TEMP_TEXT = By.xpath("//div[@class='row justify-content-center']");
    public final static By CURRENT_TEMP_NUMBER = By.id("temperature");

    public final static By MOIST_HEADER = By.xpath("/html/body/div/div[3]/div[1]/h3");
    public final static By MOIST_DESCRIPTION = By.xpath("/html/body/div/div[3]/div[1]/p");
    public final static By BUY_MOIST_BTN = By.xpath("//a[@href='/moisturizer']/button");

    public final static By SUNSCREENS_HEADER = By.xpath("/html/body/div/div[3]/div[2]/h3");
    public final static By SUNSCREENS_DESCRIPTION = By.xpath("/html/body/div/div[3]/div[2]/p");
    public final static By BUY_SUNSCREENS_BTN = By.xpath("//a[@href='/sunscreen']/button");

}
