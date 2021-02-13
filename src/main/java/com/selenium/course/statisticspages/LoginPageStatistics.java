package com.selenium.course.statisticspages;

import com.selenium.course.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class LoginPageStatistics extends BasePage {


    @FindBy(xpath = "//input[@id='yfin-usr-qry']")
    private WebElement searchField;

    public LoginPageStatistics(WebDriver driver) {
        super(driver);
    }

    public SummaryPage login (String companyNameField) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return window.stop");
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.visibilityOf(searchField));

        searchField.clear();
        searchField.sendKeys(companyNameField);
        searchField.sendKeys(Keys.ENTER);
        return new SummaryPage(driver);
            }
    }



