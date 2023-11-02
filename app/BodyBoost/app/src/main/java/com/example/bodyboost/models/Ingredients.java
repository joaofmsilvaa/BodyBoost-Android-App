package com.example.bodyboost.models;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity(primaryKeys = {"ingredientsId"})
public class Ingredients {

    @SerializedName("id")
    int ingredientsId;

    @SerializedName("name")
    String ingredientName;

    public Ingredients(int ingredientsId, String ingredientName) {
        this.ingredientsId = ingredientsId;
        this.ingredientName = ingredientName;
    }

    public int getIngredientsId() {
        return ingredientsId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

}
