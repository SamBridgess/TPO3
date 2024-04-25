package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends Page{
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[4]/div/div[1]/input")
    private WebElement searchBar;

    // /html/body/div[2]/div[1]/div[4]/div/div[1]/button
    @FindBy(how = How.CLASS_NAME, using = "js-hns_submit")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[1]/div[5]/div/div/div[3]/a[2]")
    private WebElement userProfileBar;

    @FindBy(how = How.CLASS_NAME, using = "lsr_i_highlight")
    private WebElement searchTextResult;

    public void fillSearchBar(String search){
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(search);
    }

    public void clearSearchBar(){
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }

    public String getSearchResult(){
        wait.until(ExpectedConditions.visibilityOf(searchTextResult));
        return searchTextResult.getAttribute("innerHTML");
    }
}
