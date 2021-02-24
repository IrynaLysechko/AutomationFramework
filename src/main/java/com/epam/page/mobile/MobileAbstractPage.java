package com.epam.page.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MobileAbstractPage {

    public MobileAbstractPage(AndroidDriver<? extends MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
