package com.selenium.course.base;

import com.selenium.course.driver.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TestUtil {
    private String url;
    private int implicitWait;
    private String browser;
    public WebDriver driver;

    @BeforeSuite

    public void readConfigProperties(){
        try(FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")){
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("browser");
            log.info("Url is " + url);
            log.info("Browser is " + browser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @BeforeTest
        public void initTest() {
        setupBrowserDriver();
        loadUrl();
        acceptCookies();
        }
    public void acceptCookies(){
        List<WebElement> elementList = driver.findElements(By.xpath("//button[@class='btn primary']"));
        if (elementList.size() > 0) {
            WebElement acceptCookies =  driver.findElement(By.xpath("//button[@class='btn primary']"));
            acceptCookies.click();
        }
    }

    @AfterTest
    public void tearDownDriver () {
        driver.quit();
    }


    private void setupBrowserDriver() {
          if (this.browser.equals("FirefoxDriver")) {
        driver = DriverFactory.getFirefoxDriver(implicitWait);
        //driver = DriverFactory.getChromeDriver(implicitWait);
          }else if(browser.equals("ChromeDriver")){
            driver = DriverFactory.getChromeDriver(implicitWait);

        }
    }
    private void loadUrl(){
        driver.get(url);
    }

}
