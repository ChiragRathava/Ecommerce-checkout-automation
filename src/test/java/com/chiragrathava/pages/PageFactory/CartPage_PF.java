package com.chiragrathava.pages.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage_PF {
    protected WebDriver driver;

    @FindBy(css = ".ico-cart")
    public WebElement cartLink;

    @FindBy(id = "termsofservice")
    public WebElement termsCheckbox;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public CartPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
