package com.epam.page.wait;

import com.epam.factory.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Wait {

    public static void waitUntilElementToBeClickable(WebElement webElement) {
        new WebDriverWait(DriverManager.getDriver(), 30).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitForVisibilityOfElement(WebElement webElement) {
        new WebDriverWait(DriverManager.getDriver(), 30).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForListIsEmpty(List<WebElement> webElement) {
        int timeOut = 20;
        new WebDriverWait(DriverManager.getDriver(), timeOut)
                .until((ExpectedCondition<Boolean>) webDriver ->
                        webElement.size() == 0);
    }
}
