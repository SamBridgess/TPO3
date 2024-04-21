package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div/div/div[2]/div[5]/a[1]")
    public WebElement confirmEntranceButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"btn_signup\"]")
    public WebElement signUpButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/a[1]")
    public WebElement signInButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[4]/div/div[1]/input")
    public WebElement searchBar;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[4]/div/div[1]/button")
    public WebElement searchButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/div/div[3]/a[2]")
    public WebElement userProfileBar;


    public void clickSignIn(){
        signInButton.click();
    }

    public void clickSignUp() {
        signUpButton.click();
    }


}
