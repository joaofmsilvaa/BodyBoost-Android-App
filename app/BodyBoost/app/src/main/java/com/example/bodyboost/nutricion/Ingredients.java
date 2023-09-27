package com.example.bodyboost.nutricion;

import androidx.room.Entity;

@Entity(primaryKeys = {"ingredientsId"})
public class Ingredients {

    int ingredientsId;
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
