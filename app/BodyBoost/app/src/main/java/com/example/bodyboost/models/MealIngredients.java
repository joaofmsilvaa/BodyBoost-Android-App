package com.example.bodyboost.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Relation;

import com.google.gson.annotations.SerializedName;

@Entity(primaryKeys = {"mealId", "ingredientsId"})
public class MealIngredients {


    @SerializedName("meal_id")
    int mealId;

    @SerializedName("ingredients_id")
    int ingredientsId;

    int amount;

    @SerializedName("measure")
    String quantity;


    public MealIngredients() {}

    public MealIngredients(int mealsId, int ingredientsId, int amount ,String quantity) {
        this.mealId = mealsId;
        this.ingredientsId = ingredientsId;
        this.quantity = quantity;
        this.amount = amount;

    }

    public int getMealsId() {
        return mealId;
    }

    public int getIngredientsId() {
        return ingredientsId;
    }
}
