package com.selenium.statistics.test;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.base.TestUtil;
import com.selenium.course.statisticspages.LoginPageStatistics;
import com.selenium.course.statisticspages.StatisticsPage;
import com.selenium.course.statisticspages.SummaryPage;
import com.selenium.course.utils.CsvReader;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class StatisticsInfoCompany extends TestUtil {

    @DataProvider(name = "company-name-file")
    public static Object[][] dataProviderCreateAccountCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/company-name.csv");
    }

    @Test(dataProvider = "company-name-file" )

    public void executeStatisticsInfoCompany(String companyNameField, String dividendYieldField, String priceBookField){
        LoginPageStatistics loginPageStatistics = new LoginPageStatistics(driver);
        loginPageStatistics.login(companyNameField);

        SummaryPage summaryPage = new SummaryPage(driver);
        summaryPage.login(dividendYieldField);

        StatisticsPage statisticsPage = new StatisticsPage(driver);
        statisticsPage.StatisticsPage(priceBookField);

        Reporter.log("The comparison of the elements is successful.");


           }


        }




