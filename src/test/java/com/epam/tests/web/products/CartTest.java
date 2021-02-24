package com.epam.tests.web.products;

import com.epam.page.RozetkaMainPageWeb;
import com.epam.tests.web.BaseTest;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyProductAddToCart() {
        String text = "iphone 12";
        new RozetkaMainPageWeb()
                .setTextInInputSearchAndSend(text)
                .clickFirstItemInCatalog()
                .clickBuyButton()
                .verifyItemInCart();
    }

    @Test
    public void verifyProductDeleteFromCart() {
        String productLink = "santekhnika-i-remont";
        String categoryLink = "rakoviny";
        new RozetkaMainPageWeb()
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
