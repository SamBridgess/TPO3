package org.example.tests;

import org.example.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest<T extends Page> {
    public static String url = "http://www.bongacams.com/";
    public static WebDriver driver;

    protected static void initDriver() {
        driver = new FirefoxDriver();
        driver.get(url);
    }

    public void navigateToMainPage() {
        driver.navigate().to(url);
    }
}
