package com.epam.page;

import com.epam.page.wait.Wait;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(css = "div.js-rz-cart>div>a")
    private WebElement cartButton;

    @FindBy(css = "div.cart-product__main>a")
    private List<WebElement> cartProducts;

    @FindBy(css = "#cartProductActions0")
    private WebElement cartProductActions;

    @FindBy(xpath = "//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']")
    private WebElement deleteProductFromCartButton;

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
        Wait.waitForListIsEmpty(cartProducts);
        return cartProducts.isEmpty();
    }

    public CartPage cartProductActionsClick() {
        Wait.waitUntilElementToBeClickable(cartProductActions);
        cartProductActions.click();
        return this;
    }

    @Step
    public CartPage deleteProductFromCartButtonClick() {
        deleteProductFromCartButton.click();
        return this;
    }
}

