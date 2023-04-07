package com.demo.pages;
import java.time.Duration;
import java.util.logging.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import com.utils.InitializeWebDriver;
import com.utils.PropertyReader;




public class CartPage extends InitializeWebDriver {
    PropertyReader propertyReader = new PropertyReader();
    Logger log = Logger.getLogger(ProfilePage.class.getName());

    public void clickOnCart(){
    
        driver.findElement(By.linkText("Cart")).click();
        String cart_text=driver.findElement(By.cssSelector("div[class='row'] h1")).getText();
        log.info("cart confrimation text  "+cart_text);
        Assert.assertEquals(cart_text, "Shopping Cart");
    }
    

    public void emptyCart(){
        String empty=driver.findElement(By.xpath("//div[@role='alert']")).getText();
        log.info("empty cart confrimation text  "+empty);
        Assert.assertEquals(empty, "Your cart is empty Go Back");
        driver.findElement(By.linkText("Go Back")).click();
    }
    
    public void addIteam(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='active']"))).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[normalize-space()='Core Python Programming']"))).click();
        String iteam=driver.findElement(By.cssSelector("div[class='list-group-item'] h4")).getText();
        Assert.assertEquals(iteam, "Core Python Programming");
    }

    public void addQty(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//strong[normalize-space()='The Time Machine']")).click();
        WebElement dropdown=driver.findElement(By.xpath("//div[@class='col']//select[@class='form-control']"));
        Select select =new Select(dropdown);
        select.selectByValue("2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//button[normalize-space()='Add to Cart']")).click();
    }

    public void reviewPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//strong[normalize-space()='The Time Machine']")).click();
        WebElement rate =driver.findElement(By.xpath("//select[@id='rating']"));
        Select select =new Select(rate);
        select.selectByValue("4");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.cssSelector("#reviewMessage")).sendKeys("good book to refer");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String confrim=driver.findElement(By.cssSelector("div[role='alert']")).getText();
        log.info("rating message "+confrim);
         Assert.assertEquals(confrim, "Review submitted successfully");

    }
}
