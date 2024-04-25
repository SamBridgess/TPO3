package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuickSearchPage extends Page{
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]")
    private WebElement quickSearchButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[1]/div[2]/ul/li[1]/label")
    private WebElement femaleRadio;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[1]/div[2]/ul/li[2]/label")
    private WebElement couplesRadio;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[1]/div[2]/ul/li[3]/label")
    private WebElement maleRadio;


                                   // /html/body/div[7]/div[2]/jsx/div/div/div[1]/div[3]/div[2]/ul/li[1]/label
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[3]/div[2]/ul/li[1]/label")
    private WebElement northAmericaCheckbox;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[3]/div[2]/ul/li[2]/label")
    private WebElement europeCheckbox;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[3]/div[2]/ul/li[3]/label")
    private WebElement russiaCheckbox;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[3]/div[2]/ul/li[4]/label")
    private WebElement latinAmericaCheckbox;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[3]/div[2]/ul/li[5]/label")
    private WebElement asiaCheckbox;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[3]/div[2]/ul/li[6]/label")
    private WebElement otherCheckbox;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[4]/button[1]")
    private WebElement confirmQuickSearch;

    @FindBy(how = How.CLASS_NAME, using = "lsr_i_highlight")
    private WebElement searchTextResult;

    public void clickQuickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(quickSearchButton));
        quickSearchButton.click();
    }

    public void clickFemaleRadio() {
        wait.until(ExpectedConditions.visibilityOf(femaleRadio));
        femaleRadio.click();
    }

    public void clickCouplesRadio() {
        wait.until(ExpectedConditions.visibilityOf(couplesRadio));
        couplesRadio.click();
    }

    public void clickMaleRadio() {
        wait.until(ExpectedConditions.visibilityOf(maleRadio));
        maleRadio.click();
    }

    public void clickNorthAmericaCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(northAmericaCheckbox));
        northAmericaCheckbox.click();
    }

    public void clickEuropeCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(europeCheckbox));
        europeCheckbox.click();
    }

    public void clickRussiaCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(russiaCheckbox));
        russiaCheckbox.click();
    }

    public void clickLatinAmericaCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(latinAmericaCheckbox));
        latinAmericaCheckbox.click();
    }

    public void clickAsiaCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(asiaCheckbox));
        asiaCheckbox.click();
    }

    public void clickOtherCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(otherCheckbox));
        otherCheckbox.click();
    }

    public void clickConfirmQuickSearch() {
        wait.until(ExpectedConditions.visibilityOf(confirmQuickSearch));
        confirmQuickSearch.click();
    }

    public String getSearchResult(){
        wait.until(ExpectedConditions.visibilityOf(searchTextResult));
        return searchTextResult.getAttribute("innerHTML");
    }
}
