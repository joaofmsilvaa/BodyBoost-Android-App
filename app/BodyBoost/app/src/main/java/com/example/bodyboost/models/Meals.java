package com.example.bodyboost.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Meals {


    @PrimaryKey(autoGenerate = true)
    int mealId;
    @SerializedName("name")
    String mealName;

    @SerializedName("excerpt")
    String mealsShortDescription;

    @SerializedName("recipe")
    String mealRecipe;

    @SerializedName("thumbnail")
    String mealImage;

    @SerializedName("calories")
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
        String baseThumbnailPath = "http://10.0.2.2:8000/storage/";

        return baseThumbnailPath + mealImage;
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
