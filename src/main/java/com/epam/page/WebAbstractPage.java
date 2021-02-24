package com.epam.page;

import com.epam.factory.DriverManager;
import org.openqa.selenium.support.PageFactory;

public abstract class WebAbstractPage {

    public WebAbstractPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
