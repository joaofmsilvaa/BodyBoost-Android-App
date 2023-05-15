package com.example.bodyboost.Exercise_classes;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ExerciseSetDao {

    @Query("SELECT * FROM exerciseset")
    List<ExerciseSet> getAll();

}
