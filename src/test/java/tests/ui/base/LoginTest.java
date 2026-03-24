package tests.ui.base;

import pages.LoginPage;
import org.testng.annotations.Test;

import io.qameta.allure.*;

import org.testng.Assert;

@Epic("Authentication")
@Feature("Login")
public class LoginTest extends BaseTest {

    @Test
    @Story("Valid Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login with valid credentials")
    public void loginTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.login("user", "password");
        Allure.step("Log: User clicked login button");
        //force failure to test retry
        //Assert.assertTrue(false);

    }
}