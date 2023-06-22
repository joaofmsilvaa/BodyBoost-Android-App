package com.example.bodyboost;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ExerciseStepsDao {

    @Query("SELECT image FROM exercisesteps WHERE exerciseId = :exerciseId")
    List<String> getExerciseSteps(int exerciseId);

}
