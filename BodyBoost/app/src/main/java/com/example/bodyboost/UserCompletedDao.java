package com.example.bodyboost;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserCompletedDao {

    @Query("SELECT COUNT(userId) FROM usercompleted WHERE userId = :userId AND dayId = :dayId")
    int ammountOfExercisesInDay(int userId, int dayId);


    @Query("SELECT COUNT(completed) FROM UserCompleted WHERE userId = :userId AND dayId = :dayId AND completed = 1")
    int ammountCompleted(int userId, int dayId);


    @Query("SELECT completed FROM UserCompleted WHERE userId = :userId AND dayId = :dayId AND exerciseId = :exerciseId")
    Boolean checkIfExerciseCompleted(int userId, int dayId, int exerciseId);


    @Query("SELECT usercompleted.exerciseId FROM usercompleted, workoutplan WHERE usercompleted.dayId = :dayId AND workoutplan.planId = :planId")
    List<Integer> getExercisesInDay(int dayId, int planId);


    @Update
    void updateCompleted(UserCompleted userCompleted);


    @Insert
    void insert(UserCompleted userCompleted);
}