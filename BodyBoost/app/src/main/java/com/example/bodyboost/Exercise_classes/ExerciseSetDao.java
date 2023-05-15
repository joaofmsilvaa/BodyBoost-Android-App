package com.example.bodyboost.Exercise_classes;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.bodyboost.Exercise;

import java.util.List;

@Dao
public interface ExerciseSetDao {

    @Query("SELECT * FROM exerciseset")
    List<ExerciseSet> getAll();

    @Query("SELECT e.*\n" +
            "FROM Exercise e\n" +
            "JOIN ExerciseSet es ON e.exerciseId = es.exerciseId\n" +
            "WHERE es.exerciseSetId = :id;")
    List<Exercise> getExercisesFromSet(int id);

}
