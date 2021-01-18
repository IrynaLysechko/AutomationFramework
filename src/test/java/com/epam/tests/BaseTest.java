package com.epam.tests;

import com.epam.factory.DriverManager;
import org.testng.annotations.*;

import static com.epam.config.ConfigurationManager.getConfiguration;

public abstract class BaseTest {

    @BeforeClass
    public void getDriver() {
        DriverManager.getDriver().get(getConfiguration().url());
    }

//    @AfterClass
//    public void turnDown() {
//        DriverManager.quitDriver();
//    }
}
