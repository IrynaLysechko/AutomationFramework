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

    @Test
    public void searchProductAndAddToCart() {
        String itemName = rozetkaMainPage
                .setTextInInputSearchAndSend("iphone 12")
                .firstItemInCatalogClick()
                .getItemName();
        categoryPage.clickBuyButton();
        assertTrue(cartPage.isItemPresentInCart(itemName), "Cart is empty");
    }

    @Test
    public void deleteProductFromCart() {
        rozetkaMainPage
                .moveToMenuLinks("Ноутбуки та комп’ютери")
                .clickToCategoryLink("Apple")
                .firstItemInCatalogClick()
                .clickBuyButton()
                .cartProductActionsClick()
                .deleteProductFromCartButtonClick();
        assertTrue(cartPage.isCartEmpty(), "Failed delete item from cart");
    }
}
