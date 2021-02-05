package com.selenium.javacourse.test;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.base.TestUtil;
import com.selenium.course.utils.CsvReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class CreateAccount extends TestUtil {

    @DataProvider(name = "create-account")
    public static Object[][] dataProviderCreateAccount() {
        return new Object[][]{
                {"testchon", "peev", "test", "p1", "mp1", "March", "d1", "y1"},
                {"testchop", "gree", "test2", "p2", "mp2", "June", "d2", "y2"}
        };
    }

    @DataProvider(name = "create-account-file")
    public static Object[][] dataProviderCreateAccountCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/create-account.csv");
    }

    @Test(dataProvider = "create-account-file")
    public void executeSimpleTest(String fname, String lname, String emailad, String pass,
                                  String phnumber, String bmonth, String bday, String byear) {

        WebElement accept = driver.findElement(By.xpath("//button[@type='submit']"));
        accept.click();

        WebElement signIn = driver.findElement(By.xpath("//span[text() = 'Sign in']"));
        signIn.click();

        WebElement createAccount = driver.findElement(By.xpath("//a[contains(text(), 'account')]"));
        createAccount.click();

        WebElement usernameFirstName = driver.findElement(By.id("usernamereg-firstName"));
        usernameFirstName.sendKeys(fname);

        WebElement userNameLastname = driver.findElement(By.id("usernamereg-lastName"));
        userNameLastname.sendKeys(lname);

        WebElement email = driver.findElement(By.xpath("//input[@id='usernamereg-yid']"));
        email.sendKeys(emailad);
        email.sendKeys(Keys.TAB);

        WebElement password = driver.findElement(By.xpath("//input[@id='usernamereg-password']"));
        password.sendKeys(pass);

        WebElement mobilePhone = driver.findElement(By.xpath("//input[@id='usernamereg-phone']"));
        mobilePhone.sendKeys(phnumber);

//        Select monthOfBirth = new Select(driver.findElement(By.id("usernamereg-month")));
//        monthOfBirth.selectByVisibleText("March");
        WebElement monthOfBirth = driver.findElement(By.id("usernamereg-month"));
        monthOfBirth.sendKeys(bmonth);

        WebElement dayOfBirth = driver.findElement(By.xpath("//input[@id='usernamereg-day']"));
        dayOfBirth.sendKeys(bday);
        dayOfBirth.sendKeys(Keys.TAB);

        WebElement yearOfBirth = driver.findElement(By.xpath("//input[@id='usernamereg-year']"));
        yearOfBirth.sendKeys(byear);

        WebElement buttonContinue = driver.findElement(By.xpath("//button[@id='reg-submit-button']"));
        buttonContinue.click();

//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();", accept);
//            js.executeScript("arguments[0].scrollIntoView();", signIn);

        }

    }


