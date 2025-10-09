package com.chiragrathava.pages.pageFactory.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginPageLocators - Contains all locators for the Login Page
 */
public class Locator {

    // WebElement locators
    @FindBy(xpath = "button-1 register-button")
    public WebElement Register;

    @FindBy(id = "Email")
    public WebElement emailField;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    public WebElement loginButton;

    @FindBy(linkText = "My account")
    public WebElement myAccountLink;

    @FindBy(linkText = "Log out")
    public WebElement logoutLink;


    @FindBy(id = "RememberMe")
    public WebElement rememberMeCheckbox;

    @FindBy(linkText = "Forgot Password?")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    public WebElement emailValidationError;

    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    public WebElement errorMessage;


//    @FindBy(css = ".account-locked-message")
//    public WebElement accountLockedMessage;

//    @FindBy(css = ".rate-limit-message")
//    public WebElement rateLimitMessage;

//    @FindBy(name = "_csrf")
//    public WebElement csrfToken;

    @FindBy(css = ".dashboard-header")
    public WebElement dashboardHeader;

    @FindBy(id = "logoutButton")
    public WebElement logoutButton;

//    // By locators
//    public By emailFieldBy = By.id("email");
//    public By passwordFieldBy = By.id("password");
//    public By loginButtonBy = By.id("loginButton");
//    public By errorMessageBy = By.cssSelector(".error-message");
}
