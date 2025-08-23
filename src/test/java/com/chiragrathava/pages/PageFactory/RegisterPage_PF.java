package com.chiragrathava.pages.PageFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage_PF {
    protected WebDriver driver;

    @FindBy(linkText = "Register")
    public WebElement registerLink;

    @FindBy(id = "gender-male")
    public WebElement genderMale;

    @FindBy(id = "gender-female")
    public WebElement genderFemale;

    @FindBy(id = "FirstName")
    public WebElement firstNameInput;

    @FindBy(id = "LastName")
    public WebElement lastNameInput;

    @FindBy(id = "Email")
    public WebElement emailInput;

    @FindBy(id = "Password")
    public WebElement passwordInput;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPasswordInput;

    @FindBy(id = "register-button")
    public WebElement registerButton;

    // Constructor
    public RegisterPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions
    @Step("Enter First Name: {firstName}")
    public void enterFirstName(String firstName) { firstNameInput.sendKeys(firstName); }

    @Step("Enter Last Name: {lastName}")
    public void enterLastName(String lastName) { lastNameInput.sendKeys(lastName); }

    @Step("Enter Email: {email}")
    public void enterEmail(String email) { emailInput.sendKeys(email); }

    @Step("Enter Password: ******")
    public void enterPassword(String password) { passwordInput.sendKeys(password); }

    @Step("Enter Confirm Password: ******")
    public void enterConfirmPassword(String confirmPassword) { confirmPasswordInput.sendKeys(confirmPassword); }

    @Step("Click on Register button")
    public void clickRegisterButton() { registerButton.click(); }

    @Step("Register user with email: {email}")
    public void register(String firstName, String lastName, String email, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(password);
        clickRegisterButton();
    }
}
