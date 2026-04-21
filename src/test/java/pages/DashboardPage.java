package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DashboardPage extends BasePage {
    // Properties Locators goes here.
    Locator heading;
    Locator successMessage;
    Locator logout;

    // Constructor call super() /sets up locators.
    public DashboardPage(Page page, String baseUrl) {
        super(page, baseUrl);

        heading = page.locator("h4.subheader");
        successMessage = page.locator("#flash.success");
        logout = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Logout"));

    }

    // Methods what the page can do.
    // boolean method - is heading visible?
    public boolean isHeadingVisible() {
        return heading.isVisible();
    }

    // isSuccessVisible?
    public boolean isSuccessMessageVisible() {
        return successMessage.isVisible();
    }

    // String Method - get heading text
    public String getHeadingText() {
        return heading.textContent();
    }

    // void method - click logout
    public void clickLogout() {
        logout.click();
    }

    // boolean method - is user logged in
    public boolean isUserLoggedIn() {
        return isHeadingVisible() && isSuccessMessageVisible();
    }
}
