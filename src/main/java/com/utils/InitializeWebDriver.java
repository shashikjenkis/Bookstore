package com.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class InitializeWebDriver {

    public static WebDriver driver = null;

   
    public void beforeScenario() {
        driver = new ChromeDriver();
    }

    
    public void afterScenario() {
        driver.quit();
    }
}
