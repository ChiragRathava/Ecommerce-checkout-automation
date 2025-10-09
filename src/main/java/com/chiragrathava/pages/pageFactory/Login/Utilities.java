package com.chiragrathava.pages.pageFactory.Login;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

/**
 * LoginPageUtilities - Contains utility methods for the Login Page
 */
public class Utilities {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public Utilities(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clearSessionCookies() {
        try {
            driver.manage().deleteAllCookies();
            System.out.println("Cleared all session cookies");
        } catch (Exception e) {
            System.err.println("Error clearing cookies: " + e.getMessage());
        }
    }

    public void tabThroughFields() {
        try {
            driver.findElement(By.id("Email")).sendKeys(Keys.TAB);
            Thread.sleep(200);
            driver.switchTo().activeElement().sendKeys(Keys.TAB);
            Thread.sleep(200);
            driver.switchTo().activeElement().sendKeys(Keys.TAB);
        } catch (Exception e) {
            System.err.println("Error tabbing through fields: " + e.getMessage());
        }
    }

    // Learn about this
    public void removeCsrfToken() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].remove();", driver.findElement(By.name("_csrf")));
            System.out.println("Removed CSRF token for testing");
        } catch (Exception e) {
            System.err.println("Error removing CSRF token: " + e.getMessage());
        }
    }

    public void waitForPageLoad() {
        try {
            wait.until(webDriver ->
                    ((JavascriptExecutor) webDriver)
                            .executeScript("return document.readyState")
                            .equals("complete")
            );
            System.out.println("Page loaded successfully");
        } catch (Exception e) {
            System.err.println("Error waiting for page load: " + e.getMessage());
        }
    }

    public void highlightElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='3px solid red'", element);
            Thread.sleep(500);
            js.executeScript("arguments[0].style.border=''", element);
        } catch (Exception e) {
            System.err.println("Error highlighting element: " + e.getMessage());
        }
    }

    public void takeScreenshot(String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            System.out.println("Screenshot captured: " + fileName);
        } catch (Exception e) {
            System.err.println("Error taking screenshot: " + e.getMessage());
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        } catch (Exception e) {
            System.err.println("Error scrolling to element: " + e.getMessage());
        }
    }

    public Set<Cookie> getAllCookies() {
        try {
            return driver.manage().getCookies();
        } catch (Exception e) {
            System.err.println("Error getting cookies: " + e.getMessage());
            return null;
        }
    }

    public boolean isCookiePresent(String cookieName) {
        try {
            Cookie cookie = driver.manage().getCookieNamed(cookieName);
            return cookie != null;
        } catch (Exception e) {
            return false;
        }
    }

    public String getPageTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            return "";
        }
    }

    public String getCurrentUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            return "";
        }
    }

    public void refreshPage() {
        try {
            driver.navigate().refresh();
            System.out.println("Page refreshed");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println("Error refreshing page: " + e.getMessage());
        }
    }

    public void navigateBack() {
        try {
            driver.navigate().back();
            System.out.println("Navigated back");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println("Error navigating back: " + e.getMessage());
        }
    }

    public void navigateForward() {
        try {
            driver.navigate().forward();
            System.out.println("Navigated forward");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println("Error navigating forward: " + e.getMessage());
        }
    }

    public boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCheckboxSelected(WebElement element) {
        try {
            return element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    public String getElementCssValue(WebElement element, String property) {
        try {
            return element.getCssValue(property);
        } catch (Exception e) {
            return "";
        }
    }

    public Object executeJavaScript(String script) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript(script);
        } catch (Exception e) {
            System.err.println("Error executing JavaScript: " + e.getMessage());
            return null;
        }
    }

    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("Alert accepted");
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present");
        }
    }

    public void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            System.out.println("Alert dismissed");
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present");
        }
    }

    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (NoAlertPresentException e) {
            return "";
        }
    }

    public void switchToIframe(WebElement iframeElement) {
        try {
            driver.switchTo().frame(iframeElement);
            System.out.println("Switched to iframe");
        } catch (Exception e) {
            System.err.println("Error switching to iframe: " + e.getMessage());
        }
    }

    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
            System.out.println("Switched to default content");
        } catch (Exception e) {
            System.err.println("Error switching to default content: " + e.getMessage());
        }
    }

    public Point getElementLocation(WebElement element) {
        try {
            return element.getLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public Dimension getElementSize(WebElement element) {
        try {
            return element.getSize();
        } catch (Exception e) {
            return null;
        }
    }

    public void clearTextField(WebElement element) {
        try {
            element.clear();
            System.out.println("Text field cleared");
        } catch (Exception e) {
            System.err.println("Error clearing text field: " + e.getMessage());
        }
    }

    public void doubleClick(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.doubleClick(element).perform();
            System.out.println("Double clicked on element");
        } catch (Exception e) {
            System.err.println("Error double clicking: " + e.getMessage());
        }
    }

    public void rightClick(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.contextClick(element).perform();
            System.out.println("Right clicked on element");
        } catch (Exception e) {
            System.err.println("Error right clicking: " + e.getMessage());
        }
    }

    public void hoverOverElement(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            System.out.println("Hovered over element");
        } catch (Exception e) {
            System.err.println("Error hovering: " + e.getMessage());
        }
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        try {
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source, target).perform();
            System.out.println("Drag and drop performed");
        } catch (Exception e) {
            System.err.println("Error during drag and drop: " + e.getMessage());
        }
    }

    public boolean waitForElementVisible(WebElement element, int timeoutSeconds) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            customWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForElementClickable(WebElement element, int timeoutSeconds) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            customWait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementExist(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
