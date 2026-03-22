package tests.ui.base;

import pages.LoginPage;
import org.testng.annotations.Test;

import org.testng.Assert;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.login("user", "password");
        
        //force failure to test retry
        Assert.assertTrue(false);

    }
}