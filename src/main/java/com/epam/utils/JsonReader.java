package com.epam.utils;

import com.epam.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    private static final Logger logger = LogManager.getLogger(JsonReader.class);
    private static final String userFilePath = "src\\main\\resources\\entity\\user.json";

    public static User getUser() {
        User user =  new User();
        try {
            user = new ObjectMapper().readValue(new File(userFilePath), User.class);
        } catch (IOException e) {
            logger.error("Value reading failing");
        }
        return user;
    }
    
}
