package com.epam.tests.products;

import com.epam.page.CategoryPage;
import com.epam.page.RozetkaMainPage;
import com.epam.tests.BaseTest;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void searchProductAndAddToCart() {
        String text = "iphone 12";
        String itemName = new RozetkaMainPage()
                .setTextInInputSearchAndSend(text)
                .firstItemInCatalogClick()
                .getItemName();
        new CategoryPage()
                .clickBuyButton()
                .verifyItemInCart(itemName);
    }

    @Test
    public void deleteProductFromCart() {
        String productLink = "santekhnika-i-remont";
        String categoryLink = "mixer_taps";
        new RozetkaMainPage()
                .moveToMenuLinks(productLink)
                .clickToCategoryLink(categoryLink)
                .firstItemInCatalogClick()
                .clickBuyButton()
                .cartProductActionsClick()
                .deleteProductFromCartButtonClick()
                .verifyCartIsEmpty();
    }

}
