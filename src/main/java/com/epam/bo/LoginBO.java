package com.epam.bo;

import com.epam.entity.User;
import com.epam.page.RozetkaMainPage;
import io.qameta.allure.Step;

public class LoginBO {

    private RozetkaMainPage rozetkaMainPage;

    public LoginBO() {
        rozetkaMainPage = new RozetkaMainPage();
    }

    @Step("Login with email {user.email} and password {user.password}")
    public void logIn(User user) {
        rozetkaMainPage
                .clickSignInButton()
                .setUserEmail(user.getUserEmail())
                .setUserPassword(user.getUserPassword())
                .clickLogInButton();
    }

    @Step("Check login")
    public boolean checkLogIn() {
        return rozetkaMainPage.userLink().isDisplayed();
    }
}
