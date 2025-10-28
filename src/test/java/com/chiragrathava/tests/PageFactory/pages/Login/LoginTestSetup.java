package com.chiragrathava.tests.PageFactory.pages.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.qameta.allure.Description;

public class LoginTestSetup {
    private static final int IMPLICIT_WAIT = 10;
    private WebDriver driver;
    private WebDriverWait wait;

    @Description("Initialize WebDriver with Chrome options")
    public WebDriver initializeWebDriver() {
        System.out.println("========================================");
        System.out.println("Initializing Test Suite: Login Tests");
        System.out.println("All 50 Test Cases Automated");
        System.out.println("========================================");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        return driver;
    }

    @Description("Navigate to login page")
    public void navigateToLoginPage(WebDriver driver, String baseUrl) {
        driver.get(baseUrl);
        System.out.println("\n--- Test Execution Started ---");
    }
}
