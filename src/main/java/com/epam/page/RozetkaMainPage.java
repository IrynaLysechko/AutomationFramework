package com.epam.page;

import com.epam.factory.DriverManager;
import com.epam.page.wait.Wait;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class RozetkaMainPage extends AbstractPage {

    @FindBy(xpath = "(//button[@class='header__button'])[2]")
    private WebElement signInButton;

    @FindBy(css = "#auth_email")
    private WebElement emailInput;

    @FindBy(css = "#auth_pass")
    private WebElement passwordInput;

    @FindBy(css = "div.form__row.auth-modal__form-bottom>button")
    private WebElement logInButton;

    @FindBy(xpath = "//*[@id='fat-menu']")
    private WebElement catalogButton;

    @FindBy(css = "a.header__button")
    private WebElement userOrder;

    @FindBy(xpath = "//div[contains(@class, 'menu-wrapper_state_static')]/ul/li/a")
    private List<WebElement> menu;

    @FindBy(xpath = "//div[@class='menu__main-cats']//li/a")
    private List<WebElement> categoryLinks;

    @FindBy(xpath = "//*[@name='search']")
    private WebElement inputSearch;

    public RozetkaMainPage clickSignInButton() {
        signInButton.click();
        return this;
    }

    @Step
    public RozetkaMainPage setUserEmail(String email) {
        Wait.waitForVisibilityOfElement(emailInput);
        emailInput.sendKeys(email);
        return this;
    }

    @Step
    public RozetkaMainPage setUserPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public RozetkaMainPage clickLogInButton() {
        logInButton.click();
        return this;
    }

    @Step
    public RozetkaMainPage clickCatalogButton() {
        catalogButton.click();
        return this;
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
        String pattern = "(?:https?:\\/\\/)?(?:[^@\\n]+@)?(?:www\\.)?([^:\\/\\n?]+)";
        Pattern r = Pattern.compile(pattern);

        for (WebElement element : categoryLinks) {
            String hrefAttributeFromElement = element.getAttribute("href");
            Matcher mather = r.matcher(hrefAttributeFromElement);
            List<String> matchesString = new ArrayList<>();
            while (mather.find()) {
                matchesString.add(mather.group());
            }

            matchesString.remove("ua");
            if (matchesString.size() > 1 && matchesString.get(1).equals(categoryName)) {
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

    @Step
    public void verifyUserLogIn() {
        Assertions.assertThat(userOrder.isDisplayed());
    }

}
