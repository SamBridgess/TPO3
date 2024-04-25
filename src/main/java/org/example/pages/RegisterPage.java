package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends Page {
    @FindBy(how = How.XPATH, using = "//*[@id=\"btn_signup\"]")
    private WebElement signUpButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"member_join_popup\"]")
    private WebElement registerPopUp;

    @FindBy(how = How.XPATH, using = "//*[@id=\"user_member_username\"]")
    private WebElement signUpUsername;

    @FindBy(how = How.XPATH, using = "//*[@id=\"user_member_password\"]")
    private WebElement signUpPassword;

    @FindBy(how = How.XPATH, using = "//*[@id=\"user_member_terms_of_use\"]")
    private WebElement termsOfUseBox;

    @FindBy(how = How.XPATH, using = "/html/body/jsx[3]/div/div/div[2]/div/div/div/div/div[2]/form/div/div[1]/div[1]/div[1]/div[4]/div/div")
    private WebElement usernameError;

    @FindBy(how = How.XPATH, using = "/html/body/jsx[3]/div/div/div[2]/div/div/div/div/div[2]/form/div/div[1]/div[2]/div/div[4]/div/div")
    private WebElement passwordError;

    @FindBy(how = How.XPATH, using = "/html/body/jsx[3]/div/div/div[2]/div/div/div/div/div[2]/form/div/div[1]/div[4]/div/div[4]/div/div")
    private WebElement termsOfUseError;

    @FindBy(how = How.XPATH, using = "/html/body/jsx[3]/div/div/div[2]/div/div/div/div/div[2]/form/div/div[2]/button")
    private WebElement signUpConfirmButton;

    @FindBy(how = How.XPATH, using = "/html/body/jsx[3]/div/div/div[2]/div/button")
    private WebElement closeRegisterButton;


    public void clickSignUp() {
        wait.until(ExpectedConditions.visibilityOf(signUpButton));
        signUpButton.click();
    }

    public String getRegisterPopUpType() {
        wait.until(ExpectedConditions.visibilityOf(registerPopUp));
        return registerPopUp.getAttribute("class");
    }

    public void fillSignUpUsername(String username){
        wait.until(ExpectedConditions.visibilityOf(signUpUsername));
        signUpUsername.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        signUpUsername.sendKeys(username);
    }

    public void fillSignUpPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(signUpPassword));
        signUpPassword.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        signUpPassword.sendKeys(password);
    }

    public void clickTermsOfUse(){
        wait.until(ExpectedConditions.visibilityOf(termsOfUseBox));
        termsOfUseBox.click();
    }

    public String getUsernameError(){
        wait.until(ExpectedConditions.visibilityOf(usernameError));
        return usernameError.getAttribute("innerHTML");
    }

    public String getPasswordError(){
        wait.until(ExpectedConditions.visibilityOf(passwordError));
        return passwordError.getAttribute("innerHTML");
    }

    public String getTermsOfUseError(){
        wait.until(ExpectedConditions.visibilityOf(termsOfUseError));
        return termsOfUseError.getAttribute("innerHTML");
    }

    public void clickSingUpConfirm() {
        wait.until(ExpectedConditions.visibilityOf(signUpConfirmButton));
        signUpConfirmButton.click();
    }

    public void closeRegister(){
        wait.until(ExpectedConditions.visibilityOf(closeRegisterButton));
        closeRegisterButton.click();;
    }
}
