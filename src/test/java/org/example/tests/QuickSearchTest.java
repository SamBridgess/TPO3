package org.example.tests;

import org.example.pages.QuickSearchPage;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class QuickSearchTest {
    private static String url = "http://www.bongacams.com/";
    private static WebDriver driver;
    private static QuickSearchPage page;

    @BeforeAll
    public static void configureTest(){
        driver = new FirefoxDriver();
        driver.get(url);

        page = new QuickSearchPage();
        page.init(driver);

        page.agreeAndEnter();
    }
}
