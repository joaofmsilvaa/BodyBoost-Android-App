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
    @Query("SELECT * FROM exerciseset WHERE dayId = :day ORDER BY orderIndex")
    List<ExerciseSet> getSetByDay(int day);

    @Query("SELECT COUNT(exerciseId) FROM exerciseset WHERE dayId = :day")
    int getAmmountOfExercisesInSet(int day);

    @Query("SELECT exerciseset.* " +
            "FROM exerciseset, workoutplan " +
            "WHERE workoutplan.planId = :planId AND exerciseset.dayId = :day AND workoutPlan.exerciseId = exerciseSet.exerciseId")
    List<ExerciseSet> getExerciseInfosFromPlan(int planId, int day);

}
