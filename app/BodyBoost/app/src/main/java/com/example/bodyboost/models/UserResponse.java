package com.example.bodyboost.models;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.bodyboost.views.RegisterActivity;
import com.example.bodyboost.views.homeActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserResponse {

    User data;

    public UserResponse(User data) {
        this.data = data;
    }

    public User getData() {
        return data;
    }

}
