package core.utils;

import core.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static String takeScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String filePath = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());
            Files.copy(src.toPath(), path);

            return filePath;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}