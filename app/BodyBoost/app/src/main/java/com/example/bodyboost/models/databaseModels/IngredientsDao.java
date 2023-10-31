package com.example.bodyboost.models.databaseModels;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.bodyboost.models.Ingredients;

import java.util.List;

@Dao
public interface IngredientsDao {

    @Query("SELECT ingredients.* FROM ingredients, MealIngredients WHERE mealsId = :mealsId AND MealIngredients.ingredientsId = ingredients.ingredientsId")
    List<Ingredients> getIngredientsById(int mealsId);

}
