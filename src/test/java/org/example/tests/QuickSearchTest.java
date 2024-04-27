package org.example.tests;

import org.example.pages.QuickSearchPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSearchTest extends BaseTest{
    private static QuickSearchPage page;

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
