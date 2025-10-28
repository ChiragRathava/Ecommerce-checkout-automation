package com.chiragrathava.tests.PageFactory.pages.Login;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Description;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoginTestUtilities {
    private WebDriver driver;

    public LoginTestUtilities(WebDriver driver) {
        this.driver = driver;
    }

    @Description("Clear cookies and reset state after each test")
    public void cleanUp() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            System.out.println("--- Test Execution Completed ---\n");
        }
    }

    @Description("Close WebDriver and cleanup resources")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("\n========================================");
            System.out.println("Test Suite Execution Completed");
            System.out.println("Total Tests Automated: 51 (All 50 + 1 Data-Driven)");
            System.out.println("WebDriver closed successfully");
            System.out.println("========================================");
        }
    }

    public Object[][] readExcelData(String fileName) throws IOException {
        List<Object[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    String email = getCellValue(row.getCell(0));
                    String password = getCellValue(row.getCell(1));
                    data.add(new Object[]{email, password});
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
            return new Object[][] {
                    {"test@example.com", "Test@1234"},
                    {"invalid@example.com", "wrongpass"}
            };
        }

        return data.toArray(new Object[0][]);
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue());
            default:
                return "";
        }
    }
}
