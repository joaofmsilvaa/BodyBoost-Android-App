package com.example.bodyboost.models.databaseModels;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bodyboost.models.Meals;

import java.util.List;

@Dao
public interface MealsDao {

    @Query("SELECT * FROM Meals ORDER BY mealId DESC")
    LiveData<List<Meals>> getAll();

    @Query("SELECT * FROM Meals WHERE mealId = :id")
    Meals getById(int id);


    @Insert
    void insertMeals(Meals meals);

    @Delete
    void deleteMeal(Meals meals);
}
