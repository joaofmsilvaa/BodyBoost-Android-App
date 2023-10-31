package com.example.bodyboost.models.databaseModels;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface DayWorkoutDao {

    @Query("SELECT description FROM dayworkout WHERE dayId = :dayId AND planId = :planId")
    String getDescriptionByDayPlan(int dayId, int planId);

}
