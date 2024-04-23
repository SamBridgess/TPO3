package org.example.tests;

import org.example.Constants;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {
    private static WebDriver driver;
    private static MainPage mainPage;

    private void waitLoad(long time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    @BeforeAll
    public static void configureTest(){
        driver = new FirefoxDriver();
        driver.get("http://www.bongacams.com/");

        mainPage = new MainPage();
        mainPage.init(driver);

        //todo убрать бы
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[5]/a[1]")).click();
    }


    @Test
    public void correctSearchTest() {
        mainPage.fillSearchBar(Constants.CORRECT_SEARCH);
        mainPage.clickSearchButton(); // почему-то работает только если кликнуть 2 раза (wtf)
        mainPage.clickSearchButton();

        waitLoad(3);
        String searchResult = mainPage.getSearchResult();
        assertEquals(Constants.CORRECT_SEARCH_RESULT, searchResult);
    }

    @Test
    public void incorrectSearchTest() {
        mainPage.fillSearchBar(Constants.INCORRECT_SEARCH);
        mainPage.clickSearchButton(); // wtf
        mainPage.clickSearchButton();

        String searchResult = mainPage.getSearchResult();
        assertEquals(Constants.INCORRECT_SEARCH_RESULT, searchResult);
    }

/*
    @Test
    public void usernameTooShortTest() {
    }

    @Test
    public void usernameTooLongTest() {
    }

    @Test
    public void usernameOnlyDigitsTest() {
    }
 */
}