package com.epam.page;

import com.epam.factory.DriverManager;
import com.epam.page.wait.Wait;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class CategoryPageWeb extends WebAbstractPage {

    @FindBy(xpath = "//div[@class='scrollbar__inner']//label")
    private List<WebElement> label;

    @FindBy(css = "div.catalog-selection")
    private WebElement catalog;

    @FindBy(xpath = "//ul[@class='catalog-grid']/li[1]//a")
    private WebElement firstItemInCatalog;

    @FindBy(css = "div.product__heading>h1")
    private WebElement itemName;

    @FindBy(xpath = "//*[@class='product__buy']//button")
    private WebElement buyButton;

    @FindBy(css = "div.js-rz-cart>div.header-actions__button-wrapper")
    private WebElement cartButton;

    @FindBy(css = "span.goods-tile__price-value")
    private List<WebElement> productsPrice;

    @FindBy(css = "select.select-css.ng-untouched.ng-pristine.ng-valid")
    private WebElement select;

    @FindBy(xpath = "//div[contains(@data-filter-name,'gotovo-k-otpravke')]//label")
    private WebElement readyToGoCheckBox;

    @FindBy(xpath = "//input[@name='searchline']")
    private WebElement inputForProducer;

    @Step
    public List<Integer> getProductPrice() {
        new WebDriverWait(DriverManager.getDriver(), 20).until(ExpectedConditions.visibilityOfAllElements(productsPrice));
        return productsPrice.stream()
                .map(webElement -> Integer.parseInt(webElement.getText().replaceAll("\\s+", "")))
                .collect(Collectors.toList());
    }

    @Step
    public CategoryPageWeb clickFirstItemInCatalog() {
        Wait.waitForVisibilityOfElement(firstItemInCatalog);
        firstItemInCatalog.click();
        return this;
    }

    @Step
    public CategoryPageWeb checkProducer(String producerName) {
        for (WebElement element : label) {
            Wait.waitForVisibilityOfElement(element);
            if (element.getAttribute("for").equals(producerName)) {
                element.click();
                break;
            }
        }
        return this;
    }

    @Step
    public CartPageWeb clickBuyButton() {
        Wait.waitUntilElementToBeClickable(buyButton);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", buyButton);
        return new CartPageWeb();
    }

    public CategoryPageWeb sortList(List<Integer> list) {
        list.sort(Comparator.reverseOrder());
        return this;
    }

    @Step
    public CategoryPageWeb clickReadyToGoCheckBox() {
        readyToGoCheckBox.click();
        return this;
    }

    @Step
    public CategoryPageWeb selectAnOptionToSort(String option) {
        Select select = new Select(DriverManager.getDriver()
                .findElement(By.cssSelector("select.select-css.ng-untouched.ng-pristine.ng-valid")));
        select.selectByValue(option);
        new WebDriverWait(DriverManager.getDriver(), 20).until(ExpectedConditions.visibilityOfAllElements(productsPrice));
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
