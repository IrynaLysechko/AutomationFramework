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

    @Test
    public void chooseCategoryAndProducerTest() {
        rozetkaMainPage
                .moveToMenuLinks("Сантехніка та ремонт")
                .clickToCategoryLink("Насоси та помпи")
                .checkProducer("Optima");
        assertTrue(categoryPage.isCatalogOfSelectedItemPresent(), "Didn't choose any producer of item");
    }

    @Test
    public void checkSorting() {
        rozetkaMainPage
                .moveToMenuLinks("Ноутбуки та комп’ютери")
                .clickToCategoryLink("Apple");
        List<Integer> productsPriceBeforeSelect = categoryPage.getProductsPrice();
        productsPriceBeforeSelect.sort(Collections.reverseOrder());
        categoryPage.selectAnOptionToSort("2: expensive");
        List<Integer> productsPriceAfterSelect = categoryPage.getProductsPrice();
        assertEquals(productsPriceAfterSelect, productsPriceBeforeSelect, "Sorting failed");
    }

}
