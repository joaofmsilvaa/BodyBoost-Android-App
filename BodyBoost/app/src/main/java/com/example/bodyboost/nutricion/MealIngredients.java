package com.example.bodyboost.nutricion;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(primaryKeys = {"mealsId", "ingredientsId"},foreignKeys = {
        @ForeignKey(
                entity = Meals.class,
                parentColumns = "mealsId",
                childColumns = "mealsId"
        ),
        @ForeignKey(
                entity = Ingredients.class,
                parentColumns = "ingredientsId",
                childColumns = "ingredientsId"
        )
})
public class MealIngredients {


    int mealsId;

    int ingredientsId;

    public MealIngredients(int mealsId, int ingredientsId) {
        this.mealsId = mealsId;
        this.ingredientsId = ingredientsId;
    }

    public int getMealsId() {
        return mealsId;
    }

    public int getIngredientsId() {
        return ingredientsId;
    }
}
