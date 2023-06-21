package com.example.bodyboost.Exercise_classes;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bodyboost.Exercise;

import java.util.List;

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
