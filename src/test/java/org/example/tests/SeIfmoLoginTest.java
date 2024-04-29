package org.example.tests;


import org.example.pages.Page;
import org.example.pages.SeIfmoPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class SeIfmoLoginTest {
    public static String url = "https://se.ifmo.ru/";
    public static WebDriver chromeDriver;
    public static WebDriver firefoxDriver;

    private static SeIfmoPage firefoxPage;
    private static SeIfmoPage chromePage;


    @BeforeAll
    public static void configureTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("window-size=1000,1500");

        chromeDriver = new ChromeDriver(options);
        chromeDriver.get(url);
        chromePage = new SeIfmoPage();

        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(url);
        firefoxPage = new SeIfmoPage();


        chromePage.init(chromeDriver);
        firefoxPage.init(firefoxDriver);
    }

    private static Stream<Page> driverProvider() {
        return Stream.of(chromePage, firefoxPage);
    }

    @ParameterizedTest
    @MethodSource("driverProvider")
    public void signInCorrectTest(SeIfmoPage page) throws InterruptedException {
        page.clickSignIn();
        page.fillUsername("");
        page.fillPassword("");
        if(page.equals(chromePage)) {
            Thread.sleep(3000);
        }
        page.clickSignInConfirm();


        String signOutText = page.getSignOutText();
        assertEquals("Выйти", signOutText);
    }
}
