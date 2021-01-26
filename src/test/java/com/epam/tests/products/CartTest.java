package com.epam.tests.products;

import com.epam.page.CartPage;
import com.epam.page.CategoryPage;
import com.epam.page.RozetkaMainPage;
import com.epam.tests.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    private RozetkaMainPage rozetkaMainPage = new RozetkaMainPage();
    private CategoryPage categoryPage = new CategoryPage();
    private CartPage cartPage = new CartPage();
    private String text = "iphone 12";
    private String productLink = "computers-notebooks";
    private String categoryLink = "apple";
    private String cN = "/cookers/";
    private String pl = "bt";

    @Test
    public void searchProductAndAddToCart() {
        String itemName = rozetkaMainPage
                .setTextInInputSearchAndSend(text)
                .firstItemInCatalogClick()
                .getItemName();
        categoryPage.clickBuyButton();
        assertTrue(cartPage.isItemPresentInCart(itemName), "Cart is empty");
    }

    @Test
    public void deleteProductFromCart() {
        rozetkaMainPage
                .moveToMenuLinks(pl)
                .clickToCategoryLink(cN)
                .firstItemInCatalogClick()
                .clickBuyButton()
                .cartProductActionsClick()
                .deleteProductFromCartButtonClick();
        assertTrue(cartPage.isCartEmpty(), "Failed delete item from cart");
    }
}
