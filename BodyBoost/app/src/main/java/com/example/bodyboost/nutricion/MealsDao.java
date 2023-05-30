package com.example.bodyboost.nutricion;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealsDao {

    @Query("SELECT * FROM Meals")
    List<Meals> getAll();

}
