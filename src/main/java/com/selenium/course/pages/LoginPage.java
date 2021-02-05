package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnAccept;

    @FindBy(xpath = "//span[text() = 'Sign in']")
    private WebElement btnSignIn;

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage login (){

        btnAccept.click();
        btnSignIn.click();
        return new CreateAccountPage(driver);
           }

}


