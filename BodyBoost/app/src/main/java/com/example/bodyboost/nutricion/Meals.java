package com.example.bodyboost.nutricion;

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


    public Meals(int mealId, String mealName, String mealsShortDescription , String mealImage ,String mealRecipe) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealsShortDescription = mealsShortDescription;
        this.mealImage = mealImage;
        this.mealRecipe = mealRecipe;
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

    public String getMealName() {
        return mealName;
    }

    public String getMealRecipe() {
        return mealRecipe;
    }
}
