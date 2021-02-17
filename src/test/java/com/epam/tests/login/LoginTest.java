package com.epam.tests.login;

import com.epam.entity.User;
import com.epam.page.RozetkaMainPage;
import com.epam.tests.BaseTest;
import com.epam.utils.JsonReader;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final User user = JsonReader.getUser();

    @Test
    public void logInTest() {
        new RozetkaMainPage()
                .clickSignInButton()
                .setUserEmail(user.getUserEmail())
                .setUserPassword(user.getUserPassword())
                .clickLogInButton()
                .verifyUserLogIn();
    }
}
