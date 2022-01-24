package com.weatherShopper.test.tests;

import com.weatherShopper.framework.actions.BrowserActions;
import com.weatherShopper.framework.base.BrowserType;
import com.weatherShopper.framework.base.DriverHandler;
import com.weatherShopper.framework.utilities.ConfigUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeSuite
    public void setUp(){
        DriverHandler.getInstance().setBrowserType(BrowserType.CHROME);
        ConfigUtil.loadTestDataFromConfigFile();
    }

    @BeforeClass
    public void restoreWindowSize(){
        BrowserActions.restoreView();
    }

    @AfterTest
    public void quit(){BrowserActions.closeBrowser();}

}
