package com.chiragrathava.pages.pageFactory.Login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * LoginPageActions - Contains action methods for interacting with the Login Page
 */
public class Action {

    private WebDriver driver;
    private WebDriverWait wait;
    private Locator locator;

    public Action(WebDriver driver, WebDriverWait wait, Locator locator) {
        this.driver = driver;
        this.wait = wait;
        this.locator = locator;
    }

    public void enterEmail(String email) {
        try {
            wait.until(ExpectedConditions.visibilityOf(locator.emailField));
            locator.emailField.clear();
            locator.emailField.sendKeys(email);
            System.out.println("Entered email: " + email);
        } catch (Exception e) {
            System.err.println("Error entering email: " + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(locator.passwordField));
            locator.passwordField.clear();
            locator.passwordField.sendKeys(password);
            System.out.println("Entered password: " + "*".repeat(password.length()));
        } catch (Exception e) {
            System.err.println("Error entering password: " + e.getMessage());
        }
    }

    public void clickLoginButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator.loginButton));
            locator.loginButton.click();
            System.out.println("Clicked Login button");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.err.println("Error clicking login button: " + e.getMessage());
        }
    }

    public void checkRememberMe() {
        try {
            if (!locator.rememberMeCheckbox.isSelected()) {
                locator.rememberMeCheckbox.click();
                System.out.println("Checked Remember Me checkbox");
            }
        } catch (Exception e) {
            System.err.println("Error checking Remember Me: " + e.getMessage());
        }
    }

    public void uncheckRememberMe() {
        try {
            if (locator.rememberMeCheckbox.isSelected()) {
                locator.rememberMeCheckbox.click();
                System.out.println("Unchecked Remember Me checkbox");
            }
        } catch (Exception e) {
            System.err.println("Error unchecking Remember Me: " + e.getMessage());
        }
    }

    public void clickForgotPasswordLink() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator.forgotPasswordLink));
            locator.forgotPasswordLink.click();
            System.out.println("Clicked Forgot Password link");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println("Error clicking Forgot Password: " + e.getMessage());
        }
    }

    public void pressEnterKey() {
        try {
            locator.passwordField.sendKeys(Keys.ENTER);
            System.out.println("Pressed Enter key to submit form");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.err.println("Error pressing Enter key: " + e.getMessage());
        }
    }

    public void logout() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator.logoutButton));
            locator.logoutButton.click();
            System.out.println("Logged out successfully");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println("Error during logout: " + e.getMessage());
        }
    }

    public void performLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void performLoginWithRememberMe(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        checkRememberMe();
        clickLoginButton();
    }
}
