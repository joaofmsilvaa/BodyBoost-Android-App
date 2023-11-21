package com.example.bodyboost.models;

import java.util.List;

// Adapted object to handle the mealIngredients response from the API
public class MealIngredientsResponse {

    List<MealIngredients> data;

    public MealIngredientsResponse(List<MealIngredients> data) {
        this.data = data;
    }

    public List<MealIngredients> getData() {
        return data;
    }
}
