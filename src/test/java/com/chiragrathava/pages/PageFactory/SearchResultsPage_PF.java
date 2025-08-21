package com.chiragrathava.pages.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage_PF {
    protected WebDriver driver;

    @FindBy(css = ".item-box:first-child .button-2.product-box-add-to-cart-button")
    public WebElement firstAddToCartButton;

    public SearchResultsPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
