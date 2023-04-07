package com.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    String configFile="config.properties";
    
    FileReader fileReader=null;
    
    public static Properties properties=null;
    
    public void loadProperties(){
        properties =new Properties();
        try {
            fileReader =new FileReader(configFile);
           
            properties.load(fileReader);
          
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }
}
