package com.selenium.course.statisticspages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

@Slf4j
public class SummaryPage extends BasePage {

    private static final String DIVIDENDS_RATE_MESSAGE = "The Results for Company Dividends rate are not equal.";

    @FindBy(xpath = "//span[text() = 'Forward Dividend & Yield'] //ancestor::tr[@class='Bxz(bb) Bdbw(1px) Bdbs(s) Bdc($seperatorColor) H(36px) ']//td[@class='Ta(end) Fw(600) Lh(14px)']")
    private WebElement companyDividendYield;



    public SummaryPage(WebDriver driver) {super(driver);}

    public StatisticsPage login(String dividendYieldField){

        log.info("Company Dividends rate: Forward Dividend & Yield is: " + companyDividendYield.getText());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(companyDividendYield.getText(),dividendYieldField, DIVIDENDS_RATE_MESSAGE);
        softAssert.assertAll();
        return new StatisticsPage(driver);
    }



    }


