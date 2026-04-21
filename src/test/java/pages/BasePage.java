package pages;

import com.microsoft.playwright.Page;

public class BasePage {
    Page page;
    String baseUrl;

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
