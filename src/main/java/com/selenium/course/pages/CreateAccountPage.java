package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'account')]")
    private WebElement btnCreateAccount;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public NewAccountPage login (){
        btnCreateAccount.click();
        return new NewAccountPage(driver);
           }
}


