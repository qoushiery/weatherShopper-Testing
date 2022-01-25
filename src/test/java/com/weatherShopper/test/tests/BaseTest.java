package com.weatherShopper.test.tests;

import com.weatherShopper.framework.actions.BrowserActions;
import com.weatherShopper.framework.base.BrowserType;
import com.weatherShopper.framework.base.DriverHandler;
import com.weatherShopper.framework.utilities.ConfigUtil;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeSuite
    public void setUp(){
        ConfigUtil.loadTestDataFromConfigFile();
    }

    @BeforeTest
    @Parameters("browser")
    public void initializeBrowsers(String browser){
        switch (browser.toLowerCase()) {
            case "chrome":
                DriverHandler.getInstance().setBrowserType(BrowserType.CHROME);
                break;
            case "edge":
                DriverHandler.getInstance().setBrowserType(BrowserType.EDGE);
                break;
            case "firefox":
                DriverHandler.getInstance().setBrowserType(BrowserType.FIREFOX);
                break;
        }
    }
    @BeforeClass
    public void restoreWindowSize(){
        BrowserActions.restoreView();
    }

    @AfterTest
    public void quit(){BrowserActions.closeBrowser();}

}
