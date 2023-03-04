package com.cydeo.tests.week2;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LocatorPractice {
    public static void main(String[] args) {
        // TC#1: Practice page Login test
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/login

        driver.get("https://practice.cydeo.com/login");

        // 3. Enter username: "tomsmith"

        WebElement username1 = driver.findElement(By.name("username"));
        WebElement username2 = driver.findElement(By.xpath("//input[@name='username']"));
        username1.sendKeys("tomsmith");


        // 4. Enter password: "SuperSecretPassword"
        //WebElement password1 = driver.findElement(By.name("password"));
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("SuperSecretPassword");

        // 5. Click to Login button

        WebElement loginButton1 = driver.findElement(By.id("wooden_spoon"));
        //WebElement loginButton2 = driver.findElement(By.className("btn btn-primary"));// do not use Class names with space
        WebElement loginButton3 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        WebElement loginButton4 = driver.findElement(By.cssSelector(".btn.btn-primary"));

        loginButton4.click();

        // 6. Verify text displayed on page
        //    Expected: "You logged into a secure area!"

        WebElement resultText = driver.findElement(By.id("flash"));
        WebElement resultText2 = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));

        //System.out.println("resultText2.getText() = " + resultText2.getText());

        String actualText = resultText2.getText();
        String expectedText = "You logged into a secure area!";

        if(actualText.contains(expectedText)){
            System.out.println("Result text verification test PASSED!!!");
        }else {
            System.out.println("Result text verification FAIL!!!");
        }
        driver.close();
    }

}
