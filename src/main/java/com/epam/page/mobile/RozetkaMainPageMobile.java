package com.epam.page.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;

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

    @AndroidFindBy(id = "ua.com.rozetka.shop:id/item_search_tv_title")
    private List<MobileElement> searchItemList;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Додати в кошик\"])[1]")
    private MobileElement addToCartButton;

    @AndroidFindBy(id = "ua.com.rozetka.shop:id/iv_toolbar_cart")
    private MobileElement cartButton;

    @AndroidFindBy(id = "ua.com.rozetka.shop:id/cart_fab_checkout")
    private MobileElement doOrderButton;

    public RozetkaMainPageMobile(AndroidDriver<? extends MobileElement> driver) {
        super(driver);
    }

    public RozetkaMainPageMobile clickCatalog() {
        catalog.click();
        return this;
    }

    public RozetkaMainPageMobile clickViewInputSearch() {
        viewInputSearch.click();
        return this;
    }

    public RozetkaMainPageMobile setQueryToInputSearch(String query) {
        queryInputSearch.sendKeys(query);
        return this;
    }

    public RozetkaMainPageMobile chooseConcreteItem() {
        concreteItem.get(1).click();
        return this;
    }

    public RozetkaMainPageMobile chooseItem() {
        itemList.get(0).click();
        return this;
    }

    public RozetkaMainPageMobile clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }
    public RozetkaMainPageMobile clickCartButton() {
        cartButton.click();
        return this;
    }

    public void verifyItemAddToCart() {
        Assertions.assertThat(doOrderButton.isDisplayed());
    }
}
