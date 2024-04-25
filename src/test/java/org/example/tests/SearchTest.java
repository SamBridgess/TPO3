package org.example.tests;

import org.example.TestingConstants;
import org.example.pages.SearchPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest extends BaseTest {
    private static SearchPage page;

    @BeforeAll
    public static void configureTest(){
        initDriver();
        page = new SearchPage();
        page.init(driver);

        page.agreeAndEnter();
    }

    private void navigateToMainPage() {
        driver.navigate().to(url);
    }

    private void testSearch(String expected, String search){
        page.fillSearchBar(search);
        page.clickSearchButton(); // почему-то работает только если кликнуть 2 раза (wtf)
        page.clickSearchButton();

        String searchResult = page.getSearchResult();
        navigateToMainPage();
        assertEquals(expected, searchResult);
    }

    @Test
    public void correctSearchTest() {
        testSearch("Результат поиска:", TestingConstants.CORRECT_SEARCH);
    }

    @Test
    public void incorrectSearchTest() {
        testSearch("По вашему запросу ничего не найдено.", TestingConstants.INCORRECT_SEARCH);
    }
}