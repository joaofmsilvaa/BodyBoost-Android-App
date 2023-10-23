package com.example.bodyboost.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(primaryKeys = {"mealsId", "ingredientsId"})
public class MealIngredients {


    int mealsId;

    int ingredientsId;

    String quantity;

    public MealIngredients(int mealsId, int ingredientsId, String quantity) {
        this.mealsId = mealsId;
        this.ingredientsId = ingredientsId;
        this.quantity = quantity;
    }

    public int getMealsId() {
        return mealsId;
    }

    public int getIngredientsId() {
        return ingredientsId;
    }
}
