package org.example.tests;


import org.example.TestingConstants;
import org.example.pages.RegisterPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest extends BaseTest {
    private static RegisterPage page;

    @BeforeAll
    public static void configureTest(){
        driver = new FirefoxDriver();
        driver.get(url);

        page = new RegisterPage();
        page.init(driver);

        page.agreeAndEnter();
    }

    private void skipWrongPopUps(){
        while(true){
            page.clickSignUp();
            String popUpType = page.getRegisterPopUpType();
            if(Objects.equals(popUpType, "member_join_popup horizont_green2 wl_default_links noemail"))
                break;
            page.closeRegister();
        }
    }

    private void testUsername(String expected, String username){
        skipWrongPopUps();

        page.fillSignUpUsername(username);
        page.fillSignUpPassword(TestingConstants.CORRECT_PASSWORD);
        page.clickTermsOfUse();

        String errorMessage = page.getUsernameError();
        page.closeRegister();
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

        page.fillSignUpUsername(TestingConstants.CORRECT_USERNAME);
        page.fillSignUpPassword(password);
        page.clickTermsOfUse();

        String errorMessage = page.getPasswordError();
        page.closeRegister();
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

        page.fillSignUpUsername(TestingConstants.CORRECT_USERNAME);
        page.fillSignUpPassword(TestingConstants.CORRECT_PASSWORD);
        page.clickSingUpConfirm();

        String errorMessage = page.getTermsOfUseError();
        page.closeRegister();
        assertEquals("Обязательно к заполнению.", errorMessage);
    }
}

// //*[@id="member_join_popup"]
//две бабы          <div id="member_join_popup" class="member_join_popup girls_blue wl_default_links noemail">
//баба с батарейкой <div id="member_join_popup" class="member_join_popup boom pop_langru noemail">
//баба с гантелями  <div id="member_join_popup" class="member_join_popup workout_join js-workout_popup noemail">
//без баб           <div id="member_join_popup" class="member_join_popup horizont_green2 wl_default_links noemail">
//баба с монеткой   <div id="member_join_popup" class="member_join_popup tspop reactions_join js-reactions noemail" data-outer-class="reactions_outer js-reactions_outer">
