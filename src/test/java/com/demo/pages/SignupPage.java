package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignupPage {

    public void createUser(){
       WebDriver driver = new ChromeDriver();
       driver.findElement(By.cssSelector("#userName")).sendKeys("shashi");
       
       
    }
    
}
