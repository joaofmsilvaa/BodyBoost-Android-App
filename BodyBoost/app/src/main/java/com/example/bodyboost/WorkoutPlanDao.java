package com.example.bodyboost;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.bodyboost.Exercise_classes.ExerciseSet;

import java.util.List;

@Dao
public interface WorkoutPlanDao {

    @Query("SELECT * FROM workoutplan")
    List<WorkoutPlan> getAll();

    @Query("SELECT exercise.* \n" +
            "FROM exercise,workoutplan, userplan, exerciseset\n" +
            "WHERE workoutplan.planId = :planId " +
            "AND userplan.planId = workoutplan.planId " +
            "AND workoutplan.exerciseId = exercise.exerciseId " +
            "AND exerciseset.dayId = :day " +
            "AND exerciseset.exerciseId = exercise.exerciseId")
    List<Exercise> getExercisesFromPlan(int planId, int day);


    @Query("SELECT exercise.* FROM exercise, usercompleted WHERE dayId = :dayId AND userId = :userId AND userCompleted.exerciseId = exercise.exerciseId")
    List<Exercise> getExercises(int userId, int dayId);


    @Query("SELECT DISTINCT exerciseSet.*\n" +
            "FROM exercise, workoutplan, userplan, exerciseset\n" +
            "WHERE workoutplan.planId = :planId\n" +
            "  AND userplan.planId = workoutplan.planId\n" +
            "  AND workoutplan.exerciseId = exercise.exerciseId\n" +
            "  AND exerciseset.dayId = :day\n" +
            "  AND exerciseset.exerciseId = exercise.exerciseId\n" +
            "  AND workoutPlan.exerciseId = exerciseSet.exerciseId")
    List<ExerciseSet> getExerciseInfosFromPlan(int planId, int day);


    @Query("SELECT exerciseId FROM WorkoutPlan WHERE planId = :planId")
    List<Integer> getAllExerciseIds(int planId);


    @Query("SELECT exerciseId FROM WorkoutPlan WHERE planId = :planId AND dayId = :dayId")
    List<Integer> getExercisesInDay(int planId, int dayId);
}
