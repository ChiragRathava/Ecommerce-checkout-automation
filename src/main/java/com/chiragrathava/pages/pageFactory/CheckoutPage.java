package com.chiragrathava.pages.pageFactory;

import com.chiragrathava.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(name = "processAddress")
    private WebElement proceedToShippingButton;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement address1Field;

    @FindBy(id = "address2")
    private WebElement address2Field;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "id_state")
    private WebElement stateDropdown;

    @FindBy(id = "postcode")
    private WebElement postcodeField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;

    @FindBy(id = "other")
    private WebElement additionalInfoField;

    @FindBy(name = "processCarrier")
    private WebElement proceedToPaymentButton;

    @FindBy(id = "cgv")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//div[@class='delivery_options_address']//input[@type='radio']")
    private WebElement shippingOption;

    @FindBy(xpath = "//a[@class='bankwire']")
    private WebElement bankWirePayment;

    @FindBy(xpath = "//a[@class='cheque']")
    private WebElement chequePayment;

    @FindBy(xpath = "//span[text()='I confirm my order']")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//button[@name='processCarrier']")
    private WebElement processCarrierButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement errorMessage;

    @FindBy(xpath = "//p[@class='required']")
    private WebElement requiredFieldsNote;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill shipping details with test data")
    public CheckoutPage fillShippingDetails(TestData testData) {
        waitForPageLoad();

        if (!testData.getCompany().isEmpty()) {
            enterText(companyField, testData.getCompany());
        }

        if (!testData.getAddress().isEmpty()) {
            enterText(address1Field, testData.getAddress());
        }

        if (!testData.getCity().isEmpty()) {
            enterText(cityField, testData.getCity());
        }

        if (!testData.getState().isEmpty()) {
            try {
                selectDropdownByText(stateDropdown, testData.getState());
            } catch (Exception e) {
                System.out.println("Could not select state: " + testData.getState());
            }
        }

        if (!testData.getPostcode().isEmpty()) {
            enterText(postcodeField, testData.getPostcode());
        }

        if (!testData.getPhone().isEmpty()) {
            enterText(phoneField, testData.getPhone());
        }

        if (!testData.getMobilePhone().isEmpty()) {
            enterText(mobilePhoneField, testData.getMobilePhone());
        } else if (!testData.getPhone().isEmpty()) {
            enterText(mobilePhoneField, testData.getPhone());
        }

        if (!testData.getAdditionalInfo().isEmpty()) {
            enterText(additionalInfoField, testData.getAdditionalInfo());
        }

        return this;
    }

    @Step("Proceed to shipping step")
    public CheckoutPage proceedToShipping() {
        try {
            scrollToElement(proceedToShippingButton);
            clickElement(proceedToShippingButton);
            waitForPageLoad();
        } catch (Exception e) {
            System.out.println("Error proceeding to shipping: " + e.getMessage());
        }
        return this;
    }

    @Step("Accept terms and proceed to payment")
    public CheckoutPage acceptTermsAndProceedToPayment() {
        try {
            if (isElementDisplayed(termsCheckbox) && !termsCheckbox.isSelected()) {
                clickElement(termsCheckbox);
            }

            if (isElementDisplayed(proceedToPaymentButton)) {
                scrollToElement(proceedToPaymentButton);
                clickElement(proceedToPaymentButton);
            } else if (isElementDisplayed(processCarrierButton)) {
                scrollToElement(processCarrierButton);
                clickElement(processCarrierButton);
            }

            waitForPageLoad();
        } catch (Exception e) {
            System.out.println("Error accepting terms and proceeding: " + e.getMessage());
        }
        return this;
    }

    @Step("Select payment method: {paymentMethod}")
    public CheckoutPage selectPaymentMethod(String paymentMethod) {
        try {
            waitForPageLoad();

            switch (paymentMethod.toLowerCase()) {
                case "bankwire":
                case "bank wire":
                    if (isElementDisplayed(bankWirePayment)) {
                        scrollToElement(bankWirePayment);
                        clickElement(bankWirePayment);
                    }
                    break;

                case "cheque":
                case "check":
                    if (isElementDisplayed(chequePayment)) {
                        scrollToElement(chequePayment);
                        clickElement(chequePayment);
                    }
                    break;

                default:
                    if (isElementDisplayed(bankWirePayment)) {
                        scrollToElement(bankWirePayment);
                        clickElement(bankWirePayment);
                    }
                    break;
            }

            waitForPageLoad();
        } catch (Exception e) {
            System.out.println("Error selecting payment method: " + e.getMessage());
        }
        return this;
    }

    @Step("Confirm order")
    public OrderConfirmationPage confirmOrder() {
        try {
            waitForElementToBeClickable(By.xpath("//span[text()='I confirm my order']"));
            scrollToElement(confirmOrderButton);
            clickElement(confirmOrderButton);
            waitForPageLoad();
        } catch (Exception e) {
            System.out.println("Error confirming order: " + e.getMessage());
        }
        return new OrderConfirmationPage(driver);
    }

    @Step("Get checkout error message")
    public String getErrorMessage() {
        try {
            if (isElementDisplayed(errorMessage)) {
                return getElementText(errorMessage);
            }
        } catch (Exception e) {
            System.out.println("No error message found");
        }
        return "";
    }

    @Step("Check if on address step")
    public boolean isOnAddressStep() {
        try {
            return isElementDisplayed(address1Field) &&
                    driver.getCurrentUrl().contains("controller=order");
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Check if on shipping step")
    public boolean isOnShippingStep() {
        try {
            return isElementDisplayed(termsCheckbox) &&
                    driver.getCurrentUrl().contains("controller=order");
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Check if on payment step")
    public boolean isOnPaymentStep() {
        try {
            return (isElementDisplayed(bankWirePayment) || isElementDisplayed(chequePayment)) &&
                    driver.getCurrentUrl().contains("controller=order");
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Validate required fields")
    public boolean validateRequiredFields() {
        try {
            return !getErrorMessage().contains("required") &&
                    !getErrorMessage().contains("invalid");
        } catch (Exception e) {
            return true;
        }
    }

    @Step("Complete checkout process")
    public OrderConfirmationPage completeCheckout(TestData testData, String paymentMethod) {
        return fillShippingDetails(testData)
                .proceedToShipping()
                .acceptTermsAndProceedToPayment()
                .selectPaymentMethod(paymentMethod)
                .confirmOrder();
    }
}
