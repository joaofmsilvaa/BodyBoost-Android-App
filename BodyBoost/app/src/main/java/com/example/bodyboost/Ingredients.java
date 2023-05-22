package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ingredients {

    @PrimaryKey
    int ingredientsId;

    String ingredientName;
    float calories;

    public Ingredients(int ingredientsId, String ingredientName, float calories) {
        this.ingredientsId = ingredientsId;
        this.ingredientName = ingredientName;
        this.calories = calories;
    }

    public int getIngredientsId() {
        return ingredientsId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public float getCalories() {
        return calories;
    }
}
