package com.example.bodyboost.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


import com.google.gson.annotations.SerializedName;

@Entity
public class MealIngredients {
    @PrimaryKey
    public int id;

    @SerializedName("meal_id")
    public int mealId;

    @SerializedName("ingredients_id")
    public int ingredientsId;

    @SerializedName("measure")
    public String quantity;

    public MealIngredients() {
    }

    public MealIngredients(int id, int mealId, int ingredientsId, String quantity) {
        this.id = id;
        this.mealId = mealId;
        this.ingredientsId = ingredientsId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getIngredientsId() {
        return ingredientsId;
    }

    public int getMealId() {
        return mealId;
    }

    public String getQuantity() {
        return quantity;
    }
}
