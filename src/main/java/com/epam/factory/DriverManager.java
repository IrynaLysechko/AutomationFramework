package com.epam.factory;

import org.openqa.selenium.WebDriver;

import static com.epam.config.ConfigurationManager.getConfiguration;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.createDriver(getConfiguration().browser());
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
