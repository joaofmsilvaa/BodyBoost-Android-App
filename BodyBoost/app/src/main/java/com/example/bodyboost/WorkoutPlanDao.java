package com.example.bodyboost;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WorkoutPlanDao {

    @Query("SELECT * FROM workoutplan")
    List<WorkoutPlan> getAll();

}
