package com.epam.tests;

import com.epam.factory.DriverManager;
import com.epam.testng.listeners.TestListener;
import org.testng.annotations.*;

import static com.epam.config.ConfigurationManager.getConfiguration;

@Listeners(TestListener.class)
public abstract class BaseTest {

    @BeforeClass
    public void getDriver() {
        DriverManager.getDriver().get(getConfiguration().url());
    }

    @AfterClass
    public void turnDown() {
        DriverManager.quitDriver();
    }
}
