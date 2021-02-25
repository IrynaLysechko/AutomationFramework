package com.epam.page.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import java.util.List;

public class RozetkaMainPageMobile extends MobileAbstractPage {

    @AndroidFindBy(id = "ua.com.rozetka.shop:id/graph_fatMenu")
    private MobileElement catalog;

    @AndroidFindBy(id = "ua.com.rozetka.shop:id/view_search_tv")
    private MobileElement viewInputSearch;

    @AndroidFindBy(id = "ua.com.rozetka.shop:id/search_et_query")
    private MobileElement queryInputSearch;

    @AndroidFindBy(id = "ua.com.rozetka.shop:id/item_sections_tv_title")
    private List<MobileElement> itemList;

    @AndroidFindBy(id = "ua.com.rozetka.shop:id/item_section_btn_section")
    private List<MobileElement> concreteItem;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Додати в кошик\"])[1]")
    private MobileElement addToCartButton;

    @AndroidFindBy(id = "ua.com.rozetka.shop:id/iv_toolbar_cart")
    private MobileElement cartButton;

    @AndroidFindBy(id = "ua.com.rozetka.shop:id/cart_fab_checkout")
    private MobileElement doOrderButton;

    public RozetkaMainPageMobile(AndroidDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @Step
    public RozetkaMainPageMobile clickCatalog() {
        catalog.click();
        return this;
    }

    @Step
    public RozetkaMainPageMobile chooseProduct() {
        concreteItem.get(1).click();
        return this;
    }

    @Step
    public RozetkaMainPageMobile chooseFirstItem() {
        itemList.get(0).click();
        return this;
    }

    @Step
    public RozetkaMainPageMobile clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    @Step
    public RozetkaMainPageMobile clickCartButton() {
        cartButton.click();
        return this;
    }

    @Step
    public void verifyProductPresentInCart() {
        Assertions.assertThat(doOrderButton.isDisplayed());
    }
}
