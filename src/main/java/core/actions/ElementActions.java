package core.actions;

import core.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementActions {

    public void click(By locator) {
        WebElement element = WaitUtils.waitForClickable(locator);
        element.click();
    }

    public void type(By locator, String text) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return WaitUtils.waitForVisibility(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return WaitUtils.waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}