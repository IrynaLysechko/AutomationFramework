package com.epam.utils;

import com.epam.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;

@Log4j2
public class JsonReader {

    private static final String userFilePath = "src\\main\\resources\\entity\\user.json";

    public static User getUser() {
        User user =  new User();
        try {
            user = new ObjectMapper().readValue(new File(userFilePath), User.class);
        } catch (IOException e) {
            log.error("Value reading failing");
        }
        return user;
    }
    
}
