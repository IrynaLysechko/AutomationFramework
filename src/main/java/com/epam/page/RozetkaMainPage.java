package com.epam.page;

import com.epam.factory.DriverManager;
import com.epam.page.wait.Wait;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RozetkaMainPage extends AbstractPage {
    private Logger logger = LogManager.getLogger(RozetkaMainPage.class);
    @FindBy(xpath = "(//button[@type='button'])[2]")
    private WebElement signInButton;

    @FindBy(css = "#auth_email")
    private WebElement emailInput;

    @FindBy(css = "#auth_pass")
    private WebElement passwordInput;

    @FindBy(css = "div.form__row.auth-modal__form-bottom>button")
    private WebElement logInButton;

    @FindBy(css = "a.header-topline__user-link")
    private WebElement userLink;

    @FindBy(xpath = "//div[contains(@class, 'menu-wrapper_state_static')]/ul/li/a")
    private List<WebElement> menu;

    @FindBy(xpath = "//div[@class='menu__main-cats']//li/a")
    private List<WebElement> categoryLinks;

    @FindBy(xpath = "//*[@name='search']")
    private WebElement inputSearch;

    @Step
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
//        String pattern = "(?:https?:\\/\\/)?(?:[^@\\n]+@)?(?:www\\.)?([^:\\/\\n?]+)";
//        Pattern r = Pattern.compile(pattern);
//
//        for (WebElement element : categoryLinks) {
//            String hrefAttributeFromElement = element.getAttribute("href");
//            Matcher mather = r.matcher(hrefAttributeFromElement);
//            List<String> matchesString = new ArrayList<>();
//            while (mather.find()) {
//                matchesString.add(mather.group());
//            }
//            matchesString.remove("ua");
//            System.out.println(matchesString.toString());
//            if (matchesString.size() > 1 && matchesString.get(1).equals(categoryName)) {
//                element.click();
//                break;
//            }
//        }
//        return new CategoryPage();
        String pattern = "/(.*?)/";
        Pattern r = Pattern.compile(pattern);
        for (WebElement element : categoryLinks) {
            String element1 = element.getAttribute("href").replace("https://", "").replace("/ua", "");
            Matcher m = r.matcher(element1);
            String name = "";
            if (m.find()) {
                name = m.group();
            }
            if (name.equals(categoryName)) {
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
