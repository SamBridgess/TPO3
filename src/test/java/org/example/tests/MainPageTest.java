package org.example.tests;

import org.example.TestingConstants;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {
    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeAll
    public static void configureTest(){
        driver = new FirefoxDriver();
        driver.get("http://www.bongacams.com/");

        mainPage = new MainPage();
        mainPage.init(driver);

        //todo согласиться зайти на сайт (надо думать куда убрать это)
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[5]/a[1]")).click();
    }
/*

    @Test
    public void correctSearchTest() {
        mainPage.fillSearchBar(TestingConstants.CORRECT_SEARCH);
        mainPage.clickSearchButton(); // почему-то работает только если кликнуть 2 раза (wtf)
        mainPage.clickSearchButton();

        String searchResult = mainPage.getSearchResult();
        assertEquals("Результат поиска:", searchResult);
    }

    @Test
    public void incorrectSearchTest() {
        mainPage.fillSearchBar(TestingConstants.INCORRECT_SEARCH);
        mainPage.clickSearchButton(); // wtf
        mainPage.clickSearchButton();

        String searchResult = mainPage.getSearchResult();
        assertEquals("По вашему запросу ничего не найдено.", searchResult);
    }
*/

    private void skipWrongPopUps(){
        while(true){
            mainPage.clickSignUp();
            String popUpType = mainPage.getRegisterPopUpType();
            if(Objects.equals(popUpType, "member_join_popup horizont_green2 wl_default_links noemail"))
                break;
            mainPage.closeRegister();
        }
    }

    private void testUsername(String username, String expected){
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
        testUsername(TestingConstants.USERNAME_TOO_SHORT,"Слишком короткий (3 символов минимум).");
    }

    @Test
    public void usernameTooLongTest() {
        testUsername(TestingConstants.USERNAME_TOO_LONG,"Слишком длинный (24 символов максимум).");
    }

    @Test
    public void usernameOnlyDigitsTest() {
        testUsername(TestingConstants.USERNAME_ONLY_DIGITS,"Только числа (0-9) запрещены.");
    }

    @Test
    public void usernameAlreadyExistsTest() {
        testUsername(TestingConstants.EXISTING_USERNAME,"Это имя пользователя уже занято. Попробуйте другое.");
    }

    @Test
    public void usernameEmptyTest() {
        testUsername(TestingConstants.EMPTY,"Обязательно к заполнению.");
    }


    private void testPassword(String password, String expected){
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
        testPassword(TestingConstants.PASSWORD_TOO_SHORT,"Введенное значение слишком короткое");
    }

    @Test
    public void passwordTooLongTest() {
        testPassword(TestingConstants.PASSWORD_TOO_LONG,"Введенное значение слишком длинное");
    }

    @Test
    public void passwordEmptyTest() {
        testUsername(TestingConstants.EMPTY,"Обязательно к заполнению.");
    }

    @Test
    public void termsOfUseTest(){
        skipWrongPopUps();

        mainPage.fillSignUpUsername(TestingConstants.CORRECT_USERNAME);
        mainPage.fillSignUpPassword(TestingConstants.CORRECT_PASSWORD);
        mainPage.clickRegister();

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
