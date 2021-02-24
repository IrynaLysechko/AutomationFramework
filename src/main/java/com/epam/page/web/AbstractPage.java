package com.epam.page.web;

import com.epam.factory.DriverManager;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
