package core.driver;

import core.factory.BrowserFactory;
import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {

        if (driver.get() == null) {
            driver.set(BrowserFactory.createDriver());
        }

    }

    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }

    }
}