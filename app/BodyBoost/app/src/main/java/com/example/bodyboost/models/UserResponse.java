package com.example.bodyboost.models;

// Object to handle the response given by the API for the user information
public class UserResponse {

    User data;

    public UserResponse(User data) {
        this.data = data;
    }

    public User getData() {
        return data;
    }

    public int getUserId() {
        return data.getUserId();
    }

}
