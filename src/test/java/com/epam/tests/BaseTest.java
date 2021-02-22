package com.epam.tests;

import com.epam.allure.AllureAttach;
import com.epam.factory.DriverManager;
import com.epam.testng.listeners.TestListener;
import io.qameta.allure.Allure;
import org.testng.annotations.*;

import java.io.IOException;

import static com.epam.config.ConfigurationManager.getConfiguration;

@Listeners(TestListener.class)
public abstract class BaseTest {

    @BeforeClass
    public void getDriver() {
        DriverManager.getDriver().get(getConfiguration().url());
    }

    @AfterClass
    public void turnDown() throws IOException {
        DriverManager.quitDriver();
        AllureAttach.addFileToAllure("logs/all.log");
    }
}
