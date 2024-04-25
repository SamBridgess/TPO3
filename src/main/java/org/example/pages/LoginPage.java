package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page{
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/a")
    private WebElement signInButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/jsx/div/form/div/div[1]/div/div")
    private WebElement signInError;

    // /html/body/div[2]/div[1]/div[5]/div/jsx/div/form/div/div[1]/div[2]/div/input
    @FindBy(how = How.NAME, using = "log_in[username]")
    private WebElement signInUsername;

    // /html/body/div[2]/div[1]/div[5]/div/jsx/div/form/div/div[2]/div[2]/div/input
    @FindBy(how = How.NAME, using = "log_in[password]")
    private WebElement signInPassword;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/jsx/div/form/div/div[3]/button")
    private WebElement signInConfirmButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/div/div[3]/a[2]")
    private WebElement userPanel;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/div/div[3]/div[2]")
    private WebElement menu;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/div/div[3]/div[2]/div/ul/li[10]")
    private WebElement logoutButton;

    @FindBy(how = How.CLASS_NAME, using = "spinner")
    private WebElement spinner;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[6]/div/div/div[1]/div[1]/div[2]/span/a")
    private WebElement goToMainPage;

    public void clickSignIn(){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public void fillSignInUsername(String search){
        wait.until(ExpectedConditions.visibilityOf(signInUsername));
        signInUsername.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        signInUsername.sendKeys(search);
    }

    public void fillSignInPassword(String search){
        wait.until(ExpectedConditions.visibilityOf(signInPassword));
        signInPassword.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
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

        wait.until(ExpectedConditions.visibilityOf(goToMainPage));
        goToMainPage.click();
    }
}
