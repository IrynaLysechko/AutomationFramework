package com.epam.tests.mobile.cart;

import com.epam.tests.mobile.BaseTest;
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
                .verifyProductPresentInCart();
    }

}
