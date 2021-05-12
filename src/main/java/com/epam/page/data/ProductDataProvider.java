package com.epam.page.data;

import org.testng.annotations.DataProvider;

public class ProductDataProvider {
    private final String productLink = "bt";
    private final String categoryLink = "refrigerators";

    @DataProvider
    public Object[][] productDataProvider() {
        return new Object[][]{
                {productLink, categoryLink}
        };
    }
}
