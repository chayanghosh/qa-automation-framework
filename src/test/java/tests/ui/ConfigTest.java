package tests.ui;

import org.testng.annotations.Test;
import core.config.ConfigManager;

public class ConfigTest {

    @Test
    public void validateConfigLoad() {
        System.out.println("Browser: " + ConfigManager.get("browser"));
        System.out.println("Base URL: " + ConfigManager.get("baseUrl"));
        System.out.println("Headless: " + ConfigManager.getBoolean("headless"));
    }
}