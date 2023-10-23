package com.example.bodyboost.viewmodels;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.bodyboost.models.Meals;

import java.util.List;

@Dao
public interface MealsDao {

    @Query("SELECT * FROM Meals")
    List<Meals> getAll();

    @Query("SELECT mealImage FROM meals WHERE mealId = :mealId")
    String getMealsImgById(int mealId);

    @Query("SELECT mealName FROM meals WHERE mealId = :mealId")
    String getMealsNameById(int mealId);

    @Query("SELECT mealRecipe FROM meals WHERE mealId = :mealId")
    String getRecipeById(int mealId);

    @Query("SELECT calories FROM meals WHERE mealId = :mealId")
    int getCaloriesById(int mealId);
}
