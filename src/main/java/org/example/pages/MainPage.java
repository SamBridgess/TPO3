package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
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
    private WebElement registerButton;

    @FindBy(how = How.XPATH, using = "/html/body/jsx[3]/div/div/div[2]/div/button")
    private WebElement closeRegisterButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/a[1]")
    private WebElement signInButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[4]/div/div[1]/input")
    private WebElement searchBar;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[4]/div/div[1]/button")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/div/div[3]/a[2]")
    private WebElement userProfileBar;

    @FindBy(how = How.CLASS_NAME, using = "lsr_i_highlight")
    private WebElement searchTextResult;

    protected  WebDriverWait wait;

    public void init(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

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
        signUpUsername.sendKeys(username);
    }

    public void fillSignUpPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(signUpPassword));
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

    public void clickRegister() {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
    }

    public void closeRegister(){
        wait.until(ExpectedConditions.visibilityOf(closeRegisterButton));
        closeRegisterButton.click();;
    }

    public void clickSignIn(){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public void fillSearchBar(String search){
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(search);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }

    //todo remove
    public void pressEnter(){
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(Keys.RETURN);
    }

    public String getSearchResult(){
        wait.until(ExpectedConditions.visibilityOf(searchTextResult));
        return searchTextResult.getAttribute("innerHTML");
    }
}
