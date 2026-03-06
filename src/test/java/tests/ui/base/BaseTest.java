package tests.ui.base;

import core.driver.DriverManager;
import core.config.ConfigManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverManager.initDriver();
        DriverManager.getDriver().get(ConfigManager.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}