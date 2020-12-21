package com.example.memoryappbackend.bo;
import com.example.memoryappbackend.dao.UserRepository;
import com.example.memoryappbackend.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessLogic {
    private static Logger log = LoggerFactory.getLogger(UserBusinessLogic.class);

    //Inject an instance of UserRepository here
    @Autowired
    private UserRepository userRepository;

    //Logging in if user exists in database. If user does not exist, add user to database
    public void login(String googleID) {
        if(!userExists(googleID)) {
            addUser(googleID);
        }
        else {
            log.info("User {} already exists", googleID);
        }
    }

    //Helper method to check if user already exists
    private boolean userExists(String googleID) {
        return userRepository.findByGoogleID(googleID) != null;
    }

    //Helper method to add user to database
    private void addUser(String googleID) {
        userRepository.save(new User(googleID));
        log.info("User {} Added ", googleID);
    }
}
