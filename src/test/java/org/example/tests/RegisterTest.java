package org.example.tests;


import org.example.TestingConstants;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {
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

    private void skipWrongPopUps(){
        while(true){
            mainPage.clickSignUp();
            String popUpType = mainPage.getRegisterPopUpType();
            if(Objects.equals(popUpType, "member_join_popup horizont_green2 wl_default_links noemail"))
                break;
            mainPage.closeRegister();
        }
    }

    private void testUsername(String expected, String username){
        skipWrongPopUps();

        mainPage.fillSignUpUsername(username);
        mainPage.fillSignUpPassword(TestingConstants.CORRECT_PASSWORD);
        mainPage.clickTermsOfUse();

        String errorMessage = mainPage.getUsernameError();
        mainPage.closeRegister();
        assertEquals(expected, errorMessage);
    }

    @Test
    public void usernameTooShortTest() {
        testUsername("Слишком короткий (3 символов минимум).", TestingConstants.USERNAME_TOO_SHORT);
    }

    @Test
    public void usernameTooLongTest() {
        testUsername("Слишком длинный (24 символов максимум).", TestingConstants.USERNAME_TOO_LONG);
    }

    @Test
    public void usernameOnlyDigitsTest() {
        testUsername("Только числа (0-9) запрещены.", TestingConstants.USERNAME_ONLY_DIGITS);
    }

    @Test
    public void usernameAlreadyExistsTest() {
        testUsername("Это имя пользователя уже занято. Попробуйте другое.", TestingConstants.EXISTING_USERNAME);
    }

    @Test
    public void usernameEmptyTest() {
        testUsername("Обязательно к заполнению.", TestingConstants.EMPTY);
    }


    private void testPassword(String expected, String password){
        skipWrongPopUps();

        mainPage.fillSignUpUsername(TestingConstants.CORRECT_USERNAME);
        mainPage.fillSignUpPassword(password);
        mainPage.clickTermsOfUse();

        String errorMessage = mainPage.getPasswordError();
        mainPage.closeRegister();
        assertEquals(expected, errorMessage);
    }

    @Test
    public void passwordTooShortTest() {
        testPassword("Введенное значение слишком короткое", TestingConstants.PASSWORD_TOO_SHORT);
    }

    @Test
    public void passwordTooLongTest() {
        testPassword("Введенное значение слишком длинное", TestingConstants.PASSWORD_TOO_LONG);
    }

    @Test
    public void passwordEmptyTest() {
        testUsername("Обязательно к заполнению.", TestingConstants.EMPTY);
    }

    @Test
    public void termsOfUseTest(){
        skipWrongPopUps();

        mainPage.fillSignUpUsername(TestingConstants.CORRECT_USERNAME);
        mainPage.fillSignUpPassword(TestingConstants.CORRECT_PASSWORD);
        mainPage.clickSingUpConfirm();

        String errorMessage = mainPage.getTermsOfUseError();
        mainPage.closeRegister();
        assertEquals("Обязательно к заполнению.", errorMessage);
    }
}

// //*[@id="member_join_popup"]
//две бабы          <div id="member_join_popup" class="member_join_popup girls_blue wl_default_links noemail">
//баба с батарейкой <div id="member_join_popup" class="member_join_popup boom pop_langru noemail">
//баба с гантелями  <div id="member_join_popup" class="member_join_popup workout_join js-workout_popup noemail">
//без баб           <div id="member_join_popup" class="member_join_popup horizont_green2 wl_default_links noemail">
//баба с монеткой   <div id="member_join_popup" class="member_join_popup tspop reactions_join js-reactions noemail" data-outer-class="reactions_outer js-reactions_outer">
