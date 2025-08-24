package com.chiragrathava.pages.pageFactory;

import com.chiragrathava.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//ul[@class='product_list grid row']//li")
    private List<WebElement> productList;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement noResultsMessage;

    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']")
    private WebElement cartSuccessModal;

    @FindBy(xpath = "//h4[text()='Product successfully added to your shopping cart']")
    private WebElement successMessage;

    @FindBy(xpath = "//span[@class='cross']")
    private WebElement closeModal;

    @FindBy(xpath = "//div[@class='product-container']")
    private List<WebElement> productContainers;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get search results count")
    public int getSearchResultsCount() {
        try {
            return productList.size();
        } catch (Exception e) {
            return 0;
        }
    }

    @Step("Add first product to cart")
    public SearchResultsPage addFirstProductToCart() {
        if (!productList.isEmpty()) {
            WebElement firstProduct = productList.get(0);
            scrollToElement(firstProduct);

            org.openqa.selenium.interactions.Actions actions =
                    new org.openqa.selenium.interactions.Actions(driver);
            actions.moveToElement(firstProduct).perform();

            WebElement addToCartBtn = firstProduct.findElement(
                    By.xpath(".//span[text()='Add to cart']"));
            clickElement(addToCartBtn);

            waitForElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']"));
        }
        return this;
    }

    @Step("Add product to cart by index: {index}")
    public SearchResultsPage addProductToCartByIndex(int index) {
        if (productList.size() > index) {
            WebElement product = productList.get(index);
            scrollToElement(product);

            org.openqa.selenium.interactions.Actions actions =
                    new org.openqa.selenium.interactions.Actions(driver);
            actions.moveToElement(product).perform();

            WebElement addToCartBtn = product.findElement(
                    By.xpath(".//span[text()='Add to cart']"));
            clickElement(addToCartBtn);

            waitForElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']"));
        }
        return this;
    }

    @Step("Continue shopping")
    public SearchResultsPage continueShopping() {
        try {
            if (isElementDisplayed(continueShoppingButton)) {
                clickElement(continueShoppingButton);
            }
        } catch (Exception e) {
            // Modal might not be visible
        }
        return this;
    }

    @Step("Proceed to checkout")
    public CartPage proceedToCheckout() {
        try {
            if (isElementDisplayed(proceedToCheckoutButton)) {
                clickElement(proceedToCheckoutButton);
            }
        } catch (Exception e) {
            // Fallback to cart page navigation
        }
        return new CartPage(driver);
    }

    @Step("Check if products found")
    public boolean areProductsFound() {
        return getSearchResultsCount() > 0;
    }

    @Step("Get no results message")
    public String getNoResultsMessage() {
        try {
            return getElementText(noResultsMessage);
        } catch (Exception e) {
            return "";
        }
    }

    @Step("Check if success modal is displayed")
    public boolean isSuccessModalDisplayed() {
        try {
            return isElementDisplayed(cartSuccessModal);
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Close success modal")
    public SearchResultsPage closeSuccessModal() {
        try {
            if (isElementDisplayed(closeModal)) {
                clickElement(closeModal);
            }
        } catch (Exception e) {
            // Modal might auto-close
        }
        return this;
    }

    @Step("Get product name by index: {index}")
    public String getProductNameByIndex(int index) {
        try {
            if (productContainers.size() > index) {
                WebElement productName = productContainers.get(index)
                        .findElement(By.xpath(".//a[@class='product-name']"));
                return getElementText(productName);
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }
}
