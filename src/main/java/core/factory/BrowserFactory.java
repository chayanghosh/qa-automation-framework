package core.factory;

import core.config.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserFactory {

    public static WebDriver createDriver() {

        String browser = ConfigManager.get("browser").toLowerCase();
        boolean headless = ConfigManager.getBoolean("headless");
        boolean remote = ConfigManager.getBoolean("remote");

        try {

            if (remote) {
                return createRemoteDriver(browser, headless);
            } else {
                return createLocalDriver(browser, headless);
            }

        } catch (Exception e) {
            throw new RuntimeException("Driver creation failed", e);
        }
    }

    private static WebDriver createLocalDriver(String browser, boolean headless) {

        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }

                return new ChromeDriver(chromeOptions);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }

                return new FirefoxDriver(firefoxOptions);

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

    private static WebDriver createRemoteDriver(String browser, boolean headless) throws Exception {

        String gridUrl = ConfigManager.get("gridUrl");

        switch (browser) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }

                return new RemoteWebDriver(new URL(gridUrl), chromeOptions);

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }

                return new RemoteWebDriver(new URL(gridUrl), firefoxOptions);

            default:
                throw new RuntimeException("Unsupported remote browser: " + browser);
        }
    }
}