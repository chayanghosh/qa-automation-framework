package core.listeners;

import core.utils.ScreenshotUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("START: {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("PASS: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("FAIL: {}", result.getName());

        String path = ScreenshotUtils.takeScreenshot(result.getName());
        log.error("Screenshot saved at: {}", path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("SKIPPED: {}", result.getName());
    }
}