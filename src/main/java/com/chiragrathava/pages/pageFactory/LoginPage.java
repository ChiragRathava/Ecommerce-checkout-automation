package com.chiragrathava.pages.pageFactory;

import com.chiragrathava.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInLink;

    @FindBy(xpath = "//div[@class='alert alert-danger']//ol//li")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//a[@title='Log me out']")
    private WebElement logoutLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Sign In page")
    public LoginPage clickSignIn() {
        clickElement(signInLink);
        return this;
    }

    @Step("Enter email: {email}")
    public LoginPage enterEmail(String email) {
        enterText(emailField, email);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        enterText(passwordField, password);
        return this;
    }

    @Step("Click login button")
    public HomePage clickLoginButton() {
        clickElement(loginButton);
        return new HomePage(driver);
    }

    @Step("Perform login with credentials: {email}")
    public HomePage login(String email, String password) {
        clickSignIn();
        enterEmail(email);
        enterPassword(password);
        return clickLoginButton();
    }

    @Step("Get login error message")
    public String getErrorMessage() {
        try {
            return getElementText(errorMessage);
        } catch (Exception e) {
            return "";
        }
    }

    @Step("Check if user is logged in")
    public boolean isUserLoggedIn() {
        try {
            return isElementDisplayed(myAccountLink);
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Logout user")
    public LoginPage logout() {
        if (isUserLoggedIn()) {
            clickElement(logoutLink);
        }
        return this;
    }
}
