package com.selenium.javacourse.test;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.utils.CsvReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class WaitTest {
    WebDriver driver = null;

    @DataProvider(name = "create-account-file")
    public static Object[][] dataProviderCreateAccountCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/create-account.csv");
        }

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "create-account-file")
    public void executeSimpleTest(String fname, String lname, String emailad, String pass,
                                  String phnumber, String bmonth, String bday, String byear)
        throws InterruptedException {
        driver.get("https://finance.yahoo.com");

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

        Select monthOfBirth = new Select(driver.findElement(By.id("usernamereg-month")));
        monthOfBirth.selectByVisibleText("March");

        WebElement dayOfBirth = driver.findElement(By.xpath("//input[@id='usernamereg-day']"));
        dayOfBirth.sendKeys(bday);
        dayOfBirth.sendKeys(Keys.TAB);

        WebElement yearOfBirth = driver.findElement(By.xpath("//input[@id='usernamereg-year']"));
        yearOfBirth.sendKeys(byear);


        WebElement buttonContinue = driver.findElement(By.xpath("//button[@id='reg-submit-button']"));
        buttonContinue.click();

    }
}


