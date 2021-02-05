package com.selenium.javacourse.test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleTest {
    WebDriver driver = null;

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void executeSimpleTest() throws InterruptedException {
        driver.get("https://finance.yahoo.com");

        WebElement accept = driver.findElement(By.xpath("//button[@type='submit']"));
        accept.click();

        WebElement signIn = driver.findElement(By.xpath("//span[text() = 'Sign in']"));
        signIn.click();

        WebElement createAccount = driver.findElement(By.xpath("//a[contains(text(), 'account')]"));
        createAccount.click();

        WebElement usernameFirstName = driver.findElement(By.id("usernamereg-firstName"));
        usernameFirstName.sendKeys("project");

        WebElement userNameLastname = driver.findElement(By.id("usernamereg-lastName"));
        userNameLastname.sendKeys("test");

        WebElement email = driver.findElement(By.xpath("//input[@id='usernamereg-yid']"));
        email.sendKeys("test");
        email.sendKeys(Keys.TAB);

        Thread.sleep(3000);

        WebElement password = driver.findElement(By.xpath("//input[@id='usernamereg-password']"));
        password.sendKeys("..");

        WebElement mobilePhone = driver.findElement(By.xpath("//input[@id='usernamereg-phone']"));
        mobilePhone.sendKeys("fdd");

        Select monthOfBirth = new Select(driver.findElement(By.id("usernamereg-month")));
        monthOfBirth.selectByVisibleText("March");

        WebElement dayOfBirth = driver.findElement(By.xpath("//input[@id='usernamereg-day']"));
        dayOfBirth.sendKeys("f");
        dayOfBirth.sendKeys(Keys.TAB);

        WebElement yearOfBirth = driver.findElement(By.xpath("//input[@id='usernamereg-year']"));
        yearOfBirth.sendKeys("f");

        WebElement buttonContinue = driver.findElement(By.xpath("//button[@id='reg-submit-button']"));
        buttonContinue.click();

        WebElement realEmailMessage = driver.findElement(By.xpath("//div[@id='reg-error-yid']"));
        String expectedEmailMessage = realEmailMessage.getText();
        Assert.assertEquals(expectedEmailMessage, "This email address is not available for sign up, try something else");

        String realPasswordMessage = driver.findElement(By.xpath("//div[@id='reg-error-password']")).getText();
        String expectedPasswordMessage = "Your password isn’t strong enough, try making it longer.";
        Assert.assertEquals(realPasswordMessage, expectedPasswordMessage);

        String realPhoneMessage = driver.findElement(By.xpath("//div[@id='reg-error-phone']")).getText();
        String expectedPhoneMessage = "That doesn’t look right, please re-enter your phone number.";
        Assert.assertEquals(realPhoneMessage, expectedPhoneMessage);

        String realBirthMessage = driver.findElement(By.xpath("//div[@id='reg-error-birthDate']")).getText();
        String expectedBirthMessage = "That doesn’t look right, please re-enter your birthday.";
        Assert.assertEquals(realBirthMessage, expectedBirthMessage);

    }

    @AfterTest
    public void tearDownDriver(){
        driver.quit();
    }
}
