package com.chiragrathava.pages.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {
    protected WebDriver driver;

    @FindBy(linkText = "Log in")
    public WebElement loginLink;

    @FindBy(id = "Email")
    public WebElement emailInput;

    @FindBy(id = "Password")
    public WebElement passwordInput;

    @FindBy(css = "button.button-1.login-button")
    public WebElement loginButton;

    public LoginPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
