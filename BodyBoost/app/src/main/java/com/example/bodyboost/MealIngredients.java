package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.example.bodyboost.Exercise_classes.ExerciseSet;

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
