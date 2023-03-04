package com.cydeo.tests.utilities;

import org.openqa.selenium.WebDriver;

public class Test {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://google.com");
    }
}
