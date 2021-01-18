package com.epam.tests.products;

import com.epam.page.CategoryPage;
import com.epam.page.RozetkaMainPage;
import com.epam.tests.BaseTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ActionsWithProductTest extends BaseTest {

    private RozetkaMainPage rozetkaMainPage = new RozetkaMainPage();
    private CategoryPage categoryPage = new CategoryPage();
    private String productLink = "bt";
    private String categoryLink = "refrigerators";
    private String producer = "Arctic";

    @Test
    public void chooseCategoryAndProducerTest() {
        rozetkaMainPage
                .moveToMenuLinks(productLink)
                .clickToCategoryLink(categoryLink)
                .checkProducer(producer);
        assertTrue(categoryPage.isCatalogOfSelectedItemPresent(), "Didn't choose any producer of item");
    }

    @Test
    public void checkSorting() {
        rozetkaMainPage
                .moveToMenuLinks(productLink)
                .clickToCategoryLink(categoryLink);
        categoryPage
                .clickReadyToGoCheckBox();
        List<Integer> productsPriceBeforeSelect = categoryPage.getProductsPrice();
        productsPriceBeforeSelect.sort(Collections.reverseOrder());
        System.out.println(productsPriceBeforeSelect.toString());
        categoryPage
                .selectAnOptionToSort("2: expensive");
        List<Integer> productsPriceAfterSelect = categoryPage.getProductsPrice();
        System.out.println(productsPriceAfterSelect.toString());
        assertEquals(productsPriceAfterSelect, productsPriceBeforeSelect, "Sorting failed");
    }

}
