package com.example.memoryappbackend.db;

import com.example.memoryappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByGoogleID(String googleID);

   // public boolean findByGoogleIDExists(String googleID);

}
