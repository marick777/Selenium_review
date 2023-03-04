package com.cydeo.tests.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertPractice extends TestBase {

    //    1. Open browser
    //    2. Go to website: https://practice.cydeo.com/javascript_alerts
    //    3. Click to “Click for JS Prompt” button
    //    4. Send “hello” text to alert
    //    5. Click to OK button from the alert
    //    6. Verify “You entered: hello” text is displayed.

/*
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        // TC#1: Registration Form Page Testing
        // 1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //    2. Go to website: https://practice.cydeo.com/javascript_alerts

        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDownMethod(){
        //driver.close();
    }


 */
    @Test
    public void prompt_alert_test(){

        //    2. Go to website: https://practice.cydeo.com/javascript_alerts

        driver.get("https://practice.cydeo.com/javascript_alerts");

        //    3. Click to “Click for JS Prompt” button
        WebElement jsPromptAlertBtn = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptAlertBtn.click();

        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());

        //    4. Send “hello” text to alert
        //BrowserUtils.sleep(2);
        alert.sendKeys("hello");
        //    5. Click to OK button from the alert
        alert.accept();

        //    6. Verify “You entered: hello” text is displayed.

        WebElement displayedTest = driver.findElement(By.xpath("//p[@id='result']"));

        String actualText = displayedTest.getText();
        String expectedText = "You entered: hello";

        Assert.assertEquals(actualText, expectedText);


    }
}
