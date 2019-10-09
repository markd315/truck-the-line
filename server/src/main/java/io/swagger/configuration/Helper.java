package io.swagger.configuration;

import io.swagger.model.User;
import io.swagger.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Helper {

    @Autowired
    private ResourceService service;

    private static final String GOD_PASSWORD = "godpassword";

    public boolean adminOnly(String minAuth) {
        if (minAuth.equals(GOD_PASSWORD)) {
            return true;
        }
        return false;
    }

    public boolean authenticateUser(String email, String minAuth) {
        try {
            System.out.println(service);
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
