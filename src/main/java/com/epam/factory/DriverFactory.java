package com.epam.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static Logger logger = LogManager.getLogger(DriverFactory.class);

    public static WebDriver createDriver(String browser) {
        logger.info("Browser is " + browser.toUpperCase());
        DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
        WebDriverManager.getInstance(driverManagerType).setup();
        WebDriver webDriver;

        switch (driverManagerType) {
            case CHROME:
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            case EDGE:
                webDriver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException(driverManagerType.toString());
        }
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        return webDriver;
    }

}
