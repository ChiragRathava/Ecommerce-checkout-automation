package com.chiragrathava.pages.PageFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PF {
    protected WebDriver driver;

    // Locators
    @FindBy(linkText = "Log in")
    WebElement linkLogin;

    @FindBy(linkText = "Register")
    WebElement linkRegister;

    @FindBy(linkText = "Log out")
    WebElement linkLogout;

    @FindBy(id = "small-searchterms")
    WebElement inputSearchBox;

    @FindBy(xpath = "//button[@type='submit' and @class='search-box-button']")
    WebElement btnSearch;

    // Constructor
    public HomePage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions with @Step
    @Step("Click on Login link")
    public void clickLogin() {
        linkLogin.click();
    }

    @Step("Click on Register link")
    public void clickRegister() {
        linkRegister.click();
    }

    @Step("Click on Logout link")
    public void clickLogout() {
        linkLogout.click();
    }

    @Step("Search for product: {productName}")
    public void searchProduct(String productName) {
        inputSearchBox.clear();
        inputSearchBox.sendKeys(productName);
        btnSearch.click();
    }

    // Composite Action
    @Step("Navigate to Registration Page")
    public RegisterPage_PF navigateToRegisterPage() {
        clickRegister();
        return new RegisterPage_PF(driver);
    }

    @Step("Navigate to Login Page")
    public LoginPage_PF navigateToLoginPage() {
        clickLogin();
        return new LoginPage_PF(driver);
    }
}
