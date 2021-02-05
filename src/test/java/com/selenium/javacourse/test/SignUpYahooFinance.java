package com.selenium.javacourse.test;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.base.TestUtil;
import com.selenium.course.pages.CreateAccountPage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.NewAccountPage;
import com.selenium.course.utils.CsvReader;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class SignUpYahooFinance extends TestUtil {

    @BeforeTest
    public void signUp() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        Reporter.log("Login is successful");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.login();
        }
    @DataProvider(name = "create-account-file")
    public static Object[][] dataProviderCreateAccountCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/create-account.csv");
    }
    @Test(dataProvider = "create-account-file" )
    public void executeSignUpYahooFinance(String fnameField, String lnameField, String emailadField, String passField,
                                          String phnumberField, String bmonthField, String bdayField, String byearField) {

        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.NewAccountPage(fnameField, lnameField, emailadField, passField, phnumberField, bmonthField, bdayField, byearField);

        newAccountPage.getEmailMessageError();
        newAccountPage.getPasswordMessageError();
        newAccountPage.getPhoneMessageError();
        newAccountPage.getBDateMessageError();

        Reporter.log("All necessary fields for negative tests are inputted.");

        }
        }




