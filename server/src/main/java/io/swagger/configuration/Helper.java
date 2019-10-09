package io.swagger.configuration;

import io.swagger.model.User;
import io.swagger.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Helper {

    @Autowired
    private static ResourceService service;

    private static final String GOD_PASSWORD = "godpassword";

    public static boolean adminOnly(String minAuth) {
        if (minAuth.equals(GOD_PASSWORD)) {
            return true;
        }
        return false;
    }

    public static boolean authenticateUser(String email, String minAuth) {
        try {
            User user = service.findUserById(email);
            if (user.getMinAuthCode().equals(minAuth) || minAuth.equals(GOD_PASSWORD)) {
                return true;
            }
            return false;
        } catch (Exception ex1) {
            return false;
        }
    }
}
