package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.User;
import io.swagger.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T13:59:51.930Z")

@Controller
public class UserApiController implements UserApi {

    @Autowired
    ResourceService service;

    static Random rng = new Random();

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createUser(@ApiParam(value = "Created user object", required = true)
                                           @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        body.setMinAuthCode(minpass());
        Mailer.send(body.getEmail(), "Your foodtrucks password for today", "Password is: " + body.getMinAuthCode());
        service.saveUser(body);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> createUsersWithArrayInput(@ApiParam(value = "List of user object",
            required = true) @Valid @RequestBody List<User> body) {
        String accept = request.getHeader("Accept");

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> createUsersWithListInput(@ApiParam(value = "List of user object",
            required = true) @Valid @RequestBody List<User> body) {
        String accept = request.getHeader("Accept");

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public static String minpass() {
        String ret = "";
        for (int i = 0; i < 8; i++) {
            ret += ((char) (rng.nextInt(26) + 97));
        }
        return ret;
    }

}
