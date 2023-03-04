package com.cydeo.tests.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableDemoTest extends TestBase {


    @Test
    public void read_from_table_test(){

        // 2. Go to https://practice.cydeo.com/tables
        driver.get(ConfigurationReader.getProperty("cydeo.practice"));

        // 3. Print table1 data as a single String, not so common, but useful sometimes
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("table1 in text= " + table1.getText());


        // 4. verify tconway@earthlink.net is anywhere in the table

        Assert.assertTrue(table1.getText().contains("tconway@earthlink.net"));

        // 5. print all column names in single line

        WebElement columnNames = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println("Column Names in text = " + columnNames.getText());


        // 6. print each column name in separate lines using a loop and findElements method

        List<WebElement> columnNamesList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        System.out.println("columnNamesList.size() = " + columnNamesList.size());

        for (WebElement eachColumn : columnNamesList) {
            System.out.println("Each Column Name = " + eachColumn.getText());
        }


    }

}
