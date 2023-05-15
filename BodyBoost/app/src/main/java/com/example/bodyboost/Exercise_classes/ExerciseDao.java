package com.example.bodyboost.Exercise_classes;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.bodyboost.Exercise;

import java.util.List;

@Dao
public interface ExerciseDao {

    @Query("select * from exercise")
    List<Exercise> getAll();

}
