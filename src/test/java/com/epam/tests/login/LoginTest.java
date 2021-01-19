package com.epam.tests.login;

import com.epam.entity.User;
import com.epam.page.RozetkaMainPage;
import com.epam.tests.BaseTest;
import com.epam.utils.JsonReader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private RozetkaMainPage rozetkaMainPage = new RozetkaMainPage();
    private User user = JsonReader.getUser();

    @Test
    public void logInTest() {
        rozetkaMainPage
                .clickSignInButton()
                .setUserEmail(user.getUserEmail())
                .setUserPassword(user.getUserPassword())
                .clickLogInButton();
        assertTrue(rozetkaMainPage.userLink().isDisplayed());
    }
}
