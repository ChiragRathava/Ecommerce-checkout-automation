package com.chiragrathava.pages.pageFactory.Login;

/**
 * LoginPageGetters - Contains getter methods for retrieving values from the Login Page
 */
public class Getters {

    private Locator locator;

    public Getters(Locator locator) {
        this.locator = locator;
    }

    public String getEmailPlaceholder() {
        try {
            return locator.emailField.getAttribute("placeholder");
        } catch (Exception e) {
            return "";
        }
    }

    public String getPasswordPlaceholder() {
        try {
            return locator.passwordField.getAttribute("placeholder");
        } catch (Exception e) {
            return "";
        }
    }

    public String getEmailFieldValue() {
        try {
            return locator.emailField.getAttribute("value");
        } catch (Exception e) {
            return "";
        }
    }

    public String getPasswordFieldValue() {
        try {
            return locator.passwordField.getAttribute("value");
        } catch (Exception e) {
            return "";
        }
    }

    public String getPasswordFieldDisplayValue() {
        try {
            return locator.passwordField.getAttribute("value");
        } catch (Exception e) {
            return "";
        }
    }

    public int getEmailFieldMaxLength() {
        try {
            String maxLength = locator.emailField.getAttribute("maxlength");
            return maxLength != null ? Integer.parseInt(maxLength) : 0;
        } catch (Exception e) {
            return 0;
        }
    }
}