package com.cydeo.tests.utilities;
 /*
    this class will be storing only the utility methods that can be used across the project.
     */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

/*
        This method will accept int (in seconds)
        and execute Thread.sleep method gor given duration
        Arg: int seconds
 */

    public static void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedInTitle){

        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current Url: " + driver.getCurrentUrl());

            if(driver.getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }

        // 5. Assert:Title contains“Etsy”

        String actualTitle = driver.getTitle();
        //String expectedInTitle = "Etsy";
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public static void verifyTitleContains(WebDriver driver, String expectedInTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));
    }
}
