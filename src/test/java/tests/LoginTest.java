package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(groups = { "smoke", "ui" })
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(page, baseUrl);
        loginPage.login(username, password);

        Assert.assertTrue(loginPage.isSuccessVisible());
    }

    @Test(groups = { "negitive", "ui" })
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(page, baseUrl);
        loginPage.login("wronguser", "wrongpassword");
        Assert.assertTrue(loginPage.isErrorVisible());
    }

    @Test(groups = { "regression", "ui" })
    public void loginAndVerifyDashboard() {
        LoginPage loginPage = new LoginPage(page, baseUrl);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(page, baseUrl);
        Assert.assertTrue(dashboardPage.getHeadingText().contains("Secure Area"));
        dashboardPage.clickLogout();
    }

    @Test(groups = { "regression", "ui" })
    public void logoutFromDashboard() {
        LoginPage loginPage = new LoginPage(page, baseUrl);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(page, baseUrl);
        dashboardPage.clickLogout();
        String currentUrl = page.url();
        Assert.assertTrue(currentUrl.contains("/login"), "After logout, user should be redirected to login page");
    }

}
