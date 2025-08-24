package com.chiragrathava.pages.pageFactory;

import com.chiragrathava.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "search_query_top")
    private WebElement searchBox;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//span[@class='ajax_cart_quantity']")
    private WebElement cartQuantity;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement cartIcon;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter search term: {searchTerm}")
    public HomePage enterSearchTerm(String searchTerm) {
        enterText(searchBox, searchTerm);
        return this;
    }

    @Step("Click search button")
    public SearchResultsPage clickSearchButton() {
        clickElement(searchButton);
        return new SearchResultsPage(driver);
    }

    @Step("Search for product: {searchTerm}")
    public SearchResultsPage searchProduct(String searchTerm) {
        enterSearchTerm(searchTerm);
        return clickSearchButton();
    }

    @Step("Get cart quantity")
    public String getCartQuantity() {
        try {
            return getElementText(cartQuantity);
        } catch (Exception e) {
            return "0";
        }
    }

    @Step("Click on cart icon")
    public CartPage clickCartIcon() {
        clickElement(cartIcon);
        return new CartPage(driver);
    }

    @Step("Navigate to My Account")
    public MyAccountPage navigateToMyAccount() {
        clickElement(myAccountLink);
        return new MyAccountPage(driver);
    }

    @Step("Check if user is logged in")
    public boolean isUserLoggedIn() {
        try {
            return isElementDisplayed(myAccountLink) &&
                    getElementText(myAccountLink).contains("account");
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Verify home page is loaded")
    public boolean isHomePageLoaded() {
        try {
            return isElementDisplayed(searchBox) &&
                    driver.getCurrentUrl().contains("index.php");
        } catch (Exception e) {
            return false;
        }
    }
}
