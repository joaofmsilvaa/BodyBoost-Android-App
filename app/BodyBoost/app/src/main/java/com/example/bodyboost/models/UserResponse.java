package com.example.bodyboost.models;

import java.util.List;

public class UserResponse {

    User data;

    public UserResponse(User data) {
        this.data = data;
    }

    public User getData() {
        return data;
    }
}
