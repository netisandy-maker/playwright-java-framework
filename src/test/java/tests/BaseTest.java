package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.ConfigReader;

public class BaseTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    String baseUrl = ConfigReader.get("baseUrl");
    String username = ConfigReader.get("username");
    String password = ConfigReader.get("password");

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
