package com.epam.tests.mobile;

import org.testng.annotations.Test;

public class MobileCartTest extends BaseTest {

    @Test
    public void verifyProductAddToCart() {
        rozetkaMainPageMobile
                .clickCatalog()
                .chooseItem()
                .chooseConcreteItem()
                .clickAddToCartButton()
                .clickCartButton()
                .verifyItemAddToCart();
    }

}
