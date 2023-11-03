package com.example.bodyboost.models;

import java.util.List;

public class MealIngredientsResponse {

    List<MealIngredients> data;

    public MealIngredientsResponse(List<MealIngredients> data) {
        this.data = data;
    }

    public List<MealIngredients> getData() {
        return data;
    }
}
