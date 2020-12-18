package com.example.memoryappbackend.model;
import javax.persistence.*;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @Column(name = "userID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @Column(name = "googleID")
    private String googleID;

    public User(String googleID) {
        this.googleID = googleID;
    }
    public User() {}

    public String getGoogleID() {
        return googleID;
    }
    public void setGoogleID(String googleID) {
        this.googleID = googleID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
}
