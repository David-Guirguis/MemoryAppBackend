package com.example.memoryappbackend.rest;
import com.example.memoryappbackend.bo.UserBusinessLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("UserService")
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserBusinessLogic userBusinessLogic;

    //REST POST-method for logging in with google OAuth
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public void login(@RequestBody String googleID) {
        userBusinessLogic.login(googleID);
    }
}
