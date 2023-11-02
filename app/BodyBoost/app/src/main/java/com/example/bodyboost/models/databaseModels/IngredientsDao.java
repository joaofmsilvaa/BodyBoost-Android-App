package com.example.bodyboost.models.databaseModels;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodyboost.models.Ingredients;
import com.example.bodyboost.models.Meals;

import java.util.List;

@Dao
public interface IngredientsDao {

    @Query("SELECT ingredients.* FROM ingredients, MealIngredients WHERE mealId = :mealsId AND MealIngredients.ingredientsId = ingredients.ingredientsId")
    LiveData<List<Ingredients>> getIngredientsById(int mealsId);

    @Insert()
    void insert(Ingredients ingredients);

    @Delete
    void deleteIngred(Ingredients ingredients);

    @Query("SELECT * FROM ingredients WHERE ingredientsId = :id")
    Ingredients getById(int id);

}
