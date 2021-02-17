package com.epam.factory;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import static com.epam.config.ConfigurationManager.getConfiguration;

@Log4j2
public class DriverManager {

    private static final ThreadLocal<WebDriver> WEBDRIVER_POOL = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (WEBDRIVER_POOL.get() == null) {
            log.debug("set driver to poll");
            WEBDRIVER_POOL.set(DriverFactory.createDriver(getConfiguration().browser()));
        }
        return WEBDRIVER_POOL.get();
    }

    public static void quitDriver() {
        if (WEBDRIVER_POOL.get() != null) {
            log.debug("remove driver from poll");
            WEBDRIVER_POOL.get().quit();
            WEBDRIVER_POOL.set(null);
        }
    }

}
