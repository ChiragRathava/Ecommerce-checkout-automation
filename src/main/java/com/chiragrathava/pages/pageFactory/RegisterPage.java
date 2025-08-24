package com.chiragrathava.pages.pageFactory;

import com.chiragrathava.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Company")
    private WebElement companyField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement registrationSuccessMessage;

    @FindBy(id = "gender-male")
    private WebElement maleGenderRadio;

    @FindBy(id = "gender-female")
    private WebElement femaleGenderRadio;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Register page")
    public RegisterPage navigateToRegisterPage() {
        navigateToUrl("https://demo.nopcommerce.com/register?returnUrl=%2F");
        return this;
    }

    @Step("Enter first name: {firstName}")
    public RegisterPage enterFirstName(String firstName) {
        enterText(firstNameField, firstName);
        return this;
    }

    @Step("Enter last name: {lastName}")
    public RegisterPage enterLastName(String lastName) {
        enterText(lastNameField, lastName);
        return this;
    }

    @Step("Enter email: {email}")
    public RegisterPage enterEmail(String email) {
        enterText(emailField, email);
        return this;
    }

    @Step("Enter company: {company}")
    public RegisterPage enterCompany(String company) {
        enterText(companyField, company);
        return this;
    }

    @Step("Enter password: {password}")
    public RegisterPage enterPassword(String password) {
        enterText(passwordField, password);
        return this;
    }

    @Step("Enter confirm password: {confirmPassword}")
    public RegisterPage enterConfirmPassword(String confirmPassword) {
        enterText(confirmPasswordField, confirmPassword);
        return this;
    }

    @Step("Select male gender")
    public RegisterPage selectMaleGender() {
        if (!maleGenderRadio.isSelected()) {
            clickElement(maleGenderRadio);
        }
        return this;
    }

    @Step("Select female gender")
    public RegisterPage selectFemaleGender() {
        if (!femaleGenderRadio.isSelected()) {
            clickElement(femaleGenderRadio);
        }
        return this;
    }

    @Step("Click register button")
    public RegisterPage clickRegisterButton() {
        clickElement(registerButton);
        return this;
    }

    @Step("Register with details: {email}")
    public RegisterPage register(String firstName, String lastName, String email, String company, String password, String confirmPassword) {
        navigateToRegisterPage();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterCompany(company);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        return clickRegisterButton();
    }

    @Step("Get registration error message")
    public String getErrorMessage() {
        try {
            return getElementText(errorMessage);
        } catch (Exception e) {
            return "";
        }
    }

    @Step("Check if registration is successful")
    public boolean isRegistrationSuccessful() {
        try {
            return isElementDisplayed(registrationSuccessMessage);
        } catch (Exception e) {
            return false;
        }
    }
}
