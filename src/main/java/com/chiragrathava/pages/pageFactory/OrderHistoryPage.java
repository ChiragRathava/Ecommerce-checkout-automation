package com.chiragrathava.pages.pageFactory;

import com.chiragrathava.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends BasePage {

    @FindBy(xpath = "//table[@id='order-list']//tbody//tr")
    private List<WebElement> orderRows;

    @FindBy(xpath = "//h1[text()='Order history']")
    private WebElement orderHistoryHeader;

    @FindBy(xpath = "//p[contains(text(),'You have not placed any orders')]")
    private WebElement noOrdersMessage;

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check if order is present in history: {orderReference}")
    public boolean isOrderPresentInHistory(String orderReference) {
        try {
            if (orderReference == null || orderReference.isEmpty()) {
                return false;
            }

            for (WebElement row : orderRows) {
                String rowText = getElementText(row);
                if (rowText.contains(orderReference)) {
                    return true;
                }
            }

            String xpath = "//table[@id='order-list']//tr[contains(.,'" + orderReference + "')]";
            List<WebElement> matchingRows = driver.findElements(By.xpath(xpath));
            return !matchingRows.isEmpty();

        } catch (Exception e) {
            System.out.println("Error checking order history: " + e.getMessage());
            return false;
        }
    }

    @Step("Get order details for reference: {orderReference}")
    public OrderDetails getOrderDetails(String orderReference) {
        OrderDetails details = new OrderDetails();
        details.setOrderReference(orderReference);

        try {
            for (WebElement row : orderRows) {
                String rowText = getElementText(row);
                if (rowText.contains(orderReference)) {
                    List<WebElement> cells = row.findElements(By.tagName("td"));

                    if (cells.size() >= 4) {
                        details.setOrderReference(getElementText(cells.get(0)));
                        details.setDate(getElementText(cells.get(1)));
                        details.setTotalPrice(getElementText(cells.get(2)));
                        details.setStatus(getElementText(cells.get(3)));
                    }
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error extracting order details: " + e.getMessage());
        }

        return details;
    }

    @Step("Get total number of orders")
    public int getTotalOrdersCount() {
        try {
            return orderRows.size();
        } catch (Exception e) {
            return 0;
        }
    }

    @Step("Check if order history is empty")
    public boolean isOrderHistoryEmpty() {
        try {
            return isElementDisplayed(noOrdersMessage) || orderRows.isEmpty();
        } catch (Exception e) {
            return true;
        }
    }
}
