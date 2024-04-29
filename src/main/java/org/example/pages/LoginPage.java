package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page{
    @FindBy(how = How.XPATH, using = "//*[@class=\"bt30 bt30_maroon bc_uppercase join_btn\"]")
    private WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"form_error\"]")
    private WebElement signInError;

    @FindBy(how = How.XPATH, using = "//*[@name=\"log_in[username]\"]")
    private WebElement signInUsername;

    @FindBy(how = How.XPATH, using = "//*[@name=\"log_in[password]\"]")
    private WebElement signInPassword;

    @FindBy(how = How.XPATH, using = "//*[@class=\"fa_btn bt30 bt30_green\"]")
    private WebElement signInConfirmButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"name\"]")
    private WebElement userPanel;

    @FindBy(how = How.XPATH, using = "//*[@class=\"control_popover js-control_popover\"]")
    private WebElement menu;

    @FindBy(how = How.XPATH, using = "//*[@class=\"cp_l_item __logout\"]")
    private WebElement logoutButton;

    @FindBy(how = How.CLASS_NAME, using = "//*[@class=\"spinner\"]")
    private WebElement spinner;


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
    }
}
