package com.weatherShopper.framework.base;

import com.weatherShopper.framework.utilities.ConfigUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class DriverHandler {
    ThreadLocal<WebDriver> driver;
    private DriverHandler (){

    }

    private static DriverHandler instance = new DriverHandler();

    public static DriverHandler getInstance() {
        return instance;
    }

    public void setBrowserType(BrowserType type){
        switch (type){
            case CHROME:
                //Handling Chrome Alerts and setting our chrome preferences for our session
                HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups",0);

                final ChromeOptions options = new ChromeOptions();
                options.setCapability("prefs",chromePrefs);
                //adding configurations for the headless mode
                if(ConfigUtil.HEADLESS){
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1920,1080");
                }
                //bypass limited resources problem
                options.addArguments("--disable-dev-shm-usage");
                //bypass OS security model
                options.addArguments("--no-sandbox");
                //Clearing the cache
                WebDriverManager.chromedriver().clearResolutionCache();
                WebDriverManager.chromedriver().setup();
                driver = new ThreadLocal<WebDriver>(){
                    @Override protected  WebDriver initialValue()
                    { return new ChromeDriver(options); }
                };
                break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new ThreadLocal<WebDriver>(){
                @Override protected WebDriver initialValue()
                {return new EdgeDriver();}
                };
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new ThreadLocal<WebDriver>(){
                @Override protected WebDriver initialValue()
                {return new FirefoxDriver();}
                };
                break;

        }

    }

    //Calling this method to get the driver object then lunch the browser
    public WebDriver getDriver(){
        return driver.get();
    }
}

