package com.chiragrathava.pages.pageFactory;

import com.chiragrathava.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage {

    @FindBy(xpath = "//p[contains(text(),'Your order on')]")
    private WebElement orderConfirmationMessage;

    @FindBy(xpath = "//div[@class='box order-confirmation']")
    private WebElement orderConfirmationBox;

    @FindBy(xpath = "//strong[contains(text(),'reference')]")
    private WebElement orderReferenceElement;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//span[@class='price']")
    private WebElement orderTotal;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check if order is confirmed")
    public boolean isOrderConfirmed() {
        try {
            return isElementDisplayed(orderConfirmationMessage) ||
                    isElementDisplayed(orderConfirmationBox) ||
                    driver.getCurrentUrl().contains("controller=order-confirmation");
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Get order reference")
    public String getOrderReference() {
        try {
            if (isElementDisplayed(orderReferenceElement)) {
                String fullText = getElementText(orderReferenceElement);
                return fullText.replaceAll(".*reference\\s*", "").trim();
            }

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("id_order=")) {
                return currentUrl.substring(currentUrl.indexOf("id_order=") + 9);
            }
        } catch (Exception e) {
            System.out.println("Could not extract order reference: " + e.getMessage());
        }
        return "";
    }

    @Step("Get order total")
    public String getOrderTotal() {
        try {
            return getElementText(orderTotal);
        } catch (Exception e) {
            return "$0.00";
        }
    }

    @Step("Navigate to My Account")
    public MyAccountPage navigateToMyAccount() {
        clickElement(myAccountLink);
        return new MyAccountPage(driver);
    }
}
