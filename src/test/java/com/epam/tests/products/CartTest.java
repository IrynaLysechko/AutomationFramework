package com.epam.tests.products;

import com.epam.page.RozetkaMainPage;
import com.epam.tests.BaseTest;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyProductAddToCart() {
        String text = "iphone 12";
        new RozetkaMainPage()
                .setTextInInputSearchAndSend(text)
                .clickFirstItemInCatalog()
                .clickBuyButton()
                .verifyItemInCart();
    }

    @Test
    public void verifyProductDeleteFromCart() {
        String productLink = "santekhnika-i-remont";
        String categoryLink = "rakoviny";
        new RozetkaMainPage()
                .clickCatalogButton()
                .moveToMenuLinks(productLink)
                .clickToCategoryLink(categoryLink)
                .clickFirstItemInCatalog()
                .clickBuyButton()
                .clickCartProductActions()
                .deleteProductFromCartButtonClick()
                .verifyCartIsEmpty();
    }

}
