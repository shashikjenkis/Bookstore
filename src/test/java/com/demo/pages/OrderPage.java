package com.demo.pages;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.utils.InitializeWebDriver;
import com.utils.PropertyReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
   
public class OrderPage extends InitializeWebDriver{
    String username="test";
    String password="Test123";
    String addressLine1="test6262";
    String addressLine2 ="test2";
    String city ="dvg";
    String state ="KAR";
    String country ="IN";
    String postalcode ="577566";
    String phone ="23232323";
    Logger log = Logger.getLogger(OrderPage.class.getName());

   
    @Feature("Book Store Application")
    @Story("lanuch the Application")
    public void lanuchBookStore(){
        String hostname=PropertyReader.properties.getProperty("hostname");
        log.info("hostname is .."+hostname);
        driver.get(hostname);
        driver.manage().window().maximize();
        Allure.step("lanuch the book store");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='container']/h1")).getText(), "Latest Products");
        
    }
    @Feature("Book Store Application")
    @Story("Login to the Application")
    public void clickOnSignIn(){
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("userNameOrEmail")).sendKeys(username);
        driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/form/div[2]/input")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        Allure.step("user logged on to application");
    }
    @Feature("Book Store Application")
    @Story("Adding books to cart")
    public void addToCart(){
    driver.findElement(By.cssSelector("#root > main > div > div:nth-child(2) > div:nth-child(3) > div > a > img")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.findElement(By.xpath("//button[normalize-space()='Add to Cart']")).click();
    Allure.step("add books to cart");
    }

    @Feature("Book Store Application")
    @Story("proceed to checkout")
    public void checkout(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.cssSelector("button[class='btn-block btn btn-primary']")).click();
        Allure.step("user will proceed to checkout");
    }

    @Feature("Book Store Application")
    @Story("Add new address")
    public void addAddress(){
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.cssSelector("#addressLine1")).sendKeys(addressLine1);
        driver.findElement(By.cssSelector("#addressLine2")).sendKeys(addressLine2);
        driver.findElement(By.cssSelector("#city")).sendKeys(city);
        driver.findElement(By.cssSelector("#state")).sendKeys(state);
        WebElement dropdown= driver.findElement(By.cssSelector("#country"));
        Select select =new Select(dropdown);
        select.selectByValue(country);
        driver.findElement(By.cssSelector("#postalCode")).sendKeys(postalcode);
        driver.findElement(By.cssSelector("#phone")).sendKeys(phone);
        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement radio=driver.findElement(By.xpath("//input[@name='billingAddress']"));
        radio.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.cssSelector("button[class='mt-3 btn btn-primary']")).click();
        Allure.step("user will create  new address");

    }
    @Feature("Book Store Application")
    @Story("Delete the address")
    public void deleteadd(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//button[@class='btn btn-light']")).click();
        Allure.step("user can delete old address");
    }

    @Feature("Book Store Application")
    @Story("perfrom payment")
    public void payment(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals(driver.findElement(By.cssSelector("#root > main > div > div:nth-child(2) > h1")).getText(), "Payment Method");
        driver.findElement(By.xpath("//input[@id='pm_1Mgi1BG9R9y827ntbydLtrFX']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//button[normalize-space()='Proceed to PlaceOrder']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals( driver.findElement(By.cssSelector("div[class='card'] h2")).getText(), "Order Summary");
        Allure.step("user will perfrom payment");
    }

    @Feature("Book Store Application")
    @Story("order summary page")
    public void orderPlace(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.cssSelector("button[class='btn-block btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(@xpath,Order)]")).getText().contains("Order"),true); 
        String orderId=driver.findElement(By.xpath("//h1[contains(@xpath,Order)]")).getText();
        log.info("Order ID is  ..."+ orderId);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String paymentReceipt= driver.findElement(By.xpath("//a[contains(text(),'https://pay.stripe.com/receipts/payment/CAcaFwoVYW')]")).getText();
        log.info("paymentReceipt link ..."+ paymentReceipt);
        Allure.step("order confrim page");
        driver.close();

    }
}
