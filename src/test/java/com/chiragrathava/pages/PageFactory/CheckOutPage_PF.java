package com.chiragrathava.pages.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage_PF {
    protected WebDriver driver;

    @FindBy(id = "BillingNewAddress_FirstName")
    public WebElement firstName;

    @FindBy(id = "BillingNewAddress_LastName")
    public WebElement lastName;

    @FindBy(id = "BillingNewAddress_Email")
    public WebElement email;

    @FindBy(id = "BillingNewAddress_CountryId")
    public WebElement countrySelect;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    public WebElement stateSelect;

    @FindBy(id = "BillingNewAddress_City")
    public WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement address1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement zip;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement phone;

    @FindBy(css = "#billing-buttons-container .new-address-next-step-button")
    public WebElement billingContinue;

    @FindBy(css = "input[value='Ground']")
    public WebElement shippingGround;

    @FindBy(css = "#shipping-method-buttons-container .shipping-method-next-step-button")
    public WebElement shippingContinue;

    @FindBy(css = "input[value='Payments.CheckMoneyOrder']")
    public WebElement paymentCheck;

    @FindBy(css = "#payment-method-buttons-container .payment-method-next-step-button")
    public WebElement paymentContinue;

    @FindBy(css = "#payment-info-buttons-container .payment-info-next-step-button")
    public WebElement paymentInfoContinue;

    @FindBy(css = "#confirm-order-buttons-container .confirm-order-next-step-button")
    public WebElement confirmButton;

    @FindBy(css = ".order-number strong")
    public WebElement orderNumber;

    @FindBy(css = ".order-completed .title")
    public WebElement confirmationTitle;

    public CheckOutPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
