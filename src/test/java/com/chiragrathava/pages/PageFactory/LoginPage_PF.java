package com.chiragrathava.pages.PageFactory;

import io.qameta.allure.Step;
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

    // Actions
    // Steps with Allure annotations
    @Step("Click on Login link")
    public void clickLoginLink() {
        loginLink.click();
    }

    @Step("Enter email: {email}")
    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Enter password: {password}")
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Click on Login button")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Login with email: {email} and password: {password}")
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
