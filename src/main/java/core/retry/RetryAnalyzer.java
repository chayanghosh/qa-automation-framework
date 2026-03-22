package core.retry;

import core.config.ConfigManager;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int maxRetry;

    public RetryAnalyzer() {
        this.maxRetry = Integer.parseInt(ConfigManager.get("retryCount"));
    }

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetry) {
            retryCount++;

            System.out.println(
                "Retrying test: " + result.getName() +
                " | Attempt: " + retryCount
            );

            return true;
        }

        return false;
    }
}