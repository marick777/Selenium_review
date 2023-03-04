package com.cydeo.tests.week3;

    //HardSoftAssertion
    // TC#1: Registration Form Page Testing
          // 1. Open Chrome browser
          // 2. Go to https://practice.cydeo.com/registration_form
          // 3. Verify title is as expected:
          // Expected: "Registration Form"
          // 4. Select "SDET" from Job title dropdown
         // 5. Verify "SDET" is selected

import com.cydeo.tests.utilities.Driver;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HardSoftAssertion {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        // TC#1: Registration Form Page Testing
        // 1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/registration_form

        driver.get("https://practice.cydeo.com/registration_form");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void registration_form_page_hardAssert_test(){
            // 3. Verify title is as expected:
            // Expected: "Registration Form"

        String actualTitle = driver.getTitle();
        String expectedTitle = "Registration Form";
        Assert.assertTrue(actualTitle.equals(expectedTitle));

        System.out.println("After Hard Assertion failed!!");

            // 4. Select "SDET" from Job title dropdown

        Select selectJobTitle = new Select(driver.findElement(By.name("job_title")));
        //selectJobTitle.selectByIndex(4);
        selectJobTitle.selectByVisibleText("SDET");

            // 5. Verify "SDET" is selected

        String actualSelectedOption = selectJobTitle.getFirstSelectedOption().getText();
        String expectedSelectedOption = "SDET";
        Assert.assertEquals(actualSelectedOption, expectedSelectedOption);
        //OR
        //Assert.assertTrue(selectJobTitle.getFirstSelectedOption().getText().equals("SDET"));

    }

    @Test
    public void registration_form_page_softAssert_test(){
        // 3. Verify title is as expected:
        // Expected: "Registration Form"

        String actualTitle = driver.getTitle();
        String expectedTitle = "Registration Form";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle);

        System.out.println("After Soft Assertion failed!!");

        // 4. Select "SDET" from Job title dropdown
        Select selectJobTitle = new Select(driver.findElement(By.name("job_title")));
        //selectJobTitle.selectByIndex(4);
        selectJobTitle.selectByVisibleText("SDET");

        // 5. Verify "SDET" is selected
        String actualSelectedOption = selectJobTitle.getFirstSelectedOption().getText();
        String expectedSelectedOption = "SDET";

        softAssert.assertEquals(actualSelectedOption, expectedSelectedOption);

        softAssert.assertAll();


    }

}
