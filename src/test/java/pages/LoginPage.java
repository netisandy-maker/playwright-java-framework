package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage extends BasePage {
    Locator usernameField;
    Locator passwordField;
    Locator loginButton;
    Locator errorMessage;
    Locator successMessage;

    public LoginPage(Page page, String baseUrl) {
        super(page, baseUrl);

        usernameField = page.getByLabel("Username");
        passwordField = page.getByLabel("Password");
        loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
        errorMessage = page.locator("#flash.error");
        successMessage = page.locator("#flash.success");

    }

    // void method - type username
    public void fillUsername(String username) {
        usernameField.fill(username);
    }

    // void method - type password
    public void fillPassword(String password) {
        passwordField.fill(password);
    }

    // Click login button
    public void clickLogin() {
        loginButton.click();
    }

    // boolean method - is error is showing?
    public boolean isErrorVisible() {
        return errorMessage.isVisible();
    }

    // boolean method - is success message showing?
    public boolean isSuccessVisible() {
        return successMessage.isVisible();
    }

    // String method - get invalid error text
    public String getErrorMessage() {
        return errorMessage.textContent();
    }

    // Convience method - does full login in one call
    public void login(String username, String password) {
        navigate("/login"); // inherited from BasePage
        fillUsername(username);
        fillPassword(password);
        clickLogin();
    }
}
