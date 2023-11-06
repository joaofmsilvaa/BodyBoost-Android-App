package com.example.bodyboost.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class Meals {


    @PrimaryKey()
    @SerializedName("id")
    int mealId;

    String dietary_type;
    String meal_type;

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


    public Meals(int mealId, String dietary_type, String meal_type ,String mealName, String mealsShortDescription , String mealImage ,String mealRecipe, int calories) {
        this.mealId = mealId;
        this.dietary_type = dietary_type;
        this.meal_type = meal_type;
        this.mealName = mealName;
        this.mealsShortDescription = mealsShortDescription;
        this.mealImage = mealImage;
        this.mealRecipe = mealRecipe;
        this.calories = calories;

    }

    public int getMealId() {
        return mealId;
    }

    public String getDietary_type() {
        return dietary_type;
    }

    public String getMeal_type() {
        return meal_type;
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
