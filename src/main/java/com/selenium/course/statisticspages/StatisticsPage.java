package com.selenium.course.statisticspages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

@Slf4j
public class StatisticsPage extends BasePage {

    private static final String PRICE_BOOK_MESSAGE = "The Results for Price book are not equal.";

    @FindBy(xpath = "//span[text()='Statistics']")
    private WebElement statisticsBar;


    @FindBy(xpath = "//span[text() = 'Price/Book']//ancestor::tr[@class='Bxz(bb) H(36px) BdB Bdbc($seperatorColor) fi-row Bgc($hoverBgColor):h']//td[@class='Fw(500) Ta(end) Pstart(10px) Miw(60px)']")
    private WebElement priceBook;

    public StatisticsPage(WebDriver driver){super(driver);}

    public void StatisticsPage(String priceBookField){


        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.visibilityOf(statisticsBar));
        statisticsBar.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return window.stop");

        log.info("Actual Price Book is: " + priceBook.getText());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(priceBook.getText(),priceBookField, PRICE_BOOK_MESSAGE);
        softAssert.assertAll();

        }


    }



