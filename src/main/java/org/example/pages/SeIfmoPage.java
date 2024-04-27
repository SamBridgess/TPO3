package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeIfmoPage extends Page{
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/nav/div/div[3]/a[1]")
    private WebElement signInButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div/div/section/div/div[2]/div/div/form/fieldset/fieldset/div/div[1]/input")
    private WebElement usernameField;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div/div/section/div/div[2]/div/div/form/fieldset/fieldset/div/div[2]/input")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div/div/section/div/div[2]/div/div/form/fieldset/div[2]/button")
    private WebElement signInConfirmButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/nav/div/div[3]/a[1]")
    private WebElement signOutButton;

    @Override
    public void agreeAndEnter(){
        System.out.println("No");
    }

    public void clickSignIn(){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public void fillUsername(String username){
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        usernameField.sendKeys(username);
    }

    public void fillPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        passwordField.sendKeys(password);
    }

    public void clickSignInConfirm(){
        wait.until(ExpectedConditions.visibilityOf(signInConfirmButton));
        signInConfirmButton.click();
    }

    public String getSignOutText(){
        wait.until(ExpectedConditions.visibilityOf(signOutButton));
        return signOutButton.getAttribute("innerHTML");
    }
}
