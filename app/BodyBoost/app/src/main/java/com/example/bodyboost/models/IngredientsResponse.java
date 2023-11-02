package com.example.bodyboost.models;

import java.util.List;

public class IngredientsResponse {

    List<Ingredients> data;

    public IngredientsResponse(List<Ingredients> data) {
        this.data = data;
    }

    public List<Ingredients> getData() {
        return data;
    }
}
