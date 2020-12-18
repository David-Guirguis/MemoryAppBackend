package com.example.memoryappbackend.dao;

import com.example.memoryappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByGoogleID(String googleID);
}
