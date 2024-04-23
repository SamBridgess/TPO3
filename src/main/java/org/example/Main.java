package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get(" http://www.bongacams.com/");

        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[5]/a[1]")).click();

        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"btn_signup\"]")).click();

        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);





      //  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       // driver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[2]/div/div[1]/div/div/div[1]/div[1]")).click();

       // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      //  driver.findElement(By.xpath("/html/body/div[6]/div[2]/jsx/div/div/div[1]/div[3]/div[2]/ul/li[1]/label")).click();
    }
}
