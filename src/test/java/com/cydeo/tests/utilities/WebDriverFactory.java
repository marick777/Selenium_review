package com.cydeo.tests.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType){
        if(browserType.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
        }else if(browserType.equalsIgnoreCase("firefox")){

                WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
        }else if(browserType.equalsIgnoreCase("safari")){

            WebDriverManager.safaridriver().setup();
            WebDriver driver = new SafariDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
            }else {
                System.err.println("Given string does not represent any browser");
                System.err.println("Either that browser does not exist or not currently supported.");
                System.err.println("driver = null");
                return null;
            }
        }






}
