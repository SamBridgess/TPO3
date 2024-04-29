package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    @FindBy(how = How.XPATH, using = "//*[@class=\"mls_btn bt30_green agree wl_green_btn js-close_warning\"]")
    private WebElement agreeAndEnterButton;

    protected WebDriverWait wait;
    protected Actions action;

    public void init(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void agreeAndEnter() {
        wait.until(ExpectedConditions.visibilityOf(agreeAndEnterButton));
        agreeAndEnterButton.click();
    }
}
