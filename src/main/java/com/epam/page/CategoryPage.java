package com.epam.page;

import com.epam.factory.DriverManager;
import com.epam.page.wait.Wait;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
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

    public String getItemName() {
        return itemName.getText();
    }

    @Step
    public List<Integer> getProductPrice() {
        new WebDriverWait(DriverManager.getDriver(),30).until(ExpectedConditions.visibilityOfAllElements(productsPrice));
        return productsPrice.stream()
                .map(webElement -> Integer.parseInt(webElement.getText().replaceAll("\\s+", "")))
                .collect(Collectors.toList());
    }

    public CategoryPage firstItemInCatalogClick() {
        Wait.waitForVisibilityOfElement(firstItemInCatalog);
        firstItemInCatalog.click();
        return this;
    }

    @Step
    public CategoryPage checkProducer(String producerName) {
        for (WebElement element : label) {
            if (element.getAttribute("for").equals(producerName)) {
                element.click();
                break;
            }
        }
        return this;
    }

    @Step
    public CartPage clickBuyButton() {
        Wait.waitUntilElementToBeClickable(buyButton);
        buyButton.click();
        return new CartPage();
    }

    public CategoryPage sortList(List<Integer> list) {
        list.sort(Comparator.reverseOrder());
        return this;
    }

    public CategoryPage clickReadyToGoCheckBox() {
        readyToGoCheckBox.click();
        return this;
    }

    @Step
    public CategoryPage selectAnOptionToSort(String option) {
        Select select = new Select(DriverManager.getDriver()
                .findElement(By.cssSelector("select.select-css.ng-untouched.ng-pristine.ng-valid")));
        select.selectByValue(option);
        return this;
    }

    @Step
    public void verifyCatalogOfItemPresent() {
        Wait.waitForVisibilityOfElement(catalog);
        Assertions.assertThat(catalog.isDisplayed());
    }

    @Step
    public void verifySort(List<Integer> before, List<Integer> after) {
        Assertions.assertThat(before).isEqualTo(after);
    }
}
