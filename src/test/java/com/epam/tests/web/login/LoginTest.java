package com.epam.tests.web.login;

import com.epam.entity.User;
import com.epam.page.RozetkaMainPageWeb;
import com.epam.tests.web.BaseTest;
import com.epam.utils.JsonReader;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final User user = JsonReader.getUser();

    @Test
    public void verifyUserLogInTest() {
        new RozetkaMainPageWeb()
                .clickSignInButton()
                .setUserEmail(user.getUserEmail())
                .setUserPassword(user.getUserPassword())
                .clickLogInButton()
                .verifyUserLogIn();
    }
}
