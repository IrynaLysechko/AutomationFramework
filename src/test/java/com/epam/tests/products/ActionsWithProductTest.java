package com.epam.tests.products;

import com.epam.page.CategoryPage;
import com.epam.page.RozetkaMainPage;
import com.epam.tests.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsWithProductTest extends BaseTest {

    private final String productLink = "bt";
    private final String categoryLink = "refrigerators";

    @Test
    public void verifyItemPresentInCatalog() {
        String producer = "Arctic";
        new RozetkaMainPage()
                .clickCatalogButton()
                .moveToMenuLinks(productLink)
                .clickToCategoryLink(categoryLink)
                .checkProducer(producer)
                .verifyCatalogOfItemPresent();
    }

    @Test
    public void verifySorting() {
        CategoryPage categoryPage = new CategoryPage();
        new RozetkaMainPage()
                .clickCatalogButton()
                .moveToMenuLinks(productLink)
                .clickToCategoryLink(categoryLink);
        categoryPage
                .clickReadyToGoCheckBox()
                .checkProducer("Bosch");
        List<Integer> productsPriceBeforeSelect = categoryPage.getProductPrice();
        categoryPage
                .sortList(productsPriceBeforeSelect)
                .selectAnOptionToSort("2: expensive");
        List<Integer> productsPriceAfterSelect = categoryPage.getProductPrice();
        categoryPage
                .verifySort(productsPriceBeforeSelect, productsPriceAfterSelect);
    }
}
