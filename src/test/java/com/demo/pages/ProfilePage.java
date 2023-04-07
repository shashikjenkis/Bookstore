package com.demo.pages;

import java.time.Duration;
import com.utils.InitializeWebDriver;
import com.utils.PropertyReader;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.logging.Logger;

public class ProfilePage extends InitializeWebDriver {
    String username="profile1";
    String loginpwd="Test123";
    String fristname ="ss";
    String lastname="B";
    String invaid_password="test";
    String password="Test123";
    
    
    Logger log = Logger.getLogger(ProfilePage.class.getName());

    public void clickOnLogin(){
        String hostname=PropertyReader.properties.getProperty("hostname");
        log.info("hostname is .."+hostname);
        driver.get(hostname);
        driver.manage().window().maximize();
        
       driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.cssSelector("#userNameOrEmail")).sendKeys(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.cssSelector("#password")).sendKeys(loginpwd);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
    public void clickOnProfile(){
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//a[@id='username']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.linkText("Profile")).click();
        
        
      

    }

    public void updateProfile(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#firstName"))).sendKeys(fristname);
        //driver.findElement(By.cssSelector("#firstName")).sendKeys(fristname);
        log.info("fristname is .."+fristname);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.cssSelector("#lastName")).sendKeys(lastname);
        log.info("lastname is .."+lastname);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        log.info("password is .."+password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.cssSelector("#confirmPassword")).sendKeys(password);
      
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='alert']"))).getText();
        log.info("message is .."+ message);
        Assert.assertEquals(message, "Profile Updated");

    }

   public void emptyPassword(){
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
       driver.findElement(By.cssSelector("#lastName")).sendKeys(lastname);
       log.info("lastname is .."+lastname);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
       Assert.assertEquals(driver.findElement(By.xpath("//div[@class='fade alert alert-danger show']")).getText().contains("Validation failed"), true); 
   } 
    
    public void invaidPasswordFormat(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(By.cssSelector("#password")).sendKeys(invaid_password);
        log.info("password is .."+invaid_password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.cssSelector("#confirmPassword")).sendKeys(invaid_password);
        
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='fade alert alert-danger show']")).getText().contains("Validation failed"), true); 
    }

    public void orderDeatils(){
        driver.findElement(By.cssSelector(".btn-sm.btn.btn-light")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assert.assertEquals(driver.findElement(By.linkText("Programming with Java | 6th Edition")).getText(), "Programming with Java | 6th Edition");
    }
}
