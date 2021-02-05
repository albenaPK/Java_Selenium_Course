package com.selenium.course.statisticspages;

import com.selenium.course.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginPageStatistics extends BasePage {

    @FindBy(xpath = "//input[@id='yfin-usr-qry']")
    private WebElement searchField;

    public LoginPageStatistics(WebDriver driver) {
        super(driver);
    }

    public SummaryPage login (String companyNameField) {

        searchField.clear();
        searchField.sendKeys(companyNameField);
        searchField.sendKeys(Keys.ENTER);
        return new SummaryPage(driver);
            }
    }



