


import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;

import com.utils.InitializeWebDriver;
import com.utils.PropertyReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.logging.LogManager;
public class BaseTest {
    InitializeWebDriver driver =new InitializeWebDriver();
    Logger log = Logger.getLogger(BaseTest.class.getName());
    
    @BeforeTest(alwaysRun = true)
    public  void setUp()throws SecurityException,IOException{
        InputStream inputStream = new  FileInputStream(new File("logging.properties"));
       
        LogManager.getLogManager().readConfiguration(inputStream);
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.loadProperties();
        driver.beforeScenario();
       
    }
    // @AfterTest(alwaysRun = true)
    // public void teardown(){
    //     driver.afterScenario();
    // }

    
}
