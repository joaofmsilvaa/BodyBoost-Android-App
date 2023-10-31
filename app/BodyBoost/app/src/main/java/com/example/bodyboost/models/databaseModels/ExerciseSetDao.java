package com.example.bodyboost.models.databaseModels;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.bodyboost.models.ExerciseSet;

/*
Implements the methods for the exerciseSet Querrys
*/
@Dao
public interface ExerciseSetDao {


    @Query("SELECT COUNT(exerciseId) FROM exerciseset WHERE dayId = :day")
    int getAmmountOfExercisesInSet(int day);

    @Query("SELECT exerciseSet.* " +
            "FROM exerciseSet " +
            "WHERE exerciseSet.exerciseId = :exerciseId ")
    ExerciseSet getInfosForExercise(int exerciseId);


}
