package com.epam.page;

import com.epam.factory.DriverManager;
import com.epam.page.wait.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends AbstractPage {
    @FindBy(xpath = "//div[@data-filter-name='producer']//ul[2]/li/ul/li/a/label")
    private List<WebElement> label;
    @FindBy(css = "div.catalog-selection")
    private WebElement catalog;
    @FindBy(xpath = "//ul[@class='catalog-grid']/li[1]//a")
    private WebElement firstItemInCatalog;
    @FindBy(css = "div.product__heading>h1")
    private WebElement itemName;
    @FindBy(xpath = "//*[@class='buy-button button button_with_icon button_color_green button_size_large']")
    private WebElement buyButton;
    @FindBy(css = "div.js-rz-cart>div.header-actions__button-wrapper")
    private WebElement cartButton;
    @FindBy(css = "span.goods-tile__price-value")
    private List<WebElement> productsPrice;
    @FindBy(css = "select.select-css.ng-untouched.ng-pristine.ng-valid")
    private WebElement select;
    @FindBy(xpath = "(//*[@class='wish-button js-wish-button'])[1]")
    private WebElement wishButton;
    @FindBy(xpath = "//div[contains(@data-filter-name,'gotovo-k-otpravke')]//label")
    private WebElement readyToGoCheckBox;

    public void checkProducer(String producerName) {
        for (WebElement element : label) {
            if (element.getAttribute("for").equals(producerName)) {
                element.click();
                return;
            }
        }
    }

    public boolean isCatalogOfSelectedItemPresent() {
        Wait.waitForVisibilityOfElement(catalog);
        return catalog.isDisplayed();
    }

    public CategoryPage firstItemInCatalogClick() {
        Wait.waitForVisibilityOfElement(firstItemInCatalog);
        firstItemInCatalog.click();
        return this;
    }

    public String getItemName() {
        return itemName.getText();
    }

    public CartPage clickBuyButton() {
        buyButton.click();
        return new CartPage();
    }

    public List<Integer> getProductsPrice() {
        List<Integer> priceList = new ArrayList<>();
        for (WebElement webElement : productsPrice) {
            Wait.waitForVisibilityOfElement(webElement);
            int price = Integer.parseInt(webElement.getText().replaceAll("\\s+", ""));
            priceList.add(price);
        }
        return priceList;
    }

    public CategoryPage clickReadyToGoCheckBox() {
        readyToGoCheckBox.click();
        return this;
    }

    public CategoryPage selectAnOptionToSort(String option) {
        Select select = new Select(DriverManager.getDriver().findElement(By.cssSelector("select.select-css.ng-untouched.ng-pristine.ng-valid")));
        select.selectByValue(option);
        return this;
    }

}
