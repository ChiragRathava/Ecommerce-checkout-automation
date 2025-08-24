package com.chiragrathava.pages.pageFactory;

import com.chiragrathava.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//a[@title='Orders']")
    private WebElement orderHistoryLink;

    @FindBy(xpath = "//a[@title='Information']")
    private WebElement personalInfoLink;

    @FindBy(xpath = "//a[@title='Addresses']")
    private WebElement addressesLink;

    @FindBy(xpath = "//h1[text()='My account']")
    private WebElement myAccountHeader;

    @FindBy(xpath = "//span[text()='Order history and details']")
    private WebElement orderHistoryText;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to order history")
    public OrderHistoryPage navigateToOrderHistory() {
        try {
            if (isElementDisplayed(orderHistoryLink)) {
                clickElement(orderHistoryLink);
            } else {
                WebElement orderHistoryAlt = driver.findElement(
                        By.xpath("//a[contains(@href,'history')]"));
                clickElement(orderHistoryAlt);
            }
        } catch (Exception e) {
            System.out.println("Error navigating to order history: " + e.getMessage());
        }
        return new OrderHistoryPage(driver);
    }

    @Step("Check if on My Account page")
    public boolean isOnMyAccountPage() {
        try {
            return isElementDisplayed(myAccountHeader) ||
                    driver.getCurrentUrl().contains("controller=my-account");
        } catch (Exception e) {
            return false;
        }
    }
}
