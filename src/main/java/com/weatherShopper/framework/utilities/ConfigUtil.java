package com.weatherShopper.framework.utilities;


import common.Paths;
import com.weatherShopper.framework.utilities.readers.DataReader;
import com.weatherShopper.framework.utilities.readers.PropertiesReader;

public class ConfigUtil {
    public static String BASE_URL;
    public static String EMAIL;
    public static String CARD_NUMBER;
    public static String CVC_NUMBER;
    public static String EXPIRY_DATE;
    public static String ZIP_CODE;
    public static String WAIT_TIME;
    public static boolean HEADLESS;

    public static void loadTestDataFromConfigFile(){
        DataReader reader = new PropertiesReader(Paths.TEST_RESOURCES+"config.properties");

        BASE_URL = reader.readValueUsingKey("Base_URL");
        EMAIL = reader.readValueUsingKey("Email");
        CARD_NUMBER = reader.readValueUsingKey("Card_Number");
        CVC_NUMBER = reader.readValueUsingKey("CVC_Number");
        EXPIRY_DATE = reader.readValueUsingKey("Expiry_Date");
        ZIP_CODE = reader.readValueUsingKey("Zip_Code");
        WAIT_TIME = reader.readValueUsingKey("Wait_time");
        HEADLESS = Boolean.parseBoolean(reader.readValueUsingKey("Headless"));

    }
}
