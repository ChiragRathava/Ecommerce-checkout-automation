package com.chiragrathava.pages.PageFactory;

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

    public RegisterPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
