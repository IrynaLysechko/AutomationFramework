package com.epam.tests.login;

import com.epam.bo.LoginBO;
import com.epam.entity.User;
import com.epam.tests.BaseTest;
import com.epam.utils.JsonReader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private LoginBO loginBO = new LoginBO();
    private User user = JsonReader.getUser();

    @Test
    public void logInTest() {
        loginBO.logIn(user);
        assertTrue(loginBO.checkLogIn(), "User login failed");
    }
}
