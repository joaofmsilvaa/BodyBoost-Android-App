package com.example.bodyboost.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Meals {


    @PrimaryKey(autoGenerate = true)
    int mealId;
    String mealName;
    String mealsShortDescription;
    String mealRecipe;
    String mealImage;

    int calories;

    public Meals(int mealId, String mealName, String mealsShortDescription , String mealImage ,String mealRecipe, int calories) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealsShortDescription = mealsShortDescription;
        this.mealImage = mealImage;
        this.mealRecipe = mealRecipe;
        this.calories = calories;
    }

    public int getMealId() {
        return mealId;
    }

    public String getMealsShortDescription() {
        return mealsShortDescription;
    }

    public String getMealImage() {
        return mealImage;
    }

    public int getCalories() {
        return calories;
    }

    public String getMealName() {
        return mealName;
    }

    public String getMealRecipe() {
        return mealRecipe;
    }
}
