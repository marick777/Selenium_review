package com.cydeo.tests.week3;


import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.CRM_Utilities;
import com.cydeo.tests.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRM_Sending_Messages extends TestBase {


    @Test
    public void sending_messages_test(){

        driver.get(ConfigurationReader.getProperty("env"));
        //       1. Users are already login and on the homepage
        CRM_Utilities.login_crm(driver);
        //       2. Users click the MESSAGE tab
        WebElement messageButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButton.click();
        BrowserUtils.sleep(2);

        //option#3 - switch using WebElement
        //driver.switchTo().frame(driver.findElement(By.xpath("//body[@contenteditable='true']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        //       3. Users write test message
        WebElement messageBox = driver.findElement(By.xpath("//body[@contenteditable='true']"));

        messageBox.sendKeys("qwerty");
        //       4. Users click the SEND button
        driver.switchTo().defaultContent();

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        //       5. Verify the message is displayed on the feed

        //WebElement feed = driver.findElement(By.xpath("//div[contains(@id, 'blog_post_body')]"));

        String actualText = driver.findElement(By.xpath("//div[contains(@id, 'blog_post_body')]")).getText();
        String expectedText = "qwerty";

        Assert.assertEquals(actualText, expectedText);

    }




}
