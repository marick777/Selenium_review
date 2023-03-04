package com.cydeo.tests.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsHandle extends TestBase {


    @Test
    public void windows_handling_test(){

        //    2. Go to website: https://demoqa.com/browser-windows
        driver.get(ConfigurationReader.getProperty("wenv"));


        //    3. Click on New Tab button
        WebElement newTabBtn = driver.findElement(By.xpath("//button[@id='tabButton']"));
        newTabBtn.click();

        //    4. Click on New Window button

        WebElement newWindowBtn = driver.findElement(By.xpath("//button[@id='windowButton']"));
        newWindowBtn.click();

        //    5. Click on New Window Message button
        WebElement newWindowMessageBtn = driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
        newWindowMessageBtn.click();
        //    6. Store parent window handle id in a variable

        System.out.println("driver.getTitle() = " + driver.getTitle());
        String mainWindow = driver.getWindowHandle();
        System.out.println("mainWindow = " + mainWindow);

        //    7. Store all window handle ids in to a Set

        Set<String> allWindows = driver.getWindowHandles();



        //    8. Print out each window id

        for (String eachWindow : allWindows) {
            driver.switchTo().window(eachWindow);
            System.out.println("eachWindow = " + eachWindow);
            //System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        driver.switchTo().window(mainWindow);



    }


}
