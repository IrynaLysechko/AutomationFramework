package com.epam.page;

import com.epam.factory.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends AbstractPage {
    @FindBy(xpath = "//div[@data-filter-name='producer']//ul[2]/li/ul/li/a/label")
    List<WebElement> label;
    @FindBy(css = "div.catalog-selection")
    WebElement catalog;
    @FindBy(xpath = "//ul[@class='catalog-grid']/li[1]//a")
    WebElement firstItemInCatalog;
    @FindBy(css = "div.product__heading>h1")
    WebElement itemName;
    @FindBy(xpath = "//*[@class='buy-button button button_with_icon button_color_green button_size_large']")
    WebElement buyButton;
    @FindBy(css = "div.js-rz-cart>div.header-actions__button-wrapper")
    WebElement cartButton;
    @FindBy(css = "span.goods-tile__price-value")
    List<WebElement> productsPrice;
    @FindBy(css = "select.select-css.ng-untouched.ng-pristine.ng-valid")
    WebElement select;
    @FindBy(xpath = "(//*[@class='wish-button js-wish-button'])[1]")
    WebElement wishButton;
    @FindBy(xpath = "//div[contains(@data-filter-name,'gotovo-k-otpravke')]//label")
    WebElement readyToGoCheckBox;

    public void checkProducer(String producerName) {
        for (WebElement element : label) {
            if (element.getAttribute("for").equals(producerName)) {
                element.click();
                return;
            }
        }
    }

    public boolean isCatalogOfSelectedItemPresent() {
        new WebDriverWait(DriverManager.getDriver(), 20).until(ExpectedConditions.visibilityOf(catalog));
        return catalog.isDisplayed();
    }

    public CategoryPage firstItemInCatalogClick() {
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
            new WebDriverWait(DriverManager.getDriver(), 25).until(ExpectedConditions.visibilityOf(webElement));
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
