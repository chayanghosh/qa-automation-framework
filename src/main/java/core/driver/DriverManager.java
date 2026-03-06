package core.driver;

import core.config.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
    }

    private static WebDriver createDriver() {
        String browser = ConfigManager.get("browser");
        boolean headless = ConfigManager.getBoolean("headless");
        boolean remote = ConfigManager.getBoolean("remote");

        try {
            if (remote) {
                return createRemoteDriver(browser, headless);
            } else {
                return createLocalDriver(browser, headless);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create driver", e);
        }
    }

    private static WebDriver createLocalDriver(String browser, boolean headless) {
        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless=new");
            }

            WebDriver driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(
                    Duration.ofSeconds(ConfigManager.getInt("implicitWait"))
            );

            return driver;
        }

        throw new RuntimeException("Browser not supported: " + browser);
    }

    private static WebDriver createRemoteDriver(String browser, boolean headless) throws Exception {

        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
        }

        return new RemoteWebDriver(
                new URL(ConfigManager.get("gridUrl")),
                options
        );
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}