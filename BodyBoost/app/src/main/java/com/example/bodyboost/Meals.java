package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Meals {


    @PrimaryKey
    int mealId;

    String mealName;
    String mealRecipe;


    public Meals(int mealId, String mealName, String mealRecipe) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealRecipe = mealRecipe;
    }

    public int getMealId() {
        return mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public String getMealRecipe() {
        return mealRecipe;
    }
}
