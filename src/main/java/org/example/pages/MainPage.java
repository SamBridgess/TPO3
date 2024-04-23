package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[2]/div/a")
    private WebElement logo;

    // sign up elements
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

    // sign in elements
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/a")
    private WebElement signInButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/jsx/div/form/div/div[1]/div/div")
    private WebElement signInError;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/jsx/div/form/div/div[1]/div[2]/div/input")
    private WebElement signInUsername;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/jsx/div/form/div/div[2]/div[2]/div/input")
    private WebElement signInPassword;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/jsx/div/form/div/div[3]/button")
    private WebElement signInConfirmButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/div/div[3]/a[2]")
    private WebElement userPanel;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/div/div[3]/div[2]")
    private WebElement menu;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/div/div[3]/div[2]/div/ul/li[10]")
    private WebElement logoutButton;

    //@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/jsx/div/form/div/div[4]/div")
    @FindBy(how = How.CLASS_NAME, using = "spinner")
    private WebElement spinner;

    // search elements
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[4]/div/div[1]/input")
    private WebElement searchBar;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[4]/div/div[1]/button")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/div/div[3]/a[2]")
    private WebElement userProfileBar;

    @FindBy(how = How.CLASS_NAME, using = "lsr_i_highlight")
    private WebElement searchTextResult;

    protected WebDriverWait wait;
    protected Actions action;

    public void init(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // sign up elements
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

    public void clickSingUpConfirm() {
        wait.until(ExpectedConditions.visibilityOf(signUpConfirmButton));
        signUpConfirmButton.click();
    }

    public void closeRegister(){
        wait.until(ExpectedConditions.visibilityOf(closeRegisterButton));
        closeRegisterButton.click();;
    }

    // sign in elements
    public void clickSignIn(){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public void fillSignInUsername(String search){
        wait.until(ExpectedConditions.visibilityOf(signInUsername));
        signInUsername.sendKeys(search);
    }

    public void fillSignInPassword(String search){
        wait.until(ExpectedConditions.visibilityOf(signInPassword));
        signInPassword.sendKeys(search);
    }

    public String getSignInError(){
        wait.until(ExpectedConditions.invisibilityOf(spinner));

        wait.until(ExpectedConditions.visibilityOf(signInError));
        return signInError.getAttribute("innerHTML");
    }

    public void clickSignInConfirm(){
        wait.until(ExpectedConditions.visibilityOf(signInConfirmButton));
        signInConfirmButton.click();
    }

    public String getUserPanelName(){
        wait.until(ExpectedConditions.visibilityOf(userPanel));
        return userPanel.getAttribute("innerHTML");
    }

    public void logout(){
        wait.until(ExpectedConditions.visibilityOf(userPanel));
        action.moveToElement(userPanel).moveToElement(logoutButton).click().build().perform();

        wait.until(ExpectedConditions.visibilityOf(logo));
        logo.click();
    }


    // search elements
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
