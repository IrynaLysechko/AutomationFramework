package com.epam.tests.web;

import com.epam.allure.AllureAttach;
import com.epam.factory.DriverManager;
import com.epam.testng.listeners.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;

import static com.epam.config.ConfigurationManager.getConfiguration;

@Listeners(TestListener.class)
public abstract class BaseTest {

    @BeforeMethod
    public void getDriver() {
        DriverManager.getDriver().get(getConfiguration().url());
    }


    @AfterMethod
    public void turnDown() throws IOException {
        DriverManager.quitDriver();
        AllureAttach.addFileToAllure("logs/all.log");
    }

}
