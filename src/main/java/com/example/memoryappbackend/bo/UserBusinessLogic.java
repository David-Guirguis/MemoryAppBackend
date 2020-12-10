package com.example.memoryappbackend.bo;
import com.example.memoryappbackend.db.UserRepository;
import com.example.memoryappbackend.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessLogic {
    private static Logger log = LoggerFactory.getLogger(UserBusinessLogic.class);

    @Autowired
    private  UserRepository userRepository;


    public  void login(String googleID) {

        if(!userExists(googleID)) {
            addUser(googleID);
        }
        else {
            log.info("User {} already exists", googleID);

        }
    }

    private  boolean userExists(String googleID) {
        return userRepository.findByGoogleID(googleID) != null;

    }

    private  void addUser(String googleID) {
        userRepository.save(new User(googleID));
        log.info("User {} Added ", googleID);

    }
}
