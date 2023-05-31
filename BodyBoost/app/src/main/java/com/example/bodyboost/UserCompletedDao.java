package com.example.bodyboost;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface UserCompletedDao {

    @Query("SELECT COUNT(completed)  / COUNT(exerciseId) * 100 FROM usercompleted WHERE userId = :userId AND dayId = :dayId")
    float percentageCompleted(int userId, int dayId);

}
