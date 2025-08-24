package com.chiragrathava.pages.pageFactory;

import com.chiragrathava.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutStep2;

    @FindBy(xpath = "//table[@id='cart_summary']//tbody//tr")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement totalPrice;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement emptyCartMessage;

    @FindBy(xpath = "//a[@class='cart_quantity_up btn btn-default button-plus']")
    private List<WebElement> increaseQuantityButtons;

    @FindBy(xpath = "//a[@class='cart_quantity_down btn btn-default button-minus']")
    private List<WebElement> decreaseQuantityButtons;

    @FindBy(xpath = "//input[@class='cart_quantity_input form-control grey']")
    private List<WebElement> quantityInputs;

    @FindBy(xpath = "//i[@class='icon-trash']")
    private List<WebElement> deleteButtons;

    @FindBy(xpath = "//span[@class='price']")
    private List<WebElement> itemPrices;

    @FindBy(xpath = "//td[@class='cart_description']//p[@class='product-name']//a")
    private List<WebElement> productNames;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get cart items count")
    public int getCartItemsCount() {
        try {
            return cartItems.size();
        } catch (Exception e) {
            return 0;
        }
    }

    @Step("Get total price")
    public String getTotalPrice() {
        try {
            return getElementText(totalPrice);
        } catch (Exception e) {
            return "$0.00";
        }
    }

    @Step("Check if cart is empty")
    public boolean isCartEmpty() {
        try {
            return isElementDisplayed(emptyCartMessage) || getCartItemsCount() == 0;
        } catch (Exception e) {
            return true;
        }
    }

    @Step("Proceed to checkout")
    public CheckoutPage proceedToCheckout() {
        try {
            if (isElementDisplayed(proceedToCheckoutButton)) {
                scrollToElement(proceedToCheckoutButton);
                clickElement(proceedToCheckoutButton);
            } else if (isElementDisplayed(proceedToCheckoutStep2)) {
                scrollToElement(proceedToCheckoutStep2);
                clickElement(proceedToCheckoutStep2);
            }
        } catch (Exception e) {
            System.out.println("Error clicking checkout button: " + e.getMessage());
        }
        return new CheckoutPage(driver);
    }

    @Step("Update quantity for item at index: {index} to {quantity}")
    public CartPage updateQuantity(int index, String quantity) {
        try {
            if (quantityInputs.size() > index) {
                WebElement quantityInput = quantityInputs.get(index);
                scrollToElement(quantityInput);
                enterText(quantityInput, quantity);

                quantityInput.submit();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Error updating quantity: " + e.getMessage());
        }
        return this;
    }

    @Step("Remove item from cart at index: {index}")
    public CartPage removeItem(int index) {
        try {
            if (deleteButtons.size() > index) {
                WebElement deleteButton = deleteButtons.get(index);
                scrollToElement(deleteButton);
                clickElement(deleteButton);

                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Error removing item: " + e.getMessage());
        }
        return this;
    }

    @Step("Get product name at index: {index}")
    public String getProductNameAtIndex(int index) {
        try {
            if (productNames.size() > index) {
                return getElementText(productNames.get(index));
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }

    @Step("Get item price at index: {index}")
    public String getItemPriceAtIndex(int index) {
        try {
            if (itemPrices.size() > index) {
                return getElementText(itemPrices.get(index));
            }
        } catch (Exception e) {
            return "$0.00";
        }
        return "$0.00";
    }

    @Step("Get quantity for item at index: {index}")
    public String getQuantityAtIndex(int index) {
        try {
            if (quantityInputs.size() > index) {
                return quantityInputs.get(index).getAttribute("value");
            }
        } catch (Exception e) {
            return "0";
        }
        return "0";
    }

    @Step("Verify cart page is loaded")
    public boolean isCartPageLoaded() {
        try {
            return driver.getCurrentUrl().contains("controller=order") ||
                    driver.getCurrentUrl().contains("cart") ||
                    isElementDisplayed(proceedToCheckoutButton) ||
                    isElementDisplayed(emptyCartMessage);
        } catch (Exception e) {
            return false;
        }
    }
}
