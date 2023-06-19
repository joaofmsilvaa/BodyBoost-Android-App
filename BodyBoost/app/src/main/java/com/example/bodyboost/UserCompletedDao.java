package com.example.bodyboost;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bodyboost.Exercise_classes.ExerciseSet;

import java.util.List;

@Dao
public interface UserCompletedDao {

    @Query("SELECT exercise.* " +
            "FROM exercise, usercompleted " +
            "WHERE userId = :userId AND dayId = :dayId AND exercise.exerciseId = usercompleted.exerciseId")
    List<Exercise> getExercisesForUser(int userId, int dayId);

    @Query("SELECT COUNT(userId) FROM usercompleted WHERE userId = :userId AND dayId = :dayId")
    int ammountOfExercisesInDay(int userId, int dayId);


    @Query("SELECT COUNT(completed) FROM UserCompleted WHERE userId = :userId AND dayId = :dayId AND completed = 1")
    int ammountCompleted(int userId, int dayId);


    @Query("SELECT completed FROM UserCompleted WHERE userId = :userId AND dayId = :dayId AND exerciseId = :exerciseId")
    int checkIfExerciseCompleted(int userId, int dayId, int exerciseId);


    @Query("UPDATE usercompleted SET completed = :status WHERE usercompleted.dayId = :dayId AND userId = :userId AND exerciseId = :exerciseId")
    void updateExerciseCompleted(int status,int dayId, int userId, int exerciseId);

    @Insert
    void insert(UserCompleted userCompleted);

    @Query("DELETE FROM UserCompleted WHERE userId = :id")
    void deleteByUserId(int id);

}