package com.chiragrathava.pages.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage_PF {
    protected WebDriver driver;

    @FindBy(css = "select#customerCurrency")
    public WebElement currencyDropdown;

    @FindBy(linkText = "Register")
    public WebElement registerLink;

    @FindBy(linkText = "Log in")
    public WebElement loginLink;

    @FindBy(id = "small-searchterms")
    public WebElement searchInput;

    @FindBy(css = "button.button-1.search-box-button")
    public WebElement searchButton;

    @FindBy(linkText = "Computers")
    public WebElement computersLink;

    @FindBy(linkText = "Electronics")
    public WebElement electronicsLink;

    @FindBy(linkText = "Apparel")
    public WebElement apparelLink;

    public Homepage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
