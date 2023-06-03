package com.example.bodyboost;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface UserCompletedDao {

    @Query("SELECT COUNT(userId) FROM usercompleted WHERE userId = :userId AND dayId = :dayId")
    int ammountOfExercisesInDay(int userId, int dayId);

    @Query("SELECT COUNT(completed) FROM UserCompleted WHERE userId = :userId AND dayId = :dayId AND completed = 1")
    int ammountCompleted(int userId, int dayId);

    @Query("SELECT completed FROM UserCompleted WHERE userId = :userId AND dayId = :dayId AND exerciseId = :exerciseId")
    Boolean checkIfExerciseCompleted(int userId, int dayId ,int exerciseId);


    @Query("UPDATE usercompleted SET completed = :completed WHERE userId = :userId AND dayId = :dayId AND exerciseId = :exerciseId")
    void updateCompleted(int completed , int userId, int dayId, int exerciseId);
}
