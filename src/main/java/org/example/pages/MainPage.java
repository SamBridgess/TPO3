package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"btn_signup\"]")
    private WebElement signUpButton;

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



    protected WebDriver driver;

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn(){
        signInButton.click();
    }

    public void clickSignUp() {
        signUpButton.click();
    }

    public void fillSearchBar(String search){
       searchBar.sendKeys(search);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String getSearchResult(){
        return searchTextResult.getAttribute("innerHTML");
    }
}
