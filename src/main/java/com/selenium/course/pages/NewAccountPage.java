package com.selenium.course.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.NoSuchElementException;

@Slf4j
public class NewAccountPage extends BasePage {

    private static final String REAL_EMAIL_MESSAGE_ERROR = "//div[@id='reg-error-yid']";
    private static final String REAL_PASSWORD_MESSAGE_ERROR = "//div[@id='reg-error-password']";
    private static final String REAL_PHONE_MESSAGE_ERROR = "//div[@id='reg-error-phone']";
    private static final String REAL_B_DATE_MESSAGE_ERROR = "//div[@id='reg-error-birthDate']";

    private static final String EXPECTED_EMAIL_MESSAGE = "This email address is not available for sign up, try something else";
    private static final String EXPECTED_PASSWORD_MESSAGE = "Your password isn’t strong enough, try making it longer.";
    private static final String EXPECTED_PHONE_MESSAGE = "That doesn’t look right, please re-enter your phone number.";
    private static final String EXPECTED_B_DATE_MESSAGE = "That doesn’t look right, please re-enter your birthday.";


    @FindBy(id = "usernamereg-firstName")
    private WebElement usernameFirstName;

    @FindBy(id = "usernamereg-lastName")
    private WebElement userNameLastname;

    //@FindBy(xpath = "//input[@id='usernamereg-yid']")
    @FindBy(id = "usernamereg-yid")
    private WebElement email;

    @FindBy(xpath = "//input[@id='usernamereg-password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='usernamereg-phone']")
    private WebElement mobilePhone;

    @FindBy(id = "usernamereg-month")
    private WebElement monthOfBirth;

    @FindBy(xpath = "//input[@id='usernamereg-day']")
    private WebElement dayOfBirth;

    @FindBy(xpath = "//input[@id='usernamereg-year']")
    private WebElement yearOfBirth;

    @FindBy(xpath = "//button[@id='reg-submit-button']")
    private WebElement btnContinue;

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    public void NewAccountPage(String fnameField, String lnameField, String emailadField, String passField,
                               String phnumberField, String bmonthField, String bdayField, String byearField) {
        usernameFirstName.clear();
        usernameFirstName.sendKeys(fnameField);
        userNameLastname.clear();
        userNameLastname.sendKeys(lnameField);
        email.clear();
        email.sendKeys(emailadField);
        email.sendKeys(Keys.TAB);
//        FluentWait fluentWait = new FluentWait(driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .ignoring(NoSuchElementException.class);
//
//        fluentWait.until(ExpectedConditions.visibilityOf(email));

        password.sendKeys(passField);
        mobilePhone.clear();
        mobilePhone.sendKeys(phnumberField);
        monthOfBirth.isSelected();
        monthOfBirth.sendKeys(bmonthField);
        dayOfBirth.clear();
        dayOfBirth.sendKeys(bdayField);
        dayOfBirth.sendKeys(Keys.TAB);
        yearOfBirth.clear();
        yearOfBirth.sendKeys(byearField);
        btnContinue.click();
    }

        SoftAssert softAssert = new SoftAssert();

    public void getEmailMessageError () {
        String emailMessage = driver.findElement(By.xpath(REAL_EMAIL_MESSAGE_ERROR)).getText();
        log.info("The Real email message is: " + emailMessage);
        softAssert.assertEquals(emailMessage, EXPECTED_EMAIL_MESSAGE);
        softAssert.assertAll();
    }
    public void getPasswordMessageError () {
        String passwordMessage = driver.findElement(By.xpath(REAL_PASSWORD_MESSAGE_ERROR)).getText();
        log.info("Test Real password message is: " + passwordMessage);
        softAssert.assertEquals(passwordMessage, EXPECTED_PASSWORD_MESSAGE);
        softAssert.assertAll();
    }
    public void getPhoneMessageError () {
        String phoneMessage = driver.findElement(By.xpath(REAL_PHONE_MESSAGE_ERROR)).getText();
        log.info("Test Real phone message is: " + phoneMessage);
        softAssert.assertEquals(phoneMessage, EXPECTED_PHONE_MESSAGE);
        softAssert.assertAll();
    }
    public void getBDateMessageError () {
        String bDateMessage = driver.findElement(By.xpath(REAL_B_DATE_MESSAGE_ERROR)).getText();
        log.info("Test Real Birth Date message is: " + bDateMessage);
        softAssert.assertEquals(bDateMessage, EXPECTED_B_DATE_MESSAGE);
        softAssert.assertAll();
    }

    }



