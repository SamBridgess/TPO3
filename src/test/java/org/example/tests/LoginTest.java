package org.example.tests;

import org.example.TestingConstants;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    private static String url = "http://www.bongacams.com/";
    private static WebDriver driver;
    private static LoginPage page;

    @BeforeAll
    public static void configureTest(){
        driver = new FirefoxDriver();
        driver.get(url);

        page = new LoginPage();
        page.init(driver);

        page.agreeAndEnter();
    }

    @Test
    public void signInCorrectTest(){
        page.clickSignIn();
        page.fillSignInUsername(TestingConstants.EXISTING_USERNAME);
        page.fillSignInPassword(TestingConstants.EXISTING_PASSWORD);
        page.clickSignInConfirm();

        String userPanelName = page.getUserPanelName();
        page.logout();
        assertEquals(TestingConstants.EXISTING_USERNAME, userPanelName);
    }

    @Test
    public void signInIncorrectTest(){
        page.clickSignIn();
        page.fillSignInUsername(TestingConstants.WRONG_USERNAME);
        page.fillSignInPassword(TestingConstants.WRONG_PASSWORD);
        page.clickSignInConfirm();

        String errorMessage = page.getSignInError();
        assertEquals("Неверное имя пользователя или пароль.", errorMessage);
    }
}
