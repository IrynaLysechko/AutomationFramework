package com.epam.tests.web.products;

import com.epam.page.CategoryPageWeb;
import com.epam.page.RozetkaMainPageWeb;
import com.epam.tests.web.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsWithProductTest extends BaseTest {

    private final String productLink = "bt";
    private final String categoryLink = "refrigerators";

    @Test
    public void verifyItemPresentInCatalog() {
        String producer = "Arctic";
        new RozetkaMainPageWeb()
                .clickCatalogButton()
                .moveToMenuLinks(productLink)
                .clickToCategoryLink(categoryLink)
                .checkProducer(producer)
                .verifyCatalogOfItemPresent();
    }

    @Test
    public void verifySorting() {
        CategoryPageWeb categoryPage = new CategoryPageWeb();
        String producer = "Bosch";
        String optionToSort = "2: expensive";
        new RozetkaMainPageWeb()
                .clickCatalogButton()
                .moveToMenuLinks(productLink)
                .clickToCategoryLink(categoryLink);
        categoryPage
                .clickReadyToGoCheckBox()
                .checkProducer(producer);
        List<Integer> productsPriceBeforeSelect = categoryPage.getProductPrice();
        categoryPage
                .sortList(productsPriceBeforeSelect)
                .selectAnOptionToSort(optionToSort);
        List<Integer> productsPriceAfterSelect = categoryPage.getProductPrice();
        categoryPage
                .verifySort(productsPriceBeforeSelect, productsPriceAfterSelect);
    }
}
