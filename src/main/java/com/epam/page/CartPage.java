package com.epam.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {
    @FindBy(css = "div.js-rz-cart>div>a")
    WebElement cartButton;
    @CacheLookup
    @FindBy(css = "div.cart-product__main>a")
    List<WebElement> cartProducts;
    @FindBy(css = "#cartProductActions0")
    WebElement cartProductActions;
    @FindBy(xpath = "//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']")
    WebElement deleteProductFromCartButton;

    public boolean isItemPresentInCart(String itemName) {
        boolean isPresent = false;
        for (WebElement webElement : cartProducts) {
            if (webElement.getText().equals(itemName)) {
                isPresent = true;
            }
        }
        return isPresent;
    }

    public boolean isCartEmpty() {
        return cartProducts.isEmpty();
    }

    public CartPage cartProductActionsClick() {
        cartProductActions.click();
        return this;
    }

    public CartPage deleteProductFromCartButtonClick() {
        deleteProductFromCartButton.click();
        return this;
    }
}

