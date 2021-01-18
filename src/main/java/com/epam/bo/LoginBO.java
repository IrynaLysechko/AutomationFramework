package com.epam.bo;

import com.epam.entity.User;
import com.epam.page.RozetkaMainPage;
import io.qameta.allure.Step;

public class LoginBO {

    private RozetkaMainPage rozetkaMainPage;

    public LoginBO() {
        rozetkaMainPage = new RozetkaMainPage();
    }

    @Step("Login with email {user.userEmail} and password {user.userPassword}")
    public void logIn(User user) {
        rozetkaMainPage
                .clickSignInButton()
                .setUserEmail(user.getUserEmail())
                .setUserPassword(user.getUserPassword())
                .clickLogInButton();
    }

    @Step
    public boolean checkLogIn() {
        return rozetkaMainPage.userLink().isDisplayed();
    }
}
