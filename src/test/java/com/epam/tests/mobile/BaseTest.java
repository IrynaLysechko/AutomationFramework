package com.epam.tests.mobile;

import com.epam.page.mobile.RozetkaMainPageMobile;
import com.epam.tests.mobile.factory.CapabilitiesFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static AndroidDriver<MobileElement> androidDriver;
    public static RozetkaMainPageMobile rozetkaMainPageMobile;
    private static final String URL = "http://localhost:4723/wd/hub";

    @BeforeMethod
    public void setUpDriver() throws MalformedURLException {
        androidDriver = new AndroidDriver<>(new URL(URL), CapabilitiesFactory.getCapabilities());
        androidDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        rozetkaMainPageMobile = new RozetkaMainPageMobile(androidDriver);
    }

    @AfterMethod
    public void closeApp() {
        androidDriver.closeApp();
    }
}

