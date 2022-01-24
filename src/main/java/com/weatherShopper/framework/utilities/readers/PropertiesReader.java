package com.weatherShopper.framework.utilities.readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader implements DataReader {
    String filePath;
    public PropertiesReader (String path) { this.filePath = path; }
    public String readValueUsingKey(String key) {
        return getPropertyUsingKey(key).trim();
    }

    private String getPropertyUsingKey(String key) {
        //Loading a properties file
        FileInputStream inputStream = null;
        Properties property = new Properties();
        try {
            inputStream = new FileInputStream(filePath);
        }
        catch (FileNotFoundException e){
            System.out.println("The properties file couldn't be located");
        }
        try {
            property.load(inputStream);
        }
        catch (IOException e)
        {
            System.out.println("The Properties file couldn't be loaded");
        }

        //Get the value by the key
        return property.getProperty(key);
    }
}
