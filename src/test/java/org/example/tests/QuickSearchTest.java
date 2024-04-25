package org.example.tests;

import org.example.pages.QuickSearchPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSearchTest extends BaseTest{
    private static QuickSearchPage page;

    /*
      System.setProperty("webdriver.chrome.driver", "/home/sam/TPO/TPO3/drivers/chromedriver");
       // driver = new FirefoxDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model

        driver = new ChromeDriver(options);
        driver.get(url);
     */
    @BeforeAll
    public static void configureTest(){
        initDriver();
        page = new QuickSearchPage();
        page.init(driver);

        page.agreeAndEnter();
    }

    @Test
    public void quickSearchTest(){
        page.clickQuickSearchButton();

        page.clickCouplesRadio();

        page.clickNorthAmericaCheckbox();
        page.clickEuropeCheckbox();
        page.clickRussiaCheckbox();
        page.clickLatinAmericaCheckbox();
        page.clickAsiaCheckbox();
        page.clickOtherCheckbox();

        page.clickConfirmQuickSearch();

        String searchResult = page.getSearchResult();
        assertEquals("Результат поиска:", searchResult);
    }
}
