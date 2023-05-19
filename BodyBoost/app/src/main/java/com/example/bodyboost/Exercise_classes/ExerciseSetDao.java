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


    /*
    Selects all the information from the exercises that are in the
    exercise set with the given dayId
     */
    @Query("SELECT exercise.* " +
            "FROM exerciseset, exercise " +
            "WHERE exerciseSet.dayId = :id AND exerciseset.exerciseId = exercise.exerciseId")
    List<Exercise> getExercisesInSet(int id);

    /*
    Selects all the information from the exerciseSet with the given dayId
     */
    @Query("SELECT * FROM exerciseset WHERE dayId = :day")
    List<ExerciseSet> getSetByDay(int day);

    /*
    Updates the exerciseSet with the given day and exerciseId and sets it to completed
     */
    @Query("UPDATE or REPLACE exerciseset SET completed = 'true' WHERE dayId = :day AND exerciseId = :exerciseId")
    void completedExercise(int day, int exerciseId);

    @Query("SELECT completed FROM exerciseset WHERE dayId = :day AND exerciseId = :exerciseId")
    Boolean checkCompleted(int day, int exerciseId);
}
