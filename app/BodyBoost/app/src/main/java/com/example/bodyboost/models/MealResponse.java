package com.example.bodyboost.models;


import java.util.List;

// Adapted object to handle the API response
public class MealResponse {

    List<Meals> data;

    public MealResponse(List<Meals> data) {
        this.data = data;
    }

    public List<Meals> getData() {
        return data;
    }
}

