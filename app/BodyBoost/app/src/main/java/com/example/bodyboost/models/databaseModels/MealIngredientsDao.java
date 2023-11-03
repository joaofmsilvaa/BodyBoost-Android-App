package com.example.bodyboost.models.databaseModels;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodyboost.models.Ingredients;
import com.example.bodyboost.models.MealIngredients;

import java.util.List;

@Dao
public interface MealIngredientsDao {

    @Query("SELECT quantity FROM MealIngredients WHERE ingredientsId = :ingredientId")
    String getQuantityById(int ingredientId);

    @Insert()
    void insert(MealIngredients mealIngredients);

    @Delete()
    void delete(MealIngredients mealIngredients);

    @Query("SELECT * FROM mealingredients WHERE id = :id")
    MealIngredients getById(int id);

}
