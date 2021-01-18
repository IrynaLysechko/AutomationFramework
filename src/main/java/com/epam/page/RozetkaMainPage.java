package com.epam.page;

import com.epam.factory.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RozetkaMainPage extends AbstractPage {

    private Logger logger = LogManager.getLogger(RozetkaMainPage.class);
    @FindBy(xpath = "(//button[@type='button'])[2]")
    WebElement signInButton;

    @FindBy(css = "#auth_email")
    WebElement emailInput;

    @FindBy(css = "#auth_pass")
    WebElement passwordInput;

    @FindBy(css = "div.form__row.auth-modal__form-bottom>button")
    WebElement logInButton;

    @FindBy(css = "a.header-topline__user-link")
    WebElement userLink;

    @FindBy(xpath = "//div[contains(@class, 'menu-wrapper_state_static')]/ul/li/a")
    List<WebElement> menu;

    @FindBy(xpath = "//div[@class='menu__main-cats']//li/a")
    List<WebElement> categoryLinks;

    @FindBy(xpath = "//*[@name='search']")
    WebElement inputSearch;

    public RozetkaMainPage clickSignInButton() {
        signInButton.click();
        return this;
    }

    public RozetkaMainPage setUserEmail(String email) {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
        return this;
    }

    public RozetkaMainPage setUserPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public RozetkaMainPage clickLogInButton() {
        logInButton.click();
        return this;
    }

    public WebElement userLink() {
        return userLink;
    }

    @Step
    public RozetkaMainPage moveToMenuLinks(String menuItem) {
        Actions actions = new Actions(DriverManager.getDriver());
        for (WebElement element : menu) {
            if (element.getAttribute("href").contains(menuItem)) {
                actions.moveToElement(element).build().perform();
                break;
            }
        }
        return this;
    }

    @Step
    public CategoryPage clickToCategoryLink(String categoryName) {
        for (WebElement element : categoryLinks) {
            if (element.getAttribute("href").contains(categoryName)) {
                element.click();
                break;
            }
        }
        return new CategoryPage();
    }

    @Step
    public CategoryPage setTextInInputSearchAndSend(String searchItem) {
        inputSearch.sendKeys(searchItem);
        inputSearch.sendKeys(Keys.ENTER);
        return new CategoryPage();
    }

}
