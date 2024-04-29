package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends Page{
    @FindBy(how = How.XPATH, using = "//*[@class=\"hns_input js-hns_input\"]")
    private WebElement searchBar;

    @FindBy(how = How.XPATH, using = "//*[@class=\"js-hns_submit hns_submit\"]")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"lsr_i_highlight\"]")
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
