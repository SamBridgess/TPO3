package org.example.tests;

import org.example.pages.QuickSearchPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class QuickSearchTest extends BaseTest{
    private static QuickSearchPage page;

    @BeforeAll
    public static void configureTest(){
        driver = new FirefoxDriver();
        driver.get(url);

        page = new QuickSearchPage();
        page.init(driver);

        page.agreeAndEnter();
    }

    @Test
    public void quickSearchTest(){
        page.clickQuickSearchButton();
       // page.clickCouplesRadio();
        //page.clickRussiaCheckbox();
       // page.clickLatinAmericaCheckbox();

        page.clickConfirmQuickSearch();
    }
}
