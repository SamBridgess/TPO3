package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuickSearchPage extends Page{
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]")
    private WebElement quickSearchButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"1ae9uy3r6wx_gender_female\"]")
    private WebElement femaleRadio;

    @FindBy(how = How.XPATH, using = "//*[@id=\"1ae9uy3r6wx_gender_couples\"]")
    private WebElement couplesRadio;

    @FindBy(how = How.XPATH, using = "//*[@id=\"1ae9uy3r6wx_gender_male\"]")
    private WebElement maleRadio;

    @FindBy(how = How.XPATH, using = "//*[@id=\"o4e0b0z0o6.i_region_north_america\"]")
    private WebElement northAmericaCheckbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"1b1wtp12jfj_region_europe\"]")
    private WebElement europeCheckbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"1b1wtp12jfj_region_cis\"]")
    private WebElement russiaCheckbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"o4e0b0z0o6.i_region_latin_america\"]")
    private WebElement latinAmericaCheckbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"o4e0b0z0o6.i_region_asia\"]")
    private WebElement asiaCheckbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"o4e0b0z0o6.i_region_other\"]")
    private WebElement otherCheckbox;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[4]/button[1]")
    private WebElement confirmQuickSearch;

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
}
