package com.example.memoryappbackend.rest;
import com.example.memoryappbackend.bo.UserBusinessLogic;
import com.example.memoryappbackend.db.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("UserService")
public class UserService {

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserBusinessLogic userBusinessLogic;


    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public void login(@RequestBody String googleID) {

        log.info("Google id is: "+googleID);


        userBusinessLogic.login(googleID);
    }




}
