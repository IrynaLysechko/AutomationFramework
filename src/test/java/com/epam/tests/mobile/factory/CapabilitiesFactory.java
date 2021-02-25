package com.epam.tests.mobile.factory;

import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Allure;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesFactory {

    private static final String PLATFORM_NAME = "Android";
    private static final String UDID = "emulator-5554";
    private static final String APP_PACKAGE = "ua.com.rozetka.shop";
    private static final String APP_ACTIVITY = "ua.com.rozetka.shop.screen.MainActivity";

    public static DesiredCapabilities getCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.UDID, UDID);
        capabilities.setCapability("appPackage", APP_PACKAGE);
        capabilities.setCapability("appActivity", APP_ACTIVITY);
        Allure.addAttachment("capabilities", capabilities.asMap().toString());
        return capabilities;
    }
}
