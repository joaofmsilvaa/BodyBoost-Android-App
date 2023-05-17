package com.example.bodyboost.Exercise_classes;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.bodyboost.Exercise;

import java.util.List;

@Dao
public interface ExerciseSetDao {

    @Query("SELECT * FROM exerciseset")
    List<ExerciseSet> getAll();

    @Query("SELECT exercise.* " +
            "FROM exerciseset, exercise " +
            "WHERE exerciseSet.dayId = :id AND exerciseset.exerciseId = exercise.exerciseId")
    List<Exercise> getAllExercisesInSet(int id);

    @Query("SELECT * FROM exerciseset WHERE dayId = :day")
    List<ExerciseSet> getSetByDay(int day);
}
