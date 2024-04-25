package org.example.tests;

import org.example.TestingConstants;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
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

    @Test
    public void signInCorrectTest(){
        mainPage.clickSignIn();
        mainPage.fillSignInUsername(TestingConstants.EXISTING_USERNAME);
        mainPage.fillSignInPassword(TestingConstants.EXISTING_PASSWORD);
        mainPage.clickSignInConfirm();

        String userPanelName = mainPage.getUserPanelName();
        mainPage.logout();
        assertEquals(TestingConstants.EXISTING_USERNAME, userPanelName);
    }

    @Test
    public void signInIncorrectTest(){
        mainPage.clickSignIn();
        mainPage.fillSignInUsername(TestingConstants.WRONG_USERNAME);
        mainPage.fillSignInPassword(TestingConstants.WRONG_PASSWORD);
        mainPage.clickSignInConfirm();

        String errorMessage = mainPage.getSignInError();
        assertEquals("Неверное имя пользователя или пароль.", errorMessage);
    }
}
