package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page {
    protected WebDriver driver;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div/div/div[2]/div[5]/a[1]")
    public WebElement confirmEntranceButton;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected static<T> T initialize(WebDriver driver, String checkXpath, Class<T> clazz) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class);
        wait.until(d -> {
            return d.findElement(By.xpath(checkXpath)).isDisplayed();
        });
        return PageFactory.initElements(driver, clazz);
    }

}
