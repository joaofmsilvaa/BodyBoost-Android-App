package com.example.bodyboost.viewmodels;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealIngredientsDao {

    @Query("SELECT quantity FROM MealIngredients WHERE ingredientsId = :ingredientId")
    String getQuantityById(int ingredientId);
}
