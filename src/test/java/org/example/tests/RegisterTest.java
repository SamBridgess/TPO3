package org.example.tests;

import org.example.Constants;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {

    private static WebDriver driver;

    @BeforeAll
    public static void init() {
        driver = new FirefoxDriver();
        driver.get(" http://www.bongacams.com/");
    }

    public void testPassword(WebDriver driver, String password){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"user_member_username\"]")).sendKeys(password);



       // assertEquals("FAIL", );
    }

    @Test
    public void usernameTooShortTest() {
        testPassword(driver, Constants.USERNAME_TOO_SHORT);
    }

    @Test
    public void usernameTooLongTest() {
        testPassword(driver, Constants.USERNAME_TOO_LONG);
    }

    @Test
    public void usernameOnlyDigitsTest() {
        testPassword(driver, Constants.USERNAME_ONLY_DIGITS);
    }
}
