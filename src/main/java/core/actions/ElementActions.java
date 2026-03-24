package core.actions;

import core.utils.WaitUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementActions {
    
    @Step("Clicking on element: {locator}")
    public void click(By locator) {
    	Allure.step("Clicking on: " + locator);
        WaitUtils.waitForClickable(locator).click();
    }

    @Step("Entering text '{text}' into element: {locator}")
    public void type(By locator, String text) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        element.clear();
        
        Allure.step("Typing '" + text + "' into: " + locator);
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