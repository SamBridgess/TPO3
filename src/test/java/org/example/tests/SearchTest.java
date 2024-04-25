package org.example.tests;

import org.example.TestingConstants;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    private static String url = "http://www.bongacams.com/";
    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeAll
    public static void configureTest(){
        driver = new FirefoxDriver();
        driver.get(url);

        mainPage = new MainPage();
        mainPage.init(driver);

        mainPage.agreeAndEnter();
    }

    private void navigateToMainPage() {
        driver.navigate().to(url);
    }

    private void testSearch(String expected, String search){
        navigateToMainPage();
        mainPage.fillSearchBar(search);
        mainPage.clickSearchButton(); // почему-то работает только если кликнуть 2 раза (wtf)
        mainPage.clickSearchButton();

        String searchResult = mainPage.getSearchResult();
        navigateToMainPage();
        assertEquals(expected, searchResult);
    }

    @Test
    public void correctSearchTest() {
        testSearch("По вашему запросу ничего не найдено.", TestingConstants.CORRECT_SEARCH);
    }

    @Test
    public void incorrectSearchTest() {
        testSearch("Результат поиска:", TestingConstants.CORRECT_SEARCH);

    }

    @Test
    public void someTest() {
        testSearch("Результат поиска:", "lol");
    }

    @Test
    public void someTest1() {
        testSearch("Результат поиска:", "anya");
    }

    @Test
    public void someTest2() {
        testSearch("Результат поиска:", "katya");
    }

    @Test
    public void someTest3() {
        testSearch("По вашему запросу ничего не найдено.", "7c89y4t9q7384y8t");
    }
}