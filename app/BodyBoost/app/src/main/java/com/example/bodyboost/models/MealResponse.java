package com.example.bodyboost.models;


import java.util.List;

public class MealResponse {

    List<Meals> data;

    public MealResponse(List<Meals> data) {
        this.data = data;
    }

    public List<Meals> getData() {
        return data;
    }
}

