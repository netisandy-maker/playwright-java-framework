package pages;

import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page; // protected so that it can be accessed by child classes
    protected String baseUrl;

    // Why protected? Because we want to access these properties in the child
    // classes like LoginPage and DashboardPage. If we make them private, they won't
    // be accessible in the child classes.
    // Created the contructor below
    public BasePage(Page page, String baseUrl) {
        this.page = page;
        this.baseUrl = baseUrl;
    }

    // Method 1 navigate()
    public void navigate(String path) {
        page.navigate(baseUrl + path);
    }

    // Method 2: getPageTitle(). This is a String method and it returns the title of
    // the current page
    public String getPageTitle() {
        return page.title();
    }

    // Method 3: isLoaded()
    public boolean isLoaded() {
        return page.url().contains(baseUrl);
    }
}
